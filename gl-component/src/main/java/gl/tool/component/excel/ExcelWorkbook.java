package gl.tool.component.excel;

import lombok.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/22
 * @description: 类描述:
 **/
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcelWorkbook {
    /**
     * 表单列表
     */
    List<ExcelSheet> sheetList;
    /**
     * 字体列表
     */
    List<Font> fontList;
    /**
     * CellStyle列表
     */
    List<CellStyle> cellStyleList;
    /**
     * excel 类型
     */
    ExcelUtil.TYPE excelType;
    /**
     * Excel 工作簿
     */
    Workbook workbook;
}
