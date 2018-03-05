package SanityCases;

import Pages.Cart;
import Pages.ExternalUserLogin;
import Pages.HomePage;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCart extends DriverType{

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
    public void addItem()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
        homePage.SearchBar("The Power of your Subconscious Mind");
        homePage.btnAddToCart.click();
        System.out.println(cart.getCartTotal());
        extnUserLogin.signout();
    }

    public void printListItems()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
        homePage.listOfSearchItems("The Power of your Subconscious Mind");
        extnUserLogin.signout();
    }
}
