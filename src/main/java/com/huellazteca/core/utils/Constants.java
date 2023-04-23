package com.huellazteca.core.utils;

public class Constants {
    public static final String ENV_DB_URL = "DB_URL";
    public static final String ENV_DB_USER = "DB_USER";
    public static final String ENV_DB_PASSWORD = "DB_PASSWORD";
    public static final String ENV_MASTER_KEY = "MASTER_KEY";
    public static final String ENV_PASSWORD_KEY = "PASSWORD_KEY";
    public static final String ENV_DELIVERY_STREAM_NAME = "DELIVERY_STREAM_NAME";
    public static final String ENV_APP_NAME = "APP_NAME";
    public static final String ENV_APP_ENVIRONMENT = "APP_ENVIRONMENT";

    public static final String SQL_VALIDATOR = "SELECT * FROM DUAL";

    public static final String APP_PROPERTIES_FILE = "app.properties";
    public static final String DEFAULT_PROPERTIES_FILE = "default.properties";
    public static final String DEFAULT_APP_PROPERTIES_FILE = "default_app.properties";
    public static final String UTF8_CONTENT_TYPE = "UTF-8";
    public static final String REQUEST_TYPE_JSON = "application/json";
    public static final int RESPONSE_SUCCESS_CODE = 200;
    public static final int RESPONSE_ERROR_CODE = 500;

    public static final long MAX_FILE_SIZE_LAMBDA_ALLOWED = 6000000L;


    public static final String PROPERTY_ENVIRONMENT = "environment";
    public static final String PROPERTY_CONFIGURATION_FILE = "configurationFile";
    public static final String PROPERTY_APP_NAME = "appName";

    public static final String FILES_BUCKET_NAME = ".request.files";
    public static final String CONFIG_BUCKET_NAME = ".survey.config";
    public static final String CONFIG_FILE_NAME = "config.json";

    public static final String HEALTH_CHECK_OK = "This health check is working ok";
    public static final String MISSING_PARAMETER = "You have a missing parameter";
    public static final String BAD_REQUEST = "Please verify your request";
    public static final String MALFORMED_REQUEST = "You request is malformed";
    public static final String ERROR_CONNECTION_BD = "Error de conexión a la BD";
    public static final String ERROR_DETAIL_CONNECTION_BD = "No se pudo establecer una conexión con la BD.";

    public static final String ENDPOINT_HEALTH_CHECK = "/health";
    public static final String ENDPOINT_MISSING_PARAMETER = "/missingParameter";
    public static final String ENDPOINT_ERROR = "/error";

    public static final String REGEX_DAY = "([0-2][0-9]|3[0-1])";
    public static final String REGEX_MONTH = "([0-1][0-2]|0[0-9])";
    public static final String REGEX_YEAR = "([0-9]{4})";
    public static final String REGEX_HOUR = "(([0-2][0-3])|([0-1][0-9]))";
    public static final String REGEX_MIN_OR_SEC = "([0-5][0-9])";

    public static final String REGEX_SLASH_SEPARATOR = "\\/";
    public static final String REGEX_DASH_SEPARATOR = "\\-";
    public static final String REGEX_DOT_SEPARATOR = "\\.";

    public static final String SHORT_HOUR_FORMAT = "hh:mm:ss";
    public static final String LONG_HOUR_FORMAT = "HH:mm:ss";

    public static final String SHORT_ISO_DATE_FORMAT = "dd-MM-yyyy";
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String SHORT_SLASH_ISO_DATE_FORMAT = "dd/MM/yyyy";
    public static final String SHORT_SLASH_DATE_FORMAT = "yyyy/MM/dd";
    public static final String SHORT_DOT_DATE_FORMAT = "yyyy.MM.dd";
    public static final String SHORT_DOT_ISO_DATE_FORMAT = "dd.MM.yyyy";

