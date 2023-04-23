package com.huellazteca.core.models;

import com.google.gson.JsonObject;

public interface IModel {
    JsonObject toJsonObject();

    String toJsonString();

    <T> T toModel(String json);
}
