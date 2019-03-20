package gl.tool.util.time;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


    /**
     * 切割时间段
     * @param second 秒
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static  List<Map<String,String>> cutDateTime(long second, LocalDateTime startTime, LocalDateTime endTime){

        DateTimeFormatter formatter = DateConst.DEFAULT_DATE_TIME;
        List<Map<String,String>> list = Lists.newArrayList();

        while (startTime.isBefore(endTime)){
            LocalDateTime plusSeconds = startTime.plusSeconds(second);
            String formatEnd = formatter.format(plusSeconds);
            String formatStart = formatter.format(startTime);
            Map<String,String> map = Maps.newHashMap();
            map.put("startTime",formatStart);
            map.put("endTime",formatEnd);
            list.add(map);
            startTime = plusSeconds;
        }
        return list;
    }

}
