package com.huellazteca.core;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.huellazteca.core.domain.common.AztException;
import com.huellazteca.core.domain.common.Request;
import com.huellazteca.core.domain.common.ResponseModel;
import com.huellazteca.core.domain.common.SQSRequest;
import com.huellazteca.core.utils.*;
import com.huellazteca.core.ws.Response;
import lombok.SneakyThrows;

import java.io.IOException;

public abstract class BaseApp implements RequestHandler<Object, Object> {
    protected abstract void init();
    protected abstract Object preHandler(Object request);
    protected abstract Object handleRequest(Object request) throws Exception;
    protected abstract Object postHandler(Object request);
    protected abstract APIGatewayProxyResponseEvent handleRequestProxy(APIGatewayProxyRequestEvent input);

    public boolean REQUEST_FROM_SQS = false;
    public boolean ENCRYPTED_REQUEST = true;
    public boolean ENCRYPTED_RESPONSE = true;
    public boolean GZIP_RESPONSE = false;

    private void logData(Object input, String awsId, boolean isInput) {
        try {
            LogHandler.writeLog(awsId, (isInput ? " RAW_REQUEST " : " RAW_RESPONSE "), " [", GsonParser.serialize(input), "]");
        } catch (Exception e) {
            LogHandler.manageInternalException("BaseApp.logData()", e);
        }
    }

    @SneakyThrows
    @Override
    public Object handleRequest(Object receivedData, final Context context) {
        context.getLogger();
        Object response;
        try {
            init();
            logData(receivedData, context.getAwsRequestId(), true);
            Object serializedRequest = prepareData(receivedData, context.getAwsRequestId());
            preHandler(serializedRequest);
            response = handleRequest(serializedRequest);
        } catch (Exception e) {
            response = processException(e, receivedData, context);
        }
        logData(response, context.getAwsRequestId(), false);
        response = postHandler(response);
        return prepareResponse(response, context.getAwsRequestId());
    }

    private Object prepareData(Object rawObject, String awsID) {
        String finalData = GsonParser.serialize(rawObject);
        if (REQUEST_FROM_SQS) {
            SQSRequest request = GsonParser.deserialize( finalData, SQSRequest.class);
            return request;
        }
        if (ENCRYPTED_REQUEST) {
            Request request = GsonParser.deserialize( finalData, Request.class);
            finalData = AztEncryptor.decode(request.getData());
            LogHandler.writeLog(LogHandler.stringFactory(awsID, " REQUEST[", finalData, "]"));
        }

        return finalData;
    }

    private Object prepareResponse(Object rawResponse, String awsID) throws IOException {

        if (ENCRYPTED_RESPONSE) {
            rawResponse = new Response(AztEncryptor.encode(GsonParser.serialize(new ResponseModel(200, true, this.GZIP_RESPONSE ? Gzipper.gZip(GsonParser.serialize(rawResponse)) : rawResponse))));
            LogHandler.writeLog(LogHandler.stringFactory(awsID, " RESPONSE[", GsonParser.serialize(rawResponse), "]"));
            return rawResponse;
        }
        return this.GZIP_RESPONSE ? Gzipper.gZip(GsonParser.serialize(rawResponse)) : rawResponse;
    }
    private Object processException(Exception e, Object receivedData, Context context) {
        HealthMonitor.INSTANCE.publishException(context.getAwsRequestId(), receivedData, e.getMessage());
        LogHandler.manageInternalException("processException", e);
        return new ResponseModel(500, false, new AztException(e.getMessage(), context.getAwsRequestId()));
    }
}
