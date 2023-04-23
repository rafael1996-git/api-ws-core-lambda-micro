package com.huellazteca.core.models;

import com.google.gson.JsonObject;
import com.huellazteca.core.utils.Converter;
import com.huellazteca.core.utils.GsonParser;

import java.io.Serializable;

public class BaseModel implements IModel, Serializable {
    private final static long serialVersionUID = 7468861301173478393L;

    @Override
    public JsonObject toJsonObject() {
        return Converter.toJsonObject(this);
    }

    @Override
    public <T> T toModel(String json) {
        return Converter.toModel(json, this);
    }

    @Override
    public String toJsonString() {
        return GsonParser.serialize(this);
    }
}
