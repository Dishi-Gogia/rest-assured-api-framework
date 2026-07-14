package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.ConfigReader;

/**
 * Singleton class for managing Extent Reports instance.
 * Creates and configures Extent Report for test execution.
 */
public class ExtentManager {

    private static ExtentReports extent;

    /**
     * Returns ExtentReports instance.
     * Creates report if not already initialized.
     *
     * @return ExtentReports instance
     */
    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter = new ExtentSparkReporter( "reports/ExtentReport.html");
            reporter.config().setReportName( "Automation Test Execution Report");
            reporter.config().setDocumentTitle( "Automation Framework Report");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Framework", "REST Assured Automation Framework");
            extent.setSystemInfo("Author", "Dishi Gogia");
            extent.setSystemInfo("Environment", ConfigReader.getProperty("environment"));
            extent.setSystemInfo("Java Version",
                    System.getProperty("java.version"));

            extent.setSystemInfo("OS",
                    System.getProperty("os.name"));

            extent.setSystemInfo("User",
                    System.getProperty("user.name"));

            extent.setSystemInfo("Execution",
                    "Local");
        }

        return extent;
    }
}
