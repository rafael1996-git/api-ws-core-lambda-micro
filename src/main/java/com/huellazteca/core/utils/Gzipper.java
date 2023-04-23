package com.huellazteca.core.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Gzipper {
    public static String unGzip(String gzippedString) throws IOException {
        InputStreamReader isr;
        isr = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(gzippedString))), StandardCharsets.UTF_8);
        StringWriter sw = new StringWriter();
        char[] chars = new char[1024];
        for (int len; (len = isr.read(chars)) > 0; ) {
            sw.write(chars, 0, len);
        }
        return sw.toString();
    }

    public static String gZip(String s) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        OutputStreamWriter osw = new OutputStreamWriter(gzip, StandardCharsets.UTF_8);
        osw.write(s);
        osw.close();
        return Base64.getEncoder().encodeToString(bos.toByteArray());
    }
}
