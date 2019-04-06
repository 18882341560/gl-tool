package gl.tool.util.lang;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/4/5
 * @describe: 关于操作系统的一些工具类
 */
public class SysUtil {

    private SysUtil() {
    }


    /**
     * 判断是不是windows系统
     * @return boolean
     */
    public static boolean isWindowsSys() {
        String os = System.getProperty("os.name");
        return os.toLowerCase().startsWith("win");
    }
}
