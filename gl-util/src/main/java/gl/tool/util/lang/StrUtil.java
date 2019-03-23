package gl.tool.util.lang;


import gl.tool.util.pattern.PatternConst;

import java.util.regex.Matcher;


/**
 * @author gl
 * @Email: 110.com
 * @version 1.0
 * @date 2019-03-13
 * @description: 类描述: 字符串工具类
 **/
public class StrUtil {

    private StrUtil() {
    }

    /**
     * 去掉下划线,并且下划线后面的首字母转大写
     * @param underLineString 参数
     * @return 字符串
     */
    public static String convertUnderLineToCamelCase(String underLineString) {
        String result = underLineString;
        Matcher matcher = PatternConst.UNDERLINE_WITH_CHAR.matcher(result);
        while (matcher.find()) {
            String temp = matcher.group(0);
            result = result.replaceAll(temp, temp.replaceAll("_", "")
                    .toUpperCase());
        }
        return result;
    }


    /**
     * 下划线转驼峰字符串
     * @param underLineString 参数
     * @return 驼峰字符串
     */
    public static String convertUnderLineToLowCamelCase(String underLineString) {
        String result = convertUnderLineToCamelCase(underLineString);
        /**
         * 第一个字母小写
         */
        String firstChar = String.valueOf(result.charAt(0)).toLowerCase();
        result = result.substring(1);
        result = firstChar + result;
        return result;
    }

    /**
     * 判断字符串是不是以数字开头
     * @param str 参数
     * @return boolean
     */
    public static boolean isStartWithNumber(String str) {
        Matcher isNum = PatternConst.START_WITH_NUMBER.matcher(str.charAt(0) + "");
        return isNum.matches();
    }
}
