package pages.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class FooterComponent extends BasePage {


    public FooterComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='gdpr-title']//button[@class='btn primary']")
    WebElement cookies;

    public void acceptAlCookies() {
        clickElement(cookies, "All cookies are excepted");
    }


}
