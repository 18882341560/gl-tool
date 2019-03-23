package gl.tool.util.pattern;

import java.util.regex.Pattern;

/**
 * @author gl
 * @Email: 110.com
 * @version 1.0
 * @date 2019-03-14
 * @description: 类描述: 匹配模式常量
 **/
public class PatternConst {

    private PatternConst() {
    }

    /**
     * 以数字开头
     */
    public static final Pattern START_WITH_NUMBER = Pattern.compile("[0-9]*");
    /**
     * 下划线接一个字母或数字
     */
    public static final Pattern UNDERLINE_WITH_CHAR = Pattern.compile("(_[A-Za-z0-9])");
}
