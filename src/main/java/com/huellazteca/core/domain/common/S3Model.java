package com.huellazteca.core.domain.common;

import com.google.gson.annotations.SerializedName;
import com.huellazteca.core.models.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class S3Model extends BaseModel {
    @SerializedName("bucket_name")
    String bucketName;

    @SerializedName("bucket_key")
    String bucketKey;

    @SerializedName("url")
    String url;
}
