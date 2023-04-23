package com.huellazteca.core.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
    private DateTimeUtils(){}

    public static String getFormattedDateTime() {
        final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = Instant.ofEpochMilli(new Date().getTime());
        ZoneId z = ZoneId.of("America/Mexico_City");
        ZonedDateTime zdt = instant.atZone(z);
        return zdt.toLocalDateTime().format(sdf);
    }
}
