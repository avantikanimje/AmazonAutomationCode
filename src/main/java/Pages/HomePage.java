package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HomePage {

    public static WebDriver driver;

    @FindBy(id="twotabsearchtextbox")
    WebElement txtSearchBar;
    @FindBy(id="searchDropdownBox")
    WebElement btnSearchDropdown;
    @FindBy(className="nav-input")
    WebElement btnSearch;
    @FindBy(id="nav-link-shopall")
    WebElement btnShopAll;
    @FindBy(xpath="//span[contains(text(), 'Books')]")
    WebElement linkBooks;
    @FindBy(xpath="//span[contains(text(), 'All Books')]")
    WebElement allBooksLink;
    @FindBy(xpath="//a[contains(@title,'The Power of')]")
    WebElement clickBook;
    @FindBy(id="add-to-cart-button")
    WebElement btnAddToCart;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    public void SearchBar(String itemName)
    {
        Select select = new Select(btnSearchDropdown);
        select.selectByVisibleText("Books");
        txtSearchBar.sendKeys(itemName);
        btnSearch.click();
        clickBook.click();
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnAddToCart.click();
    }
    public void shopByCategoryOption()
    {
        Actions action = new Actions(driver);
        action.moveToElement(btnShopAll).moveToElement(linkBooks).build().perform();
        allBooksLink.click();
    }

}
