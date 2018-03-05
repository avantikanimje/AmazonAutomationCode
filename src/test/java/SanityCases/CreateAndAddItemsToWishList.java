package SanityCases;

import Pages.Cart;
import Pages.ExternalUserLogin;
import Pages.HomePage;
import Pages.WishList;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAndAddItemsToWishList extends DriverType{
    private WebDriver driver;
    private ExternalUserLogin extnUserLogin;
    private HomePage homePage;
    private WishList wishList;
    @BeforeClass
    public void setUp()
    {
        driver = launchApplication("https://www.amazon.in/","chrome");
        extnUserLogin = new ExternalUserLogin(driver);
        homePage = new HomePage(driver);
        wishList = new WishList(driver);
    }
    @Test
    public void createWishList()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
        wishList.NavToCreateList();
        wishList.createNewWishList("Dummy02","Private");
        extnUserLogin.signout();
    }

    public void addItemsToWishList()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
        homePage.SearchBar("Rich Dad Poor Dad");
    }
}
