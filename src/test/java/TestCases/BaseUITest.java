package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    }

    @AfterMethod
    public void testTearDown(){
        driver.quit();
    }

}
