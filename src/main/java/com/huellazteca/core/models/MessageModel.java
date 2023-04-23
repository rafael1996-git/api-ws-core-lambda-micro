package com.huellazteca.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MessageModel extends BaseModel{
    private final static long serialVersionUID = 7468861301173478393L;

    private Long id;

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("long_description")
    private String longDescription;

    private String code;

    public MessageModel(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
