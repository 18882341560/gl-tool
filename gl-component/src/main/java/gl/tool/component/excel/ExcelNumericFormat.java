package gl.tool.component.excel;

import gl.tool.util.time.DateConst;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author gl
 * @version 1.0
 * @date 2019/02/22
 * @description: 类描述: excel 单元格是数值的处理类,包含了日期处理方式
 **/
public class ExcelNumericFormat {
    /**
     * 默认日期类的 index
     * get the index of the data format. Built in formats are defined at {@link BuiltinFormats}.
     *
     * @see DataFormat
     */
    private static List<Integer> DATE_INDEX = Arrays.asList(14, 31, 57, 58);
    /**
     * 默认时间类的 index
     * get the index of the data format. Built in formats are defined at {@link BuiltinFormats}.
     *
     * @see DataFormat
     */
    private static List<Integer> TIME_INDEX = Arrays.asList(20, 32);

    /**
     * {@link CellType#NUMERIC} 的处理方法,先处理日期,再处理整数,再处理小数,支持科学计数法(E)的处理
     */
    public String getNumericValue(Cell cell) {
        if (DateUtil.isCellDateFormatted(cell)) {
            // DataFormatter dateFormat = new DataFormatter();
            // dateFormat.setDefaultNumberFormat();
            // return dateFormat.formatCellValue(cell);
            Date date = cell.getDateCellValue();
            return DateFormatUtils.format(date, DateConst.DEFAULT_LOCAL_DATE_TIME);
        } else {
            double doubleVal = cell.getNumericCellValue();
            int format = cell.getCellStyle().getDataFormat();
            if (DATE_INDEX.contains(format)) {
                // 日期
                Date date = DateUtil.getJavaDate(doubleVal);
                return DateFormatUtils.format(date, DateConst.DEFAULT_LOCAL_DATE_TIME);
            } else if (TIME_INDEX.contains(format)) {
                // 时间
                Date date = DateUtil.getJavaDate(doubleVal);
                return DateFormatUtils.format(date, "HH:mm");
            } else {
                // 整数
                long longVal = Math.round(doubleVal);
                if (Double.parseDouble(longVal + ".0") == doubleVal) {
                    return String.valueOf(longVal);
                } else {
                    // 小数
                    return String.valueOf(doubleVal);
                }
                // DecimalFormat decimalFormat = new DecimalFormat("0");
                // value = decimalFormat.format(doubleVal);
            }
        }
    }

}
