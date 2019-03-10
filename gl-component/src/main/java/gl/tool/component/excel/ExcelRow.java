package gl.tool.component.excel;

import lombok.*;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/21
 * @description: 类描述: Excel 行对象
 **/
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcelRow {
    /**
     * 所属单元格列表对象
     */
    private List<ExcelCell> cellList;

    /**
     * 行索引
     */
    private Integer index;
    /**
     * 行高
     */
    private Integer height;
    /**
     * Excel 行
     */
    private Row row;
}
