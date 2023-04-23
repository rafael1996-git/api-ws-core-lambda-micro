package com.huellazteca.core.domain.common;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.huellazteca.core.models.BaseModel;
import com.huellazteca.core.models.MessageModel;
import com.huellazteca.core.utils.ConstantsMicro;
import com.huellazteca.core.utils.Converter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseModel extends BaseModel {
    private final static long serialVersionUID = 7468861301173478393L;


    @SerializedName(ConstantsMicro.PROPERTY_NAME_CODE)
    private Integer code;


    @SerializedName(ConstantsMicro.PROPERTY_NAME_SUCCESS)
    private Boolean success = Boolean.FALSE;


    @SerializedName(ConstantsMicro.PROPERTY_NAME_S3)
    private S3Model s3 = new S3Model("", "", "");


    @SerializedName(ConstantsMicro.PROPERTY_NAME_ITEMS)
    private List<JsonObject> items;


    @SerializedName(ConstantsMicro.PROPERTY_NAME_MESSAGE)
    private MessageModel message;


    @SerializedName(ConstantsMicro.PROPERTY_NAME_URL)
    private String url = "";

    public ResponseModel(Integer code, Boolean success, Object data) {
        this.code = code;
        this.success = success;
        this.items = Arrays.asList(Converter.toJsonObject(data));
        ;
    }
}
