package gl.tool.component.converter;

import gl.tool.util.time.DateConst;
import gl.tool.util.time.DateUtil;
import org.springframework.format.Formatter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
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
    public LocalDateTime parse(@Nonnull String text, @Nullable Locale locale)  {
        return DateUtil.getDateTimeByString(text);
    }

    @Override
    public String print(@Nonnull LocalDateTime object,@Nullable Locale locale) {
        return object.format(DateTimeFormatter.ofPattern(DateConst.DEFAULT_LOCAL_DATE_TIME));
    }
}
