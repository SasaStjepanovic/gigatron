package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Components.FooterComponent;

import java.util.List;

public class LicniPodaciLozinkaPage extends BasePage {

    FooterComponent footerComponent;

    public LicniPodaciLozinkaPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='header__center__login__and__cart']//div[@class='user-opt drop-menu noselect']//span[text()='Prijava']")
    WebElement login;

    @FindBy(xpath = "//div[@id='content']//div[@class='wrap']//li//a[text()=' Lični podaci i lozinka']")
    WebElement licniPodaciEl;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameEl;

    @FindBy(xpath = "//input[@name='address']")
    WebElement addressEl;

    @FindBy(xpath = "//input[@name='postal_city']")
    WebElement pttEl;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneEl;

    @FindBy(xpath = "//div[@class='col col-7 min-height']//div[1]//button[text()='Sačuvaj']")
    WebElement sačuvajEl;

    @FindBy(xpath = "//div[@class='swal2-actions']//button[1]")
    WebElement popupMessageEl;

    @FindBy(xpath = "//div[@class='col col-7 min-height']/div[1]/div[1]//div")
    WebElement errorMessageNameEl;

    @FindBy(xpath = "//div[@class='col col-7 min-height']/div[1]/div[2]//div")
    WebElement errorMessageAddressEl;

    @FindBy(xpath = "//div[@class='col col-7 min-height']/div[1]/div[3]//div")
    WebElement errorMessagePttEl;

    @FindBy(xpath = "//div[@class='col col-7 min-height']/div[1]/div[4]//div")
    WebElement errorMessagePhoneEl;


    public void clickLicniPodaciItem() {
        clickElementJS(licniPodaciEl, "Licni podaci item is pressed");
    }

    public void enterName(String name) {
        typeTextJS(nameEl, name, "Name is entered");
    }

    public void clickSacuvajbutton(){
        clickElementJS(sačuvajEl,"Sacuvaj element is pressed");
    }

    public void confirmPopupMessage(){
        clickElementJS(popupMessageEl, "Popup message is confirmed");
    }

    public String getErrorNameMessage() {
        return getElementText(errorMessageNameEl);
    }

    public void enterAddress(String address) {
        typeTextJS(addressEl, address, "Address is entered");
    }

    public String getErrorAddressMessage() {
        return getElementText(errorMessageAddressEl);
    }

    public void enterPtt(String ptt) {
        typeTextJS(pttEl, ptt, "Ptt is entered");
    }

    public String getErrorPttMessage() {
        return getElementText(errorMessagePttEl);
    }

    public void enterPhone(String phone) {
        typeTextJS(phoneEl, phone, "Phone is entered");
    }

    public String getErrorPhoneMessage() {
        return getElementText(errorMessagePhoneEl);
    }

}


