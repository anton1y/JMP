package jmp.principleSD.utils;

import java.util.Date;
import org.apache.commons.lang.time.DateFormatUtils;

public class FormatUtil {

    public static String getToday() {
        String today = DateFormatUtils.format(new Date(), "dd-MMM-yyyy");
        return today;
    }

    public static String formatMessage(String messageType, String message){
        return messageType + " was sent : " + getToday() + ", Message : " +message;
    }
}