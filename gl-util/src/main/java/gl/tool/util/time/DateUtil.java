package gl.tool.util.time;

import com.google.common.collect.Lists;
import gl.tool.util.model.SectionDateTime;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
