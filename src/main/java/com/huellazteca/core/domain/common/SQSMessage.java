package com.huellazteca.core.domain.common;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SQSMessage {
    @SerializedName("messageId")
    String messageId;

    @SerializedName("body")
    String body;
}
