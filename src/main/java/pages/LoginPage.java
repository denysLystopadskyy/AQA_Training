package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.LogUtils;

/**
 * Created by denys.lystopadskyy on 5/30/2017.
 */
public class LoginPage extends BasePage {

    private WebElement login;

    private WebElement password;

    @FindBy(css = "button[class*=submit]")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openXCartSite() {
        LogUtils.testStep("Login to site");
        driver.get("https://demostore.x-cart.com/admin/admin.php?target=login");
        return this;
    }

    public LoginPage enterLoginInfo(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return this;
    }

    public void enterLogin(String loginName) {
        clearAndTypeToElement(loginName, login);
    }

    public void enterPassword(String passwordValue) {
        clearAndTypeToElement(passwordValue, password);
    }

    public AdminPage submitForm() {
        password.submit();
        return PageFactory.initElements(driver, AdminPage.class);
    }

    public AdminPage clickSubmitButton() {
        submitButton.click();
        return PageFactory.initElements(driver, AdminPage.class);
    }

    @Override
    public void load() {

    }

    @Override
    public void isLoaded() throws Error {

    }
}
