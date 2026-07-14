package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(
                result.getTestClass().getRealClass().getSimpleName()
                + " - "
                + result.getMethod().getMethodName());

        extentTest.set(test);
        test.assignCategory(
                result.getTestClass().getRealClass().getSimpleName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    	extentTest.get().pass("All validations passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    	extentTest.get().fail("Test execution failed.");

        if (result.getThrowable() != null) {
            extentTest.get().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Test Skipped");

        if (result.getThrowable() != null) {
            extentTest.get().skip(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("Flushing Extent Report...");

        extent.flush();
    }
    
    public static ExtentTest getTest() {
        return extentTest.get();
    }

}
