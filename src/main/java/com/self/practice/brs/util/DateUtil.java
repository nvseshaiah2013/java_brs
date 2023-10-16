package com.self.practice.brs.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateUtil {

    private static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Method to return the current day's date.
     *
     * @return {@link java.util.Date}
     */
    public static Date todayDate() {
        return new Date();
    }

    /**
     * Method to return the today's date as per the format "yyyy-MM-dd"
     *
     * @return {@link String}
     */
    public static String todayDateString() {
        return DEFAULT_FORMAT.format(todayDate());
    }

    /**
     * Returns the formatted String date for the passed {@link Date} object
     *
     * @param date passed of type {@link Date}
     * @return {@link String}
     */
    public static String formattedDate(Date date) {
        return Optional
                .ofNullable(date)
                .map(DEFAULT_FORMAT::format)
                .orElse(todayDateString());
    }
}
