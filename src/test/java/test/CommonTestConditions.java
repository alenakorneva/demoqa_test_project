package test;

import browser.BrowserUtils;
import driver.DriverSingleton;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import service.TestDataReaderFromConfigFile;
import utils.LogUtils;

public class CommonTestConditions {

    @BeforeTest
    public void setUp() {
        BrowserUtils.maximizeWindow();
        LogUtils.setLogInfoForStep(1, "Go to books page");
        BrowserUtils.openPage(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("baseURL"));
        LogUtils.cleanUpLogFile(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("logFilePath"));
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}