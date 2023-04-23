package com.huellazteca.core.utils;

public class DateFormat {
    private static final String[] REGEX = {
            Constants.REGEX_SHORT_ISO_DATE_FORMAT,
            Constants.REGEX_LONG_ISO_DATE_FORMAT,
            Constants.REGEX_SHORT_SLASH_ISO_DATE_FORMAT,
            Constants.REGEX_LONG_SLASH_ISO_DATE_FORMAT,
            Constants.REGEX_SHORT_DATE_FORMAT,
            Constants.REGEX_LONG_DATE_FORMAT,
            Constants.REGEX_SHORT_SLASH_DATE_FORMAT,
            Constants.REGEX_LONG_SLASH_DATE_FORMAT,
            Constants.REGEX_SHORT_DOT_DATE_FORMAT,
            Constants.REGEX_LONG_DOT_DATE_FORMAT,
            Constants.REGEX_SHORT_DOT_ISO_DATE_FORMAT,
            Constants.REGEX_LONG_DOT_ISO_DATE_FORMAT,
            Constants.REGEX_HOUR_FORMAT
    };

    private static final String[] PATTERNS = {
            Constants.SHORT_ISO_DATE_FORMAT,
            Constants.LONG_ISO_DATE_FORMAT,
            Constants.SHORT_SLASH_ISO_DATE_FORMAT,
            Constants.LONG_SLASH_ISO_DATE_FORMAT,
            Constants.SHORT_DATE_FORMAT,
            Constants.LONG_DATE_FORMAT,
            Constants.SHORT_SLASH_DATE_FORMAT,
            Constants.LONG_SLASH_DATE_FORMAT,
            Constants.SHORT_DOT_DATE_FORMAT,
            Constants.LONG_DOT_DATE_FORMAT,
            Constants.SHORT_DOT_ISO_DATE_FORMAT,
            Constants.LONG_DOT_ISO_DATE_FORMAT,
            Constants.LONG_HOUR_FORMAT,
            Constants.SHORT_HOUR_FORMAT
    };

    public static String getFormat(String strDate) {
        String format = "";

        if(!Validator.isNullOrEmptyArray(REGEX)) {
            for (int i = 0; i < REGEX.length; i++) {
                if (strDate.matches(REGEX[i])) {
                    if (REGEX[i].equals(Constants.REGEX_HOUR_FORMAT))
                        format = Parser.entero(strDate.substring(0, 2)) > 13 ? PATTERNS[i] : PATTERNS[i + 1];
                    else
                        format = PATTERNS[i];

                    break;
                }
            }
        }

        return format;
    }
}
