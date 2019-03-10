package gl.tool.component.excel;

import lombok.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/21
 * @description: 类描述: excel 单元格对象
 **/
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcelCell {
    /**
     * 字符串内容
     */
    private String content;
    /**
     * 单元格类型
     */
    private CellType type;
    /**
     * 单元格行索引
     */
    private Integer rowIndex;
    /**
     * 单元格列索引
     */
    private Integer columnIndex;
    /**
     * 单元格样式索引
     */
    private Integer styleIndex;
    /**
     * 单元格宽度
     */
    private Integer width;
    /**
     * 单元格高度
     */
    private Integer height;
    /**
     * Excel 单元格
     */
    private Cell cell;
}
