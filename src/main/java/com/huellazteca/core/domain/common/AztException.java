package com.huellazteca.core.domain.common;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AztException {
    @SerializedName("exceptionMessage")
    String exceptionMessage;

    @SerializedName("requestID")
    String requestID;
}
