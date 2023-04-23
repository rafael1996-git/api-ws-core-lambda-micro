package com.huellazteca.core.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context) {
        Date date = null;
        String strDate = jsonElement.getAsJsonPrimitive().getAsString();

        if (Validator.isNullOrEmptyString(strDate)) {
            Long time = null;
            String dateFormat = DateFormat.getFormat(strDate);

            if (Validator.isNullOrEmptyString(dateFormat))
                time = Parser.fechaConHora(strDate, dateFormat).getTime();

            if(time != null)
                date = new Date(time);
        }

        return date;
    }
}
