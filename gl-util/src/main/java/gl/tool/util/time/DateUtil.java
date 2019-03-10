package gl.tool.util.time;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.Date;

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
     * @return
     */
    public static String getDateString(Date date,String pattern){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(pattern);
    }
}
