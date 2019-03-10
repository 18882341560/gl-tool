package gl.tool.component.excel;

import gl.tool.util.file.FileUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.util.Objects;


/**
 * @author gl
 * @version 1.0
 * @date 2019/02/22
 * @description: 类描述:
 **/
public class ExcelUtil {
    private ExcelUtil() {
    }

    @Getter
    @AllArgsConstructor
    public enum TYPE {
        /**
         * xls 文件后缀
         */
        XLS("xls"),
        /**
         * xlsx 文件后缀
         */
        XLSX("xlsx");

        private String suffix;

    }

    /**
     * 获取 excel 文件类型
     */
    public static ExcelUtil.TYPE getType(File file) {
        if (Objects.equals(FileUtil.getSuffix(file),TYPE.XLS.getSuffix())) {
            return TYPE.XLS;
        }
        if (Objects.equals(FileUtil.getSuffix(file),TYPE.XLSX.getSuffix())) {
            return TYPE.XLSX;
        }
        return null;
    }
}
