package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homePage {

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
    @FindBy(className = "s-result-item")
    List<WebElement> listItems;
    @FindBy(id = "add-to-cart-button")
    public WebElement btnAddToCart;


    public homePage(WebDriver driver)
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
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        /*for(WebElement elem: listItems)
        {
            if(elem.findElement(By.xpath("//a[contains(@class,'s-color-twister-title-link')]")).getText().contains(itemName))
            {
                elem.click();
            }
        }*/
       clickBook.click();
       //driver.findElement(By.xpath("//a[@title='"+itemName+"')]")).click();
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        btnAddToCart.click();
        driver.switchTo().window(winHandleBefore);
    }
    public void shopByCategoryOption()
    {
        Actions action = new Actions(driver);
        action.moveToElement(btnShopAll).moveToElement(linkBooks).build().perform();
        allBooksLink.click();
    }
    public void listOfSearchItems(String itemName)
    {
        Select select = new Select(btnSearchDropdown);
        select.selectByVisibleText("Books");
        txtSearchBar.sendKeys(itemName);
        btnSearch.click();

        //System.out.println(listItems.get(1).findElement(By.xpath("//a[contains(@title,'"+itemName+"')]")).getText());
        System.out.println(listItems.get(2).findElement(By.xpath("//a[contains(@class,'s-color-twister-title-link')]")).getText());
    }

}
