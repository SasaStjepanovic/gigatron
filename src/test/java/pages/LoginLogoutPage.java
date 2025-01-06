package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Components.FooterComponent;

import java.security.PublicKey;
import java.util.List;

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
    WebElement emailEl;//

    @FindBy(xpath = "//label[@for='email']")
    WebElement emailLabelEl;

    @FindBy(xpath = "//label[@for='password']")
    WebElement passwLabelEl;

    @FindBy(xpath = "//div[@class='header__center']//span[text()='Korisnik']")
    WebElement korisnikEl;

    @FindBy(xpath = "//div[@id='sticky-blue']//span[text()='Korpa']")
    WebElement korpaEl;

    @FindBy(xpath = "//div[@class='header__center']//div[@class='drop-menu-holder']//a[text()='Odjavi se']")
    WebElement odjaviSeEl;

    @FindBy(xpath = "//p[text()='Došlo je do greške. Korisnik nije pronađen ili je neispravna lozinka.']")
    WebElement loginErrorMessageEl;


    public void logInButton() {
        clickElement(login, "Login button is pressed");
    }

    public void logInButton2() {
        clickElementJS(login2, "Login2 button is pressed");
    }

    public void enterEmailAndPassword(String email, String password) {
        typeTextJS(emailEl, email, "Email is entered");
        typeTextJS(passwordEl, password, "Password is entered");
    }

    public void acceptAllCookies() {
        footerComponent.acceptAlCookies();
    }

    public void checkKorisnikItemsMainMenu() throws InterruptedException {
        String[] menuItems = {"Moj profil", "Istorija kupovine", "Lista želja", "Prethodno pregledani", "Moja korpa", "Odjavi se"};
        List<WebElement> korisnikItemsMainMenu = driver.findElements(By.xpath("//div[@class='header__center']//div[@class='drop-menu-holder']//ul//li"));
        Thread.sleep(1000);
        for (int i = 0; i < korisnikItemsMainMenu.size(); i++) {
            String item = korisnikItemsMainMenu.get(i).getText();
            Assert.assertEquals(item, menuItems[i], "Menu item is not displayed");
            System.out.println("Menu item: " + item + " is displayed");
            Assert.assertTrue(korisnikItemsMainMenu.get(i).isDisplayed(), menuItems[i]);
        }
    }

    public void hoverOverKorisnikMenu () throws InterruptedException {
        explicitWait(korisnikEl);
        Actions actions = new Actions(driver);
        actions.pause(5);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='header__center']//span[text()='Korisnik']"))).build().perform();
    }

    public void clickOdjaviMebutton(){
        clickElementJS(odjaviSeEl, "Odjavi se button is pressed");
    }

    public void visibilityOfKorisnik(){
        explicitWait(korisnikEl);
    }

    public void visibilityOfPrijava(){
        explicitWait(login);
    }

    public String getColorEmailLabel(String attributeType){
        String colorValue = emailLabelEl.getCssValue("color");
        System.out.println("Current color is: " + colorValue);
        return  getElementCssValue(emailLabelEl,attributeType);
    }

    public String getColorPasswordLabel(String attributeType){
        return  getElementCssValue(passwLabelEl,attributeType);
    }

    public String getErrorLoginMessage (){
        return getElementText(loginErrorMessageEl);
    }


}


