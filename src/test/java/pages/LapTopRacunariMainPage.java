package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Components.FooterComponent;

import java.util.List;

public class LapTopRacunariMainPage extends BasePage {

    FooterComponent footerComponent;

    public LapTopRacunariMainPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@class='megabtn ']//span[text()='Proizvodi']")
    WebElement buttonProizvodiel;

    @FindBy(xpath = "//div[@class='sidemenu show active']//li//a[text()='Laptop računari']")
    WebElement laptopRacunariItemEl;

    @FindBy(xpath = "//div[@id='header__center__login__and__cart']//div[@class='user-opt drop-menu noselect']//span[text()='Prijava']")
    WebElement login;

    @FindBy(xpath = "//button[@id='loginSubmit']")
    WebElement login2;

    public void clickProizvodiButton() {
        clickElementJS(buttonProizvodiel, "Button proizvodi is pressed");
    }

    public void clickLaptopRacunariItem() {
        clickElementJS(laptopRacunariItemEl, "Item laptop racunari item is pressed");
    }

    public void checkLapTopRacunariItems() throws InterruptedException {
        String[] menuItems = {"Laptop računari", "Miševi", "Torbe", "Rančevi", "Futrole", "Postolja za hlađenje",
        "USB Hub i Docking station", "Punjači", "USB gedžeti", "Operativni sistemi", "Software"};
        List<WebElement> lapTopMenuItems = driver.findElements(By.xpath("//div[@class='category_menu']//div[@class='catmenu-main']//h2//a"));
        Thread.sleep(1000);
        for (int i = 0; i < lapTopMenuItems.size(); i++) {
            String item = lapTopMenuItems.get(i).getText();
            Assert.assertEquals(item, menuItems[i], "Menu item is not displayed");
            System.out.println("Menu item: " + item + " is displayed");
            Assert.assertTrue(lapTopMenuItems.get(i).isDisplayed(), menuItems[i]);
        }
    }

}


