package SanityCases;

import pages.Cart;
import pages.externalUserLoginPage;
import pages.homePage;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data.Constants;

public class DeleteItemFromCart extends DriverType
{
    private WebDriver driver;
    private externalUserLoginPage extnUserLogin;
    private pages.homePage homePage;
    private Cart cart;
    private Constants constants;

    @BeforeClass
    public void setUp()
    {
        driver = launchApplication(constants.BaseUrl,constants.BrowserName);
        extnUserLogin = new externalUserLoginPage(driver);
        homePage = new homePage(driver);
        cart = new Cart(driver);
    }

    @Test
    public void removeItem()
    {
        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        cart.removeItem("The Power of your Subconcious Mind");
        extnUserLogin.signout();

    }
    @AfterClass
    public void close()
    {
        driverClose();
    }
}
