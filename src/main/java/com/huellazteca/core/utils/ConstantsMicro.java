package com.huellazteca.core.utils;

public class ConstantsMicro {
    private ConstantsMicro(){

    }

    public static final String PROPERTY_NAME_CODE = "code";
    public static final String PROPERTY_NAME_MESSAGE = "message";
    public static final String PROPERTY_NAME_S3 = "s3";
    public static final String PROPERTY_NAME_SUCCESS = "success";
    public static final String PROPERTY_NAME_ITEMS = "items";
    public static final String PROPERTY_NAME_URL = "url";
    public static final String EMAIL = "email";

    public static final String APP_NAME = "@@APP_NAME@@";
    public static final String ENV = "@@ENV@@";
    public static final String TOPIC_EXCEPTION = "@@TOPIC_EXCEPTION@@";
    public static final String AWS_ID = "@@AWS_ID@@";

    public static final String DATA = "@@DATA@@";
    public static final String DATE_TIME = "@@DATE_TIME@@";


    public static final String TEMPLATE = "EXCEPTION\n" +
            "\n" +
            "Lambda: " + APP_NAME + "\n" +
            "Ocurred: " + TOPIC_EXCEPTION + "\n" +
            "Environment: " + ENV + "\n" +
            "\t\t\n" +
            "AWS ID to search in cloudwathc is: \n" + AWS_ID + "\n" +
            "\n" +
            "The exception was: \n" +
            "\n" +
            "Request:\n " + DATA + " \n" +
            "\n\n" +
            "Datetime \n" + DATE_TIME+"\n\nEXCEPTION DETAILS:\n\n";
}
