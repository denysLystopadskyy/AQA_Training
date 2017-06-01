package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage implements LoadableComponentGLVersion {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void clearAndTypeToElement(String text, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(text);
    }
}
