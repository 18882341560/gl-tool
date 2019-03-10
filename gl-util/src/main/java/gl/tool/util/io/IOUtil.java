package gl.tool.util.io;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Assert;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author gl
 * @version 1.0
 * @date 2019/03/01
 * @description: 类描述: 输入输出工具
 **/
public class IOUtil {

    private IOUtil() {
    }

    /**
     * 输入流转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String getBase64FromInputStream(InputStream inputStream) throws IOException {
        Assert.notNull(inputStream, "输入流不能为 null");
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            //代表一次最多读取1KB的内容
            byte[] buffer = new byte[1024];
            //代表实际读取的字节数
            int length = 0;
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                //length 代表实际读取的字节数
                byteArrayOutputStream.write(buffer, 0, length);
            }
            //缓冲区的内容写入到文件
            byteArrayOutputStream.flush();
            data = byteArrayOutputStream.toByteArray();
        }
        byte[] base64 = Base64.encodeBase64(data);
        if (Objects.nonNull(base64)) {
            return new String(base64);
        }
        return null;
    }
}
