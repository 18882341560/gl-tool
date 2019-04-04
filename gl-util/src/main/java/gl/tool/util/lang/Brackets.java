package gl.tool.util.lang;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author gl
 * @version 1.0
 * @Email: 110.com
 * @date 2019-03-14
 * @description: 类描述: 括号相关工具类
 **/
class Brackets {

    //负责映射的哈希表。
    private static HashMap<Character, Character> mappings;


    private Brackets() {
    }

    // 用映射初始化哈希映射。
    static {
        mappings = Maps.newHashMap();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    /**
     * 括号验证
     * @param s 字符串
     * @return boolean
     */
    public static boolean isValid(String s) {
        if (Strings.isNullOrEmpty(s)) {
            throw new RuntimeException("param is null or empty");
        }
        s = getBrackets(s);
        char[] chars = s.toCharArray();
        // 初始化要在算法中使用的堆栈。
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            // 如果当前字符是右括号。
            if (mappings.containsKey(c)) {
                // 获取堆栈的顶部元素。如果堆栈为空，则将虚拟值设置为“”
                char topElement = stack.empty() ? '#' : stack.pop();
                // 如果此括号的映射与堆栈的top元素不匹配，则返回false。
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                //如果它是一个开口支架，将其推到堆栈上。
                stack.push(c);
            }
        }
        // 如果堆栈仍然包含元素，则它是无效的表达式。
        return stack.isEmpty();
    }


    private static String getBrackets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (mappings.containsKey(c) || mappings.containsValue(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}