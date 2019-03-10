package gl.tool.util.container;

import java.util.Collection;
import java.util.Map;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/21
 * @description: 类描述: 容器工具
 **/
public class ContainerUtil {

    private ContainerUtil() {
    }

    /**
     * 不为 Null 或 空
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return null != array && array.length > 0;
    }

    /**
     * 不为 Null 或 空
     */
    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return null != collection && !collection.isEmpty();
    }

    /**
     * 不为 Null 或 空
     */
    public static <K,V> boolean isNotEmpty(Map<K,V> map) {
        return null != map && !map.isEmpty();
    }
}
