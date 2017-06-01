package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;

public class AuthTests extends BaseUITest {

    private static final String DEMOSTORE_URL = "https://demostore.x-cart.com/admin/admin.php";

    @Test
    public void UserShouldBeLoginToAdminWithSubmit() {
        new AdminPage(driver).get();
    }

    @Test
    public void UserShouldBeLoginToAdminWithButtonClick() {
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .clickSubmitButton()
                .getPageUrl();

        Assert.assertEquals(currentPageUrl, DEMOSTORE_URL, "Current Url is different from expected");
    }
}
