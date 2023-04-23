package com.huellazteca.core.domain.common;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    @SerializedName("data")
    public String data;
}
