package gl.tool.util.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/23
 * @describe: 时间范围
 */
@Data
@Builder
public class SectionDateTime implements Serializable {

    private static final long serialVersionUID = 6386711342380854133L;


    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
