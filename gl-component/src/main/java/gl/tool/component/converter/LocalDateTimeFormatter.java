package gl.tool.component.converter;

import gl.tool.util.time.DateConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author gl
 * @version 1.0
 * @date 2019/01/31
 * @description: 类描述: 在 HTTP 请求中 字符串转换成 LocalDateTime
 * 注册方式: ConversionService
 **/
@Component
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        text = text.trim();
        if (text.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return LocalDateTime.parse(text, DateConst.DEFAULT_DATE_TIME_FORMAT);
        }
        if (text.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
        }
        throw new IllegalArgumentException("非法值:'" + text + "'");
    }
    
    @Override
    public String print(LocalDateTime object, Locale locale) {
        return object.format(DateTimeFormatter.ofPattern(DateConst.DEFAULT_LOCAL_DATE_TIME));
    }
}
