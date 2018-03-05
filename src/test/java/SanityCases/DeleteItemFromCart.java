package SanityCases;

import Pages.Cart;
import Pages.ExternalUserLogin;
import Pages.HomePage;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteItemFromCart extends DriverType
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
    public void removeItem()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
        cart.removeItem("The Power of your Subconcious Mind");
        extnUserLogin.signout();
    }
}
