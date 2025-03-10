package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    int waitTime = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWait(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scrollTopOfWindow() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void clickSpecificCoordinate() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(100, 200).click();");
    }

    public void scroll(String x, String y) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickElementProduct(WebElement element, String log) {
        explicitWait(element);
        scrollToElement(element);
        new Actions(driver).moveToElement(element).perform();
        element.click();
        System.out.println("Clicked element1: " + log);
    }

    public void clickElement(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            System.out.println("Clicked element1: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            scrollToElement(element);
            element.click();
            System.out.println("Clicked element2: " + log);
        }
    }

    public void clickElementJS(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).build().perform();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            System.out.println("Clicked element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            scrollToElement(element);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            System.out.println("Clicked element: " + log);
        }
    }

    public void checkCheckbox(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            if (!element.isSelected()) {
                System.out.println("Check box was not selected");
                element.click();
                System.out.println("Check box is selected");
            } else {
                element.isSelected();
                System.out.println("Check box is already selected");
            }
            System.out.println("Checked element" + log);
        } catch (Exception e) {
            e.printStackTrace();
            if (!element.isSelected()) {
                element.click();
            } else {
                element.isSelected();
                System.out.println("Check box is already selected");
            }
            System.out.println("Checked element" + log);
        }
    }

    public void checkUrlDefaultPage() {
        String expextedUrl = "https://ipon.hu/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current url address: " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expextedUrl), actualUrl);
    }

    public void checkUrlPage(String expectedUrl) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current url address: " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl), actualUrl);
    }

    public void typeText(WebElement element, String text, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            element.click();
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        }
    }

    public void typeTextJS(WebElement element, String text, String log) {
        explicitWait(element);

        try {
            new Actions(driver).moveToElement(element).perform();
            clickElementJS(element, " element is clicked");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            clickElementJS(element, " element is clickd");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        }
    }

    public void compareText(WebElement element, String expectedText) {
        explicitWait(element);
        String actualText = element.getText();
        System.out.println("Actual text is: " + actualText);
        Assert.assertEquals(actualText, expectedText);
    }

    public String getElementText(WebElement element) {

        return element.getText();
    }

    public String getElementCssValue(WebElement element, String attributeType) {

        return element.getCssValue(attributeType);
    }

    public void takeScreenshot(String name, String yesNo) throws IOException {
        if (yesNo.equalsIgnoreCase("YES")) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            long finish = System.currentTimeMillis();
            FileUtils.copyFile(file, new File("src/results/screenshots/" + name + "_" + finish + ".png"));
        }
    }

    public void reportScreenshot(String name, String desc, String yesOrNo) throws IOException {
        if (yesOrNo.equalsIgnoreCase("Yes")) {
            takeScreenshot(name, yesOrNo);
            Path path = Paths.get("src/results/screenshots/" + name + ".png");
            InputStream is = Files.newInputStream(path);
            Allure.addAttachment(desc, is);
        }
    }

    public void filterClickDisplayMoreProducts(String filter){
        WebElement el = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='app']/div[@id='content']/div[@class='filterpage']/div[@class='filterpage__main']/div[@class='filters-view']/div[@class='filterpage__main__bar specifications']/div[@class='filter-bar']/div/span[text()='"+ filter +"']"));
        clickElementJS(el, "More options are displayed, first filter");
    }

    public void filterClickDisplayMoreValues(String filter){
        WebElement el = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='app']/div[@id='content']/div[@class='filterpage']/div[@class='filterpage__main']/div[@class='filters-view']/div[@class='filterpage__main__bar specifications']/div[@class='filter-bar']/div/span[text()='"+ filter +"']//..//div//div[text()='Prikaži više']"));
        clickElementJS(el, "More options are displayed, second filter");
    }

    public void applyFilter(String filter){
        boolean b = driver.findElements(By.xpath("//div[@class='filterpage__main']//span[text()='"+ filter +"']/..//span[@class='Collapsible__trigger is-closed']")).size() > 0;

        if(b){
            filterClickDisplayMoreProducts(filter);
        } else {
            System.out.println("First filter is already expanded");
        }
    }

    public void applyFilterValue (String filter, String value){
        boolean bo = driver.findElements(By.xpath("//body/div[@id='root']/div[@id='app']/div[@id='content']/div[@class='filterpage']/div[@class='filterpage__main']/div[@class='filters-view']/div[@class='filterpage__main__bar specifications']/div[@class='filter-bar']/div/span[text()='"+ filter +"']//..//div//div[text()='Prikaži više']")).size() > 0;

        if(bo){
            filterClickDisplayMoreValues(filter);
        } else {
            System.out.println("Second filter is already expanded");
        }

        WebElement elementValue = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='app']/div[@id='content']/div[@class='filterpage']/div[@class='filterpage__main']/div[@class='filters-view']/div[@class='filterpage__main__bar specifications']/div[@class='filter-bar']/div/div//span[text()='"+ value +"']"));
        checkCheckbox(elementValue, " Value: " + value + " is checked");
    }

}
