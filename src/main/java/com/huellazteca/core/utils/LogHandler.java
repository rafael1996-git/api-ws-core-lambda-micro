package com.huellazteca.core.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static com.huellazteca.core.utils.DateTimeUtils.getFormattedDateTime;

public class LogHandler {
    private static Logger logging = LoggerFactory.getLogger(LogHandler.class);


    public static void manageException(String method, Exception e) throws Exception {
        Exception ex = new Exception(manageInternalException(method, e));
        ex.setStackTrace(e.getStackTrace());
        throw ex;
    }

    public static String manageInternalException(String method, Exception e) {
        String stacktrace = ExceptionUtils.getStackTrace(e);
        logging.error(stringFactory(getFormattedDateTime(), " Mexico_City - ", "[", method, "]", stacktrace));
        return stacktrace;
    }

    public static void writeLog(String message) {
        logging.info(stringFactory(getFormattedDateTime(), " Mexico_City - ", message));
    }

    public static void writeLog(String... strings) {
        logging.info(stringFactory(getFormattedDateTime(), " Mexico_City - ", stringFactory(strings)));
    }

    public static String stringFactory(String... strings) {
        StringBuilder builder = new StringBuilder();
        List<String> data = Arrays.asList(strings);
        data.forEach(s -> builder.append(s));
        return builder.toString();
    }
}
