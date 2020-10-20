package com.marufeb.fiverr;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OrderDate {
    private final String date;
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

    /**
     * Creates a new OrderDate
     * @param date must have the format "dd/mm/yy"
     * @throws IllegalDateFormatException Thrown when an it's not used the "dd/mm/yy" pattern
     */
    private OrderDate(String date) throws IllegalDateFormatException {
        try {
            format.parse(date);
            this.date = date;
        } catch (ParseException e) {
            throw new IllegalDateFormatException(e.getMessage());
        }
    }

    public static OrderDate parse(String date) throws IllegalDateFormatException {
        return new OrderDate(date);
    }

    public String getDate() {
        return date;
    }
}
