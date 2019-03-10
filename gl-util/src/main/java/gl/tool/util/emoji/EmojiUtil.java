package gl.tool.util.emoji;

import com.github.binarywang.java.emoji.EmojiConverter;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/13
 * @description: 类描述: emoji 工具类
 **/
public class EmojiUtil {

    private EmojiUtil() { }

    /**
     * 转换
     *
     * @param emojiString 原始字符串
     * @return 转换后的字符串
     */
    public static String toHtml(String emojiString) {
        return emojiString == null ? null : EmojiConverter.getInstance().toHtml(emojiString);
    }
}
