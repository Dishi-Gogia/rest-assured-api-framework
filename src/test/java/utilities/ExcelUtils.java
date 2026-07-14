package utilities;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class for reading test data from Excel files.
 * Supports DataProvider integration with TestNG.
 */
public class ExcelUtils {

    /**
     * Reads data from Excel sheet and returns it as a 2D Object array.
     * First row is treated as header and skipped.
     *
     * @param filePath  Excel file path
     * @param sheetName Sheet name
     * @return Object[][] containing test data
     * @throws Exception if file or sheet is not found
     */
    public static Object[][] getExcelData(String filePath,String sheetName) throws Exception {

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < colCount; j++) {
                	Cell cell = sheet.getRow(i).getCell(j);

                	if (cell == null) {
                	    data[i - 1][j] = "";
                	    continue;
                	}

                	switch (cell.getCellType()) {

                	case STRING:
                	    data[i - 1][j] = cell.getStringCellValue();
                	    break;

                	case NUMERIC:

                	    if (DateUtil.isCellDateFormatted(cell)) {
                	        data[i - 1][j] =
                	                new SimpleDateFormat("yyyy-MM-dd")
                	                        .format(cell.getDateCellValue());
                	    } else {

                	        double numericValue = cell.getNumericCellValue();

                	        if (numericValue == (int) numericValue) {
                	            data[i - 1][j] = (int) numericValue;
                	        } else {
                	            data[i - 1][j] = numericValue;
                	        }
                	    }

                	    break;

                	case BOOLEAN:
                	    data[i - 1][j] = cell.getBooleanCellValue();
                	    break;

                	case BLANK:
                	    data[i - 1][j] = "";
                	    break;

                	default:
                	    data[i - 1][j] = "";
                	}
                	}
                }
            
            return data;
        }
    }
}