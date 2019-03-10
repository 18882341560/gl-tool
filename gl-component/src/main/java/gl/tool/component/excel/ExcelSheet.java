package gl.tool.component.excel;

import lombok.*;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/21
 * @description: 类描述: excel 对象
 **/
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcelSheet {
    /**
     * 内容行的列表
     */
    private List<ExcelRow> rowList;
    /**
     * 表单名
     */
    private String name;
    /**
     * Excel Sheet
     */
    private Sheet sheet;
}
