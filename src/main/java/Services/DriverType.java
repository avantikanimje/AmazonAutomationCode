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
            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\animje\\\\IdeaProjects\\\\chromedriver(2.35)\\\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(websiteURL);
            driver.manage().window().maximize();
        }
        if(browser.equals("firefox")||browser.equals("ff"))
        {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\animje\\IdeaProjects\\Mozilla gecko webdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(websiteURL);
        }
        return driver;
    }
}
