package SanityCases;

import pages.externalUserLoginPage;
import pages.homePage;
import pages.wishListPage;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data.Constants;

public class CreateAndAddItemsToWishListPage extends DriverType{
    private WebDriver driver;
    private externalUserLoginPage extnUserLogin;
    private pages.homePage homePage;
    private wishListPage wishListPage;
    private Constants constants;

    @BeforeClass
    public void setUp()
    {
        driver = launchApplication(constants.BaseUrl,constants.BrowserName);
        extnUserLogin = new externalUserLoginPage(driver);
        homePage = new homePage(driver);
        wishListPage = new wishListPage(driver);
    }
    @Test
    public void createWishList()
    {
        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        wishListPage.NavToCreateList();
        wishListPage.createNewWishList("Dummy02","Private");
        extnUserLogin.signout();

    }

    @AfterClass
    public void close()
    {
        driverClose();
    }

    public void addItemsToWishList()
    {
        extnUserLogin.signin(constants.ExtnUsername,constants.ExtnPassword);
        homePage.SearchBar("Rich Dad Poor Dad");
    }
}
