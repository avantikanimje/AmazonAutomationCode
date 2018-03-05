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

public class AddItemToCart extends DriverType{

    private WebDriver driver;
    private externalUserLoginPage extnUserLogin;
    private pages.homePage homePage;
    private Cart cart;
    private  Constants constants;
    @BeforeClass
    public void setUp()
    {
       driver = launchApplication(constants.BaseUrl,constants.BrowserName);
       extnUserLogin = new externalUserLoginPage(driver);
       homePage = new homePage(driver);
       cart = new Cart(driver);

    }
    @Test
    public void addItem()
    {

        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        homePage.SearchBar("Power of your Subconscious Mind");
        //homePage.btnAddToCart.click();
        System.out.println(cart.getCartTotal());
        extnUserLogin.signout();

    }
    @AfterClass
    public void close()
    {
        driverClose();
    }

    public void printListItems()
    {
        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        homePage.listOfSearchItems("The Power of your Subconscious Mind");
        extnUserLogin.signout();
    }
}
