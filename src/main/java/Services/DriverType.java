package Services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DriverType {

    WebDriver driver;

    public WebDriver launchApplication(String websiteURL, String browser)
    {
        if(browser.equals("chrome")|| browser.equals("ch"))
        {
            System.setProperty("webdriver.chrome.driver", "G:\\Intellij Software\\Chrome Driver 2.33\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(websiteURL);
            driver.manage().window().maximize();
        }
        if(browser.equals("firefox")||browser.equals("ff"))
        {
            System.setProperty("webdriver.gecko.driver","G:\\Intellij Software\\Chrome Driver 2.33\\chromedriver.exe");
            driver = new FirefoxDriver();
            driver.get(websiteURL);
        }
        return driver;
    }
}
