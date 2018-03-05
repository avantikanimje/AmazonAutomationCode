package Pages;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.w3c.css.sac.SelectorList;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public static WebDriver driver;

    @FindBy(id="nav-cart")
    WebElement btnCart;
    @FindBy(className = "a-link-normal sc-product-link")
    List<WebElement> cartList;
    @FindBy(className="a-size-medium sc-product-title a-text-bold")
    WebElement cartItem;
    @FindBy(xpath="//*[@id=\"activeCartViewForm\"]/div[3]/p/span/span/span/span")
    WebElement cartTotal;
    @FindBy(xpath="//a[contains(@title,'The Power of')]")
    WebElement clickBook;
    @FindBy(xpath="//input[@contains(aria-label,'Delete')]")
    WebElement deleteBook;
    @FindBy(className="sc-active-cart a-list-item")
    List<WebElement> productTitle;

    public Cart(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    public void verifyCartItem(String bookName)
    {
        btnCart.click();
        List<WebElement> cartItems = driver.findElements(By.className("sc-list-body"));
        System.out.println(cartItems.get(0).getText());
    }

    public String getCartTotal()
    {
        btnCart.click();
        return cartTotal.getText();
    }
    public void removeItem(String bookName)
    {
        btnCart.click();
        System.out.println(productTitle.get(0));
        driver.findElements(By.className("sc-action-delete")).get(0).click();
        System.out.println(getCartTotal());
    }
    public void saveForLater(String bookName)
    {
        btnCart.click();
        int index=0;
        for(WebElement elem: productTitle)
        {
            if(elem.getText().equalsIgnoreCase(bookName))
            {
                //System.out.println(elem.getText());
                index = productTitle.indexOf(elem);
                break;
            }
        }
        driver.findElements(By.className("sc-action-save-for-later")).get(index).click();
        System.out.println(getCartTotal());
    }
    public void moveTOCart(String bookName)
    {
        btnCart.click();
        int index=0;
        for(WebElement elem: productTitle)
        {
            if(elem.getText().equalsIgnoreCase(bookName))
            {
                index = productTitle.indexOf(elem);
                break;
            }
        }
        driver.findElements(By.className("sc-action-move-to-cart")).get(index).click();
        System.out.println(getCartTotal());
    }
    public void changeItemQuantity(String bookName, String quantity)
    {
        btnCart.click();
        int index=0;
        for(WebElement elem: productTitle)
        {
            if(elem.getText().equalsIgnoreCase(bookName))
            {
                index = productTitle.indexOf(elem);
                break;
            }
        }
        Select s = new Select(driver.findElements(By.name("quantity")).get(index));
        // Select s = new Select(quantitySelectList);
        s.selectByVisibleText(quantity);
        System.out.println(getCartTotal());
    }
}
