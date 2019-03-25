package gl.tool.util.time;

import com.google.common.collect.Lists;
import gl.tool.util.model.SectionDateTime;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/12
 * @description: 类描述: 时间\日期处理工具类
 **/
public class DateUtil {

    private DateUtil() { }

    /**
     * 旧的时间类转化为字符串
     * @param date 日期
     * @param pattern 格式
     * @return 时间字符串
     */
    public static String getDateString(Date date,String pattern){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(pattern);
    }


    /**
     * 将日期和时间字符串转换为时间对象,必须制定日期
     * @param dateTime 参数
     * @return 日期时间
     */
    public static LocalDateTime getDateTimeByString(String dateTime) {
        if (Objects.isNull(dateTime)) {
            return null;
        }
        dateTime = dateTime.trim();
        if (dateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return LocalDateTime.parse(dateTime, DateConst.DEFAULT_DATE_TIME_FORMAT);
        }
        if (dateTime.matches("^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return LocalDateTime.parse(dateTime, DateConst.LOCAL_DATE_TIME_SLASH_FORMAT);
        }
        if (dateTime.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return LocalDate.parse(dateTime, DateConst.DEFAULT_LOCAL_DATE_FORMAT).atStartOfDay();
        }
        throw new IllegalArgumentException("非法值:'" + dateTime + "'");
    }

    /**
     * 从日期字符串获取日期对象
     * @param date 日期
     * @return 日期对象
     */
    public static LocalDate getDateByString(@NonNull String date) {
        Assert.notNull(date,"日期不能为空");
        date = date.trim();
        if (date.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return LocalDate.parse(date,DateConst.DEFAULT_LOCAL_DATE_FORMAT);
        }
        if (date.matches("^\\d{4}/\\d{1,2}/\\d{1,2}$")) {
            return LocalDate.parse(date, DateConst.DATE_SLASH);
        }
        throw new IllegalArgumentException("非法值:'" + date + "'");
    }

    /**
     * 从时间字符串获取时间对象
     * @param time 时间
     * @return  时间对象
     */
    public static LocalTime getTimeByString(@NonNull String time) {
        Assert.notNull(time,"日期不能为空");
        time = time.trim();
        if (time.matches("^{1}\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            return LocalTime.parse(time, DateConst.DEFAULT_TIME);
        }
        if (time.matches("^{1}\\d{1,2}:\\d{1,2}")) {
            return LocalTime.parse(time, DateConst.DEFAULT_TIME);
        }
        throw new IllegalArgumentException("非法值:'" + time + "'");
    }


    /**
     * 切割时间段
     * @param second 秒
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 时间段集合
     */
    public static  List<SectionDateTime> cutDateTime(long second, LocalDateTime startTime, LocalDateTime endTime){

        List<SectionDateTime> list = Lists.newArrayList();
        while (startTime.isBefore(endTime)){
            LocalDateTime plusSeconds = startTime.plusSeconds(second);
            if(plusSeconds.isAfter(endTime)){
                plusSeconds = endTime;
            }
            SectionDateTime sectionDateTime = SectionDateTime.builder()
                    .startTime(startTime)
                    .endTime(plusSeconds)
                    .build();
            list.add(sectionDateTime);
            startTime = plusSeconds;
        }
        return list;
    }

}
