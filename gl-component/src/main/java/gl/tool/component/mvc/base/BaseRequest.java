package gl.tool.component.mvc.base;


import gl.tool.component.exception.ServiceException;

import java.util.List;

/**
 * @author gl
 * @version 1.0
 * @date 2019/01/30
 * @description: 类描述: manager基本类
 **/
public interface BaseRequest<T> {

    default List<T> list(T query) throws ServiceException {
        return null;
    }

    default Integer count(T query) throws ServiceException {
        return null;
    }

    default T getById(Object id) throws ServiceException {
        return null;
    }

    default Boolean isExistById(Object id) throws ServiceException{
        return null;
    }

    default Integer save(T object) throws ServiceException {
        return null;
    }

    default Integer update(T object) throws ServiceException {
        return null;
    }

    default Integer deleteById(Object id) throws ServiceException {
        return null;
    }

    default Integer deleteByIds(Object[] ids) throws ServiceException {
        return null;
    }

}
