package com.rest.assured.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ExtentReport listener for test execution reporting
 * Generates HTML reports with test results
 */
public class ExtentReportListener implements ITestListener {
    
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    
    @Override
    public void onStart(ITestContext context) {
        // Create reports directory
        String reportPath = "test-output/ExtentReports/";
        File reportDir = new File(reportPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        
        // Generate report file name with timestamp
        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String reportFile = reportPath + "TestReport_" + timestamp + ".html";
        
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFile);
        sparkReporter.config().setReportName("REST API Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Framework", "REST Assured");
        
        Logger.info("Test execution started. Report will be generated at: " + reportFile);
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(
            result.getTestClass().getName() + " - " + result.getMethod().getMethodName()
        );
        extentTest.set(test);
        Logger.testStep("Starting Test: " + result.getMethod().getMethodName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed successfully");
        Logger.info("Test passed: " + result.getMethod().getMethodName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail("Test failed with exception: " + result.getThrowable().getMessage());
        Logger.error("Test failed: " + result.getMethod().getMethodName(), 
                    (Exception) result.getThrowable());
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test skipped");
        Logger.warn("Test skipped: " + result.getMethod().getMethodName());
    }
    
    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
            Logger.info("Test execution completed. Report generated successfully.");
        }
    }
}
