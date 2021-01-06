package com.neusoft.ump.utils.time;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {
    private static final Log log = LogFactory.getLog(DateTool.class);

    public static String getCurrentDateFormat() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    public static Long currentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static Long dateToTimeSeconds(String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long ts = 0;
        try {
            Date date = simpleDateFormat.parse(dateFormat);
            ts = date.getTime() / 1000;
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return ts;
    }
}
