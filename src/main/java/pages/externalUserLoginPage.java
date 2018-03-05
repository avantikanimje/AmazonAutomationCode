package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Scanner;

public class externalUserLoginPage {

    public static WebDriver driver;
    Scanner scanner=new Scanner(System.in);

    @FindBy(id="nav-link-yourAccount")
    WebElement btnSignin;
    @FindBy(id = "ap_email")
    WebElement txtEmailorMobile;
    @FindBy(id = "continue")
    WebElement btnContinue;
    @FindBy(id = "ap_password")
    WebElement txtPassword;
    @FindBy(id = "signInSubmit")
    WebElement btnLogin;
    @FindBy(id = "createAccountSubmit")
    WebElement btnCreateAccount;
    @FindBy(id = "ap_customer_name")
    WebElement txtCustomerName;
    @FindBy(id = "ap_phone_number")
    WebElement txtMobileNumber;
    @FindBy(xpath = "//input[@name='rememberMe']")
    WebElement checkKeepSigned;
    @FindBy(id="auth_pv_enter_code")
    WebElement txtEnterCode;
    @FindBy(id="auth_verify_button")
    WebElement btnVerify;
    @FindBy(id="nav-item-signout-sa")
    WebElement btnSignout;
    public externalUserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void signin(String emailOrMobile, String password) {
        btnSignin.click();
        txtEmailorMobile.sendKeys(emailOrMobile);
        btnContinue.click();
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void register(String name, String email, String mobile, String password)
    {
        btnSignin.click();
        btnCreateAccount.click();
        txtCustomerName.sendKeys(name);
        txtMobileNumber.sendKeys(mobile);
        txtEmailorMobile.sendKeys(email);
        txtPassword.sendKeys(password);
        btnContinue.click();
        System.out.println("Enter Verification Code:");
        String code = scanner.next();
        txtEnterCode.sendKeys(code);
        btnVerify.click();
    }

    public void signout() {
        Actions action = new Actions(driver);
        action.moveToElement(btnSignin).click(btnSignout).build().perform();
    }
}