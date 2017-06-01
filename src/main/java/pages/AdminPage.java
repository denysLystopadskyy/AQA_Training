package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AdminPage extends BasePage{

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void clearAndTypeToElement(String text, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void load() {
        new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .submitForm();
    }

    public void isLoaded() throws Error {
        Assert.assertEquals(this.getPageUrl(), "https://demostore.x-cart.com/admin/admin.php");
    }
}
