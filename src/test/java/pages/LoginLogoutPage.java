package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Components.FooterComponent;

import java.security.PublicKey;

public class LoginLogoutPage extends BasePage {

    FooterComponent footerComponent;

    public LoginLogoutPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header//div[2]/a[last()]/span")
    WebElement logInButtonHeader;

    @FindBy(xpath = "//header//div[2]//div/a[last()]/span")
    WebElement logInVerification;

    @FindBy(xpath = "//div[@id='header__center__login__and__cart']//a[2]")
    WebElement login;

    @FindBy(xpath = "//button[@id='loginSubmit']")
    WebElement login2;

    @FindBy(css = "#password")
    WebElement passwordEl;

    @FindBy(css = "#email")
    WebElement emailEl;


    public void logInButton() {
        clickElement(login, "Login button is pressed");
    }

    public void logInButton2() {
        clickElementJS(login2, "Login2 button is pressed");
    }

    public void enterEmailAndPassword(String email, String password){
        typeTextJS(emailEl, email,"Email is entered");
        typeTextJS(passwordEl, password,"Password is entered");
    }

    public void acceptAllCookies(){
        footerComponent.acceptAlCookies();
    }


}


