package gl.tool.component.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/21
 * @description: 类描述: 用于没有注册 bean 的类获取 spring 中的 bean {@link ApplicationContext#getBean(String)}
 **/
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
