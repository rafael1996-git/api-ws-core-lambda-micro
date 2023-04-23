package com.huellazteca.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class S3Model extends BaseModel{
    @SerializedName("bucket_name")
    String bucketName;

    @SerializedName("bucket_key")
    String bucketKey;

    @SerializedName("url")
    String url;
}
