package com.huellazteca.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Parser {
    public static String cadena(Object value, String defVal) {
        String cadena = defVal;

        try {
            if (value != null && !Validator.isNullOrEmptyString(value.toString()))
                cadena = value.toString().trim();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cadena;
    }

    public static String cadena(Object value) {
        return Parser.cadena(value, "");
    }

    public static int entero(Object value, int defVal) {
        int entero = defVal;

        try {
            entero = Integer.parseInt(Parser.cadena(value));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return entero;
    }

    public static int entero(Object value) {
        return entero(value, 0);
    }

    private static java.sql.Date fecha(String value, java.sql.Date defVal, String format) {
        java.sql.Date date = defVal;

        try {
            Date dt = fechaConHora(value, null, format);

            if (dt != null)
                date = new java.sql.Date(dt.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return date;
    }

    public static java.sql.Date fecha(String value, String format) {
        return fecha(value, null, format);
    }

    public static java.sql.Date fecha(String value) {
        return fecha(value, null, Constants.SHORT_DATE_FORMAT);
    }

    private static Date fechaConHora(Object value, Date defVal, String format) {
        Date fechaConHora = defVal;

        try {
            fechaConHora = new SimpleDateFormat(format).parse(value.toString().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fechaConHora;
    }

    public static Date fechaConHora(Object value, String format) {
        return fechaConHora(value, null, format);
    }
}
