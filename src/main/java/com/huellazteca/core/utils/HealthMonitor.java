package com.huellazteca.core.utils;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.huellazteca.core.exceptions.EnvironmentException;

import static com.huellazteca.core.utils.ConstantsMicro.*;

public enum HealthMonitor {
    INSTANCE;

    private AmazonSNS snsClient;
    private String topicArn;
    private String TOPIC;
    private String env;


    HealthMonitor() {
        try {
            TOPIC = Environment.get("appName");
            env = Environment.get("environment");
            this.configureReceivers();
        } catch (EnvironmentException e) {
            LogHandler.manageInternalException("HealthMonitor()", e);
        }
    }


    private void configureReceivers() {
        snsClient = AmazonSNSClientBuilder.standard().build();
        topicArn = createSNSTopic(snsClient);
        if (snsClient.listSubscriptionsByTopic(topicArn).getSubscriptions().isEmpty()) {
            subscribeToTopic(ConstantsMicro.EMAIL, "rmendezs@upax.com.mx");
            subscribeToTopic(ConstantsMicro.EMAIL, "dsolanog@elektra.com.mx");
            subscribeToTopic(ConstantsMicro.EMAIL, "bperezd@elektra.com.mx");
        }

    }

    public void subscribeToTopic(String protocol, String endpoint) {
        SubscribeRequest subscribe = new SubscribeRequest(topicArn, protocol, endpoint);
        snsClient.subscribe(subscribe);
    }

    private void publishException(String message) {
        try {
            snsClient.publish(new PublishRequest()
                    .withTopicArn(topicArn)
                    .withSubject(env.toUpperCase() + " - " + TOPIC)
                    .withMessage(message));
            LogHandler.writeLog(LogHandler.stringFactory("Message sent at ", topicArn));
        } catch (Exception e) {
            LogHandler.manageInternalException("HealthMonitor.subscribeToTopic()", e);
        }
    }


    public void publishException(String awsID, Object data, String exception) {
        try {

            String template = getTemplate();
            template = template.replace(APP_NAME, TOPIC);
            template = template.replace(TOPIC_EXCEPTION, env.toUpperCase() + " -- " + TOPIC);
            template = template.replace(AWS_ID, awsID);
            template = template.replace(DATA, GsonParser.serialize(data));
            template = template.replace(ENV, env);
            template = template.replace(DATE_TIME, DateTimeUtils.getFormattedDateTime());
            template += exception;
            publishException(template);
        } catch (Exception e) {
            LogHandler.manageInternalException("HealthMonitor.publishException()", e);
        }
    }

    public void publishException(Object data, String exception) {
        try {
            String template = getTemplate();
            template = template.replace(APP_NAME, TOPIC);
            template = template.replace(TOPIC_EXCEPTION, env.toUpperCase() + " -- " + TOPIC);
            template = template.replace(AWS_ID, "UNKNOWN");
            template = template.replace(DATA, GsonParser.serialize(data));
            template = template.replace(ENV, env);
            template = template.replace(DATE_TIME, DateTimeUtils.getFormattedDateTime());
            template += exception;
            publishException(template);
        } catch (Exception e) {
            LogHandler.manageInternalException("HealthMonitor.publishException()", e);
        }
    }

    public String createSNSTopic(AmazonSNS snsClient) {
        CreateTopicRequest createTopic = new CreateTopicRequest(env.toUpperCase() + "_" + TOPIC);
        CreateTopicResult result = snsClient.createTopic(createTopic);
        return result.getTopicArn();
    }

    private String getTemplate() {
        return TEMPLATE;
    }
}
