package gl.tool.component.response;

import lombok.*;

import java.util.Collection;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/20
 * @description: 类描述: 响应 Data 为列表时的数据{@link ResResult#setData(Object)}
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResList<T> {
    private Collection<T> list;

    private Number count;
}
