package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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
    public Cart(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

   /* public void verifyCartItem(int i)
    {
        ArrayList<String> al = new ArrayList<String>();
        btnCart.click();
        for(WebElement resultItem: cartList)
        {
            al.add(resultItem.getText());
        }
        System.out.println(al.get(i));
        (
        System.out.println(cartItem.getText());
    }
    */

    public String getCartTotal()
    {
        btnCart.click();
        return cartTotal.getText();
    }
    public void removeItem(String bookName)
    {
        btnCart.click();
        driver.findElements(By.className("sc-action-delete")).get(0).click();
        getCartTotal();
    }
}
