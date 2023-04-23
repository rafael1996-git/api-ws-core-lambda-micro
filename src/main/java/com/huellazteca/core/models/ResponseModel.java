package com.huellazteca.core.models;

import com.google.gson.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseModel extends BaseModel{
    private final static long serialVersionUID = 7468861301173478393L;

    private Integer code;

    private Boolean success = Boolean.FALSE;

    private S3Model s3 = new S3Model("", "", "");

    private List<JsonObject> items;

    private MessageModel message;

    private String url = "";
}
