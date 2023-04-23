package com.huellazteca.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.Date;

public class GsonParser {
    public static <T> T deserialize(String json, Class<T> classType) {
        return GsonParser.deserialize(json, classType, Constants.LONG_DATE_FORMAT);
    }

    public static String serialize(Object o) {
        return GsonParser.serialize(o, Constants.LONG_DATE_FORMAT, true);
    }

    public static String serializeExcludingNulls(Object o) {
        return GsonParser.serialize(o, Constants.LONG_DATE_FORMAT, false);
    }

    public static <T> T deserializeExcludingNulls(String json, Class<T> classType, String dateFormat) {
        T t = null;

        try {
            Gson gson = GsonParser.create(dateFormat, false);
            t = gson.fromJson(json, classType);
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        }

        return t;
    }

    public static String serialize(Object o, String dateFormat, boolean includeNulls) {
        String json = null;

        try {
            Gson gson = GsonParser.create(dateFormat, includeNulls);
            json = gson.toJson(o);
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        }

        return json;
    }

    public static <T> T deserialize(String json, Class<T> classType, String dateFormat) {
        T t = null;

        try {
            Gson gson = GsonParser.create(dateFormat, true);
            t = gson.fromJson(json, classType);
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        }

        return t;
    }

    public static Gson create(String dateFormat, boolean includeNulls) {
        return includeNulls ? new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .setDateFormat(dateFormat)
                .serializeNulls()
                .create() : new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .setDateFormat(dateFormat)
                .create();
    }
}
