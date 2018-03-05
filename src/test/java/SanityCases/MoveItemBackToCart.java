package SanityCases;

import Pages.Cart;
import Pages.ExternalUserLogin;
import Pages.HomePage;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveItemBackToCart extends DriverType
{
    private WebDriver driver;
    private ExternalUserLogin extnUserLogin;
    private HomePage homePage;
    private Cart cart;
    @BeforeClass
    public void setUp()
    {
        driver = launchApplication("https://www.amazon.in/","chrome");
        extnUserLogin = new ExternalUserLogin(driver);
        homePage = new HomePage(driver);
        cart = new Cart(driver);
    }

    @Test
    public void moveToCart()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
        cart.moveTOCart("The Power of your Subconcious Mind");
        extnUserLogin.signout();
    }
}
