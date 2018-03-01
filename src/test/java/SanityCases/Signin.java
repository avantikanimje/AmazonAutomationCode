package SanityCases;

import Pages.ExternalUserLogin;
import Services.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Signin extends DriverType{

    private WebDriver driver;
    private ExternalUserLogin extnUserLogin;


    public void setUp()
    {
        driver=launchApplication("https://www.amazon.in/","chrome");
        extnUserLogin =new ExternalUserLogin(driver);
    }
    public void signin()
    {
        extnUserLogin.signin("9441159999","amazondummy01");
    }
}
