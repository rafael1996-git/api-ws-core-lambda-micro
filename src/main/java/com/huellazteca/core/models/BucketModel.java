package com.huellazteca.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BucketModel extends BaseModel{
    @SerializedName("bucketName")
    String bucketName;

    @SerializedName("configurationFile")
    String configurationFile;

    @SerializedName("requestBucketUpload")
    String requestBucketUpload;
}
