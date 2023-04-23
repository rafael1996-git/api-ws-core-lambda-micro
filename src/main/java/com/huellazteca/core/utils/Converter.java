package com.huellazteca.core.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Converter {
    public static JsonObject toJsonObject(Object o) {
        JsonObject jsonObject;
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseString(GsonParser.serialize(o));
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
        } finally {
            jsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        }

        return jsonObject;
    }

    public static <T> T toModel(String json, Object o) {
        return (T) GsonParser.deserialize(json, o.getClass());
    }
}