    public static final String LONG_ISO_DATE_FORMAT = SHORT_ISO_DATE_FORMAT + " " + LONG_HOUR_FORMAT;
    public static final String LONG_DATE_FORMAT = SHORT_DATE_FORMAT + " " + LONG_HOUR_FORMAT;
    public static final String LONG_SLASH_ISO_DATE_FORMAT = SHORT_SLASH_ISO_DATE_FORMAT + " " + LONG_HOUR_FORMAT;
    public static final String LONG_SLASH_DATE_FORMAT = SHORT_SLASH_DATE_FORMAT + " " + LONG_HOUR_FORMAT;
    public static final String LONG_DOT_DATE_FORMAT = SHORT_DOT_DATE_FORMAT + " " + LONG_HOUR_FORMAT;
    public static final String LONG_DOT_ISO_DATE_FORMAT = SHORT_DOT_ISO_DATE_FORMAT + " " + LONG_HOUR_FORMAT;

    public static final String REGEX_HOUR_FORMAT = REGEX_HOUR + ":" + REGEX_MIN_OR_SEC + ":" + REGEX_MIN_OR_SEC;

    public static final String REGEX_SHORT_ISO_DATE_FORMAT = REGEX_DAY + REGEX_DASH_SEPARATOR + REGEX_MONTH + REGEX_DASH_SEPARATOR + REGEX_YEAR;
    public static final String REGEX_SHORT_DATE_FORMAT = REGEX_YEAR + REGEX_DASH_SEPARATOR + REGEX_MONTH + REGEX_DASH_SEPARATOR + REGEX_DAY;

    public static final String REGEX_SHORT_SLASH_ISO_DATE_FORMAT = REGEX_DAY + REGEX_SLASH_SEPARATOR + REGEX_MONTH + REGEX_SLASH_SEPARATOR + REGEX_YEAR;
    public static final String REGEX_SHORT_SLASH_DATE_FORMAT = REGEX_YEAR + REGEX_SLASH_SEPARATOR + REGEX_MONTH + REGEX_SLASH_SEPARATOR + REGEX_DAY;

    public static final String REGEX_SHORT_DOT_ISO_DATE_FORMAT = REGEX_DAY + REGEX_DOT_SEPARATOR + REGEX_MONTH + REGEX_DOT_SEPARATOR + REGEX_YEAR;
    public static final String REGEX_SHORT_DOT_DATE_FORMAT = REGEX_YEAR + REGEX_DOT_SEPARATOR + REGEX_MONTH + REGEX_DOT_SEPARATOR + REGEX_DAY;

    public static final String REGEX_LONG_ISO_DATE_FORMAT = REGEX_SHORT_ISO_DATE_FORMAT + " " + REGEX_HOUR_FORMAT;
    public static final String REGEX_LONG_DATE_FORMAT = REGEX_SHORT_DATE_FORMAT + " " + REGEX_HOUR_FORMAT;

    public static final String REGEX_LONG_SLASH_ISO_DATE_FORMAT = REGEX_SHORT_SLASH_ISO_DATE_FORMAT + " " + REGEX_HOUR_FORMAT;
    public static final String REGEX_LONG_SLASH_DATE_FORMAT = REGEX_SHORT_SLASH_DATE_FORMAT + " " + REGEX_HOUR_FORMAT;

    public static final String REGEX_LONG_DOT_ISO_DATE_FORMAT = REGEX_SHORT_DOT_ISO_DATE_FORMAT + " " + REGEX_HOUR_FORMAT;
    public static final String REGEX_LONG_DOT_DATE_FORMAT = REGEX_SHORT_DOT_DATE_FORMAT + " " + REGEX_HOUR_FORMAT;
    public static final String EMPTY_STRING = "";

    public static final String CODE_SUCCESS = "200"; //Success
    public static final String ERROR_E001 = "E001"; //Request no valido


    public static final String MYSQL_DB_URL = "MYSQL_DB_URL";
    public static final String MYSQL_DB_USER = "MYSQL_DB_USER";
    public static final String MYSQL_DB_PASSWORD = "MYSQL_DB_PASSWORD";
    public static final String MYSQ_SQL_VALIDATOR = "SELECT  now()";
}
