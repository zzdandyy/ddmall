package pro.doublez.ddmall_api.utils;



import pro.doublez.ddmall_api.constant.StatusCode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author doublez
 * @version 1.0
 * @date 2021/7/15 22:27
 */
public class TimeUtil {
    public static Date getDate(String year, String month, String day, String hour, String minute, String second) {
        //调整格式
        if (month.length() == 1) month = "0" + month;
        if (hour.length() == 1) hour = "0" + hour;
        if (minute.length() == 1) minute = "0" + minute;
        if (second.length() == 1) second = "0" + second;

        String newDate = year + month + day + hour + minute + second;
        Date date;
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
//        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        try {
            date = df.parse(newDate);
            //时区
            date.setTime(date.getTime() + (8 * 60 * 60 * 1000));
        } catch (ParseException e) {
            throw new BaseException(StatusCode.SECKILLERROR, "时间格式错误");
        }
        return date;
    }
}
