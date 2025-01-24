package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Components.FooterComponent;

import java.util.List;

public class LapTopRacunariSubPage extends BasePage {

    FooterComponent footerComponent;

    public LapTopRacunariSubPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@class='megabtn ']//span[text()='Proizvodi']")
    WebElement buttonProizvodiel;

    @FindBy(xpath = "//div[@class='sidemenu show active']//li//a[text()='Laptop računari']")
    WebElement laptopRacunariItemEl;

    @FindBy(xpath = "//div[@class='category_menu']//div//div//a[text()='Laptop računari']")
    WebElement laptopRacunariSubItemEl;

    @FindBy(xpath = "//button[@id='loginSubmit']")
    WebElement login2;

    public void clickProizvodiButton() {
        clickElementJS(buttonProizvodiel, "Button proizvodi is pressed");
    }

    public void clickLaptopRacunariItem() {
        clickElementJS(laptopRacunariItemEl, "Item laptop racunari item is pressed");
    }

    public void clickLaptopRacunarSubiItem() {
        clickElementJS(laptopRacunariSubItemEl, "Sub item laptop racunari item is pressed");
    }

    public void filterLaptop (String filter1, String value1, String filter2, String value2){
      applyFilter(filter1);
      applyFilterValue(filter1, value1);

      applyFilter(filter2);
      applyFilterValue(filter2, value2);
    }

}


