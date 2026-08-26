package com.booleanuk.core;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

    private DateFormatter() {}

    public static String format(Instant instant) {
        if (instant == null) {
            return "";
        }
        return FORMATTER.format(instant);
    }
}
