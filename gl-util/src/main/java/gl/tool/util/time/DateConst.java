package gl.tool.util.time;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/13
 * @description: 类描述: 时间/日期常量
 **/
public class DateConst {

    private DateConst() { }
    public static final String DEFAULT_LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String LOCAL_DATE = "yyyy-MM-dd";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String LOCAL_DATE_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMAT;
    public static final DateTimeFormatter DEFAULT_LOCAL_DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final DateTimeFormatter LOCAL_DATE_TIME_SLASH_FORMAT;
    /**
     * formatter HH:mm:ss
     */
    public static final DateTimeFormatter DEFAULT_TIME = DateTimeFormatter.ISO_TIME;
    /**
     * formatter yyyy/MM/dd
     */
    public static final DateTimeFormatter DATE_SLASH;
    static {
        DATE_SLASH = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('/')
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('/')
                .appendValue(DAY_OF_MONTH, 2)
                .toFormatter();
    }
    static {
        DEFAULT_DATE_TIME_FORMAT = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(" ")
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
    }
    static {
        LOCAL_DATE_TIME_SLASH_FORMAT = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('/')
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('/')
                .appendValue(DAY_OF_MONTH, 2)
                .appendLiteral(" ")
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
    }
}
