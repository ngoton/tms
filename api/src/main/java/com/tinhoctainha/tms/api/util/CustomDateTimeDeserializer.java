package com.tinhoctainha.tms.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateTimeDeserializer extends JsonDeserializer<Date> {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        String dateString = jsonparser.getText();
        try {
            return formatter.parse(dateString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
