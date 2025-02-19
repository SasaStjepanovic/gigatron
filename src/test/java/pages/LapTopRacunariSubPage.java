package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(xpath = "//div[@class='filterpage__main__content']/div/button[text()='Izbriši sve']")
    WebElement deleteAllButtonEl;

    public void clickDeleteAllButton() {
        clickElementJS(deleteAllButtonEl, "Button izbrisi sve is pressed");
    }

    public void clickLaptopRacunariItem() {
        clickElementJS(laptopRacunariItemEl, "Item laptop racunari item is pressed");
    }

    public void clickLaptopRacunarSubiItem() {
        clickElementJS(laptopRacunariSubItemEl, "Sub item laptop racunari item is pressed");
    }

    public void filterLaptop (String filter1, String value1, String filter2, String value2, String filter3, String value3){
      applyFilter(filter1);
      applyFilterValue(filter1, value1);

      applyFilter(filter2);
      applyFilterValue(filter2, value2);

      applyFilter(filter3);
      applyFilterValue(filter3, value3);
    }

    public void checkFilterPageContent() throws InterruptedException {
        String[] menuItems = {"Acer", "Da (Gaming)", "Intel Core i9 (Tip procesora)"};
        List<WebElement> filterItems = driver.findElements(By.xpath("//div[@class='filterpage__main__content']/div/a"));

        Thread.sleep(1000);
        for (int i = 0; i < filterItems.size(); i++) {
            System.out.println("Index 3 is out of bounds. Array length is: " + filterItems.size());
            String item = filterItems.get(i).getText();
            Assert.assertEquals(item, menuItems[i], "Filter item is not displayed");
            System.out.println("Filter item: " + item + " is displayed");
            Assert.assertTrue(filterItems.get(i).isDisplayed(), menuItems[i]);
        }
    }

    public void invisibilityOfElement(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
        boolean isInvisible = webDriverWait.until(ExpectedConditions.invisibilityOf((driver.findElement(By.xpath("//div[@class='filterpage__main__content']/div/button[text()='Izbriši sve']")))));

        if (isInvisible) {
            System.out.println("Element is no longer visible or doesn't exist.");
        } else {
            System.out.println("Element is still visible.");
        }
    }

}


