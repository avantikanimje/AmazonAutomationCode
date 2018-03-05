package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class WishList {

    public static WebDriver driver;

    @FindBy(id="nav-link-yourAccount")
    WebElement btnSignin;
    @FindBy(id="createList-announce")
    WebElement btnCreateList;
    @FindBy(id="WLNEW_list_name")
    WebElement txtWishListName;
    @FindBy(id="WLNEW_privacy_private")
    WebElement btnPrivate;
    @FindBy(id="WLNEW_privacy_public")
    WebElement btnPublic;
    @FindBy(id="WLNEW_cancel-announce")
    WebElement btnCancel;
    @FindBy(xpath="//span[@data-action='reg-create-submit']")
    WebElement btnCreateList2;
    @FindBy(id="nav-link-wishlist")
    WebElement btnYourWishList;
   /* @FindBy(className = "nav-tpl-itemList")
    List<WebElement> accountDropdown;*/

    public WishList(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    public void NavToCreateList()
    {
        //Actions actions = new Actions(driver);
        //actions.moveToElement(btnSignin).click(btnYourWishList).build().perform();
        btnYourWishList.click();
        //driver.get("https://www.amazon.in/gp/registry/wishlist/ref=nav_youraccount_wl?ie=UTF8&requiresSignIn=1");
       // accountDropdown.get(2).click();
    }
    public void createNewWishList(String WishListName, String Access)
    {
        btnCreateList.click();
        txtWishListName.clear();
        txtWishListName.sendKeys(WishListName);
        if(Access.equalsIgnoreCase("Private"))
            btnPrivate.click();
        if(Access.equalsIgnoreCase("Public"))
            btnPublic.click();
        btnCreateList2.click();
    }
}
