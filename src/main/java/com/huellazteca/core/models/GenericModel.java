package com.huellazteca.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class GenericModel extends BaseModel{
    private final static long serialVersionUID = 7468861301173478393L;

    @SerializedName("user_who_modified")
    String userWhoModified;

    @SerializedName("last_modification")
    Date lastModification;
}
