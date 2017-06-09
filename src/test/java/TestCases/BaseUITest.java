package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.AQACourseLogger;
import Utils.LogUtils;

/**
 * Created by denys.lystopadskyy on 5/19/2017.
 */
public class BaseUITest {

    protected WebDriver driver;

    @BeforeMethod
    public void testSetup(){
        String browserName = System.getProperty("browser.name");

        if (browserName == null){
            throw new IllegalArgumentException("Browser name is null");
        }

        driver = WebDriverFactory.getDriverInstance(browserName);
        driver = new EventFiringWebDriver(driver).register(new AQACourseLogger());
    }

    @AfterMethod
    public void testTearDown(ITestResult result) {
        if (result.isSuccess()) {
            if (driver != null) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File resultFile = new File(result.getName() + ".png");
                try {
                    FileUtils.copyFile(screenshot, resultFile);
                } catch (IOException e) {
                    LogUtils.info("Unable to save screenshot");
                }
            }
        }
        driver.quit();
    }

}
