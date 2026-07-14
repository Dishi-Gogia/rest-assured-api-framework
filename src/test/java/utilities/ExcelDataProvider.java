package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

/**
 * DataProvider class for supplying Excel test data.
 * Sheet name is derived dynamically from the test method name.
 */
public class ExcelDataProvider {

    /**
     * Reads test data from Excel and supplies it to TestNG tests.
     * The sheet name must match the test method name.
     *
     * Example:
     * Test Method: verifyUserRegistration()
     * Sheet Name : verifyUserRegistration
     *
     * @param method Test method being executed
     * @return Object[][] containing test data
     * @throws Exception if Excel file or sheet is not found
     */
    @DataProvider(name = "excelData")
    public Object[][] getData(Method method) throws Exception {

        String sheetName = method.getName();

        return ExcelUtils.getExcelData(
                ConfigReader.getProperty("testDataPath"),
                sheetName);
    }
}