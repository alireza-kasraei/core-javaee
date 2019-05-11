package net.devk.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By shsabet on 2/27/2018.
 */
public class DateHelper {

    public static final String FORMAT_DATE = "yyyy-MM-dd";

    private DateHelper() {
    }

    public static String getGregorianFormat(Date date) {
        return new SimpleDateFormat(FORMAT_DATE).format(date);
    }

}
