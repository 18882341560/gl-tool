package gl.tool.component.mvc.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author gl
 * @version 1.0
 * @date 2019/01/30
 * @description: 类描述: dao基本类
 **/
public interface BaseDao<T> {

    List<T> list(@Param("query") T query);

    int count(@Param("query") T query);

    T getById(@Param("id") Object id);

    boolean isExistById(@Param("id") Object id);

    int save(T object);

    int update(T object);

    int deleteById(@Param("id") Object id);

    int deleteByIds(@Param("ids") Object[] ids);
}
