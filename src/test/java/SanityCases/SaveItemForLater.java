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

public class SaveItemForLater extends DriverType{
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
    public void saveForLater()
    {
        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        cart.saveForLater("How to Stop Worrying and Start Living");
        extnUserLogin.signout();

    }
    @AfterClass
    public void close()
    {
        driverClose();
    }

    public void checkItemsList()
    {
        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        cart.verifyCartItem("How to Stop Worrying and Start Living");
        extnUserLogin.signout();
    }

}
