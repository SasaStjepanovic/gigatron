package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Components.FooterComponent;

import java.util.List;

public class AdresaDostavePage extends BasePage {

    FooterComponent footerComponent;

    public AdresaDostavePage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header//div[2]/a[last()]/span")
    WebElement logInButtonHeader;

    @FindBy(xpath = "//div[@class='swal2-actions']//button[1]")
    WebElement popupMessageEl;

    @FindBy(xpath = "//div[@class='btn_cont_address']//button")
    WebElement obrisiButtonEl;

    @FindBy(xpath = "//div[@id='content']//div[@class='wrap']//li//a[text()=' Adresa dostave']")
    WebElement adresaDostaveEl;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameEl;

    @FindBy(xpath = "//input[@name='address']")
    WebElement addressEl;

    @FindBy(xpath = "//input[@name='postal_city']")
    WebElement pttEl;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneEl;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']//div[4]//button")
    WebElement sačuvajEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']/div[4]/div[1]//div")
    WebElement errorMessageNameEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']/div[4]/div[2]//div")
    WebElement errorMessageAddressEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']/div[4]/div[3]//div")
    WebElement errorMessagePttEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']/div[4]/div[4]//div")
    WebElement errorMessagePhoneEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']/div[4]/div[5]//div")
    WebElement errorMessageEmailEl;

    @FindBy(xpath = "//div[@class='col col-7 col-address']/div[2]//div//div//div//div[2]/button[1]")
    WebElement successMessageAddressEl;

    public void adresaDostaveItem() {
        clickElementJS(adresaDostaveEl, "Adresa dostave item is pressed");
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

    public void enterEmail(String email) {
        typeTextJS(emailEl, email, "Email is entered");
    }

    public String getSuccessAddressMessage() {
        return getElementText(successMessageAddressEl);
    }

    public void clickObrisi() {
        clickElementJS(obrisiButtonEl, "Obrisi button is pressed");
    }

    public void deleteAllAdresaDostave() {
        List<WebElement> listOfAddress = driver.findElements(By.xpath("//div[@class='col col-7 col-address']//div[2]//div//p"));
        if (listOfAddress.get(0).getText().equals("Nemate unetih adresa.")) {
            System.out.println("list of address is already empty !!!");
        } else {
            try {
                while (driver.findElement(By.xpath("//div[@class='btn_cont_address']//button")).isDisplayed()) {
                    System.out.println("List of address are not empty.");
                    clickObrisi();
                    confirmPopupMessage();
                }
            } catch (Exception e) {
                System.out.println("List is empty.");
            }

        }
    }

    public void visibilityOfSacuvajButton(){
        explicitWait(sačuvajEl);
    }
}


