package com.huellazteca.core.domain.common;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SQSRequest {
    @SerializedName("Records")
    List<SQSMessage> records;
}
