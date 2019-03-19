package com.krushidj.hms.helpers;

import com.hms.modules.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateHelper {

    private static final Logger LOG = LoggerFactory.getLogger(DateHelper.class);
    private static final String YYYY_MM_MDD = "yyyyMMdd";
    private static final int ONE_DAY = 1;
    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * This method returns the current Timestamp.
     *
     * @return Timestamp
     */
    public static Timestamp getCurrentTimeStamp() {
        return (new Timestamp(System.currentTimeMillis()));
    }

    /**
     * Returns the Date previous to given number of days
     *
     * @param days
     * @return Date
     */
    public static Date getDateFromGivenDays(Integer days) {
        String stringDate = getStringDateFromDays(days);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_MDD);
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException ex) {
            LOG.error("Error occurred while parsing date {}", stringDate, ex);
            throw new BadRequestException("Error occurred while parsing date " + stringDate);
        }
    }

    public static Date getDateFromDateString(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException ex) {
            LOG.error("Error occurred while parsing date {}", dateString, ex);
            throw new BadRequestException("Error occurred while parsing date " + dateString);
        }
    }

    private static String getStringDateFromDays(Integer days) {
        LocalDate date = LocalDate.now();
        date = days == ONE_DAY ? date : date.minusDays(days);
        return date.format(DateTimeFormatter.ofPattern(YYYY_MM_MDD));
    }
}