package gl.tool.util.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/13
 * @description: 类描述: 时间\日期常量
 **/
public class DateConst {

    private DateConst() { }

    /**
     * 项目默认的 format yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 只精确到日期的 format yyyy-MM-dd
     */
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";


    /**
     * 项目默认的 formatter yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter DEFAULT_DATE_TIME;
    static {
        DEFAULT_DATE_TIME = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(" ")
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
    }

    /**
     * formatter yyyy/MM/dd HH:mm:ss
     */
    public static final DateTimeFormatter DATE_TIME_SLASH;
    static {
        DATE_TIME_SLASH = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('/')
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('/')
                .appendValue(DAY_OF_MONTH, 2)
                .appendLiteral(" ")
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(MINUTE_OF_HOUR, 2)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(SECOND_OF_MINUTE, 2)
                .optionalStart()
                .appendFraction(NANO_OF_SECOND, 0, 9, true)
                .toFormatter();
    }

}
