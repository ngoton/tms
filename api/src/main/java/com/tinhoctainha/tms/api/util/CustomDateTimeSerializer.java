package com.tinhoctainha.tms.api.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateTimeSerializer extends JsonSerializer<Date> {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    public void serialize(Date value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(formatter.format(value));
    }
}
