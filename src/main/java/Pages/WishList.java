package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class WishList {

    public static WebDriver driver;

    @FindBy(id="nav-link-yourAccount")
    WebElement btnSignin;
    @FindBy(id="createList-announce")
    WebElement btnCreateList;
    @FindBy(id="WLNEW_list_name")
    WebElement txtWishListName;
    @FindBy(id="WLNEW_privacy_private-announce")
    WebElement btnPrivate;
    @FindBy(id="WLNEW_privacy_public-announce")
    WebElement btnPublic;
    @FindBy(id="WLNEW_cancel-announce")
    WebElement btnCancel;
    @FindBy(className = "a-button-input")
    WebElement btnCreateList2;
    @FindBy(partialLinkText = "wishlist")
    WebElement btnYourWishList;

    public WishList(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    public void NavToCreateList()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSignin).click(btnYourWishList).build().perform();
    }
    public void createNewWishList(String WishListName, String Access)
    {
        btnCreateList.click();
        txtWishListName.sendKeys(WishListName);
        if(Access.equalsIgnoreCase("Private"))
            btnPrivate.click();
        if(Access.equalsIgnoreCase("Public"))
            btnPublic.click();
        btnCreateList2.click();
    }
}
