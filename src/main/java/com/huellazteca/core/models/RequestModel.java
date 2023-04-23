package com.huellazteca.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RequestModel extends BaseModel{
    private final static long serialVersionUID = 7468861301173478393L;

    @SerializedName("data")
    private String data;
}
