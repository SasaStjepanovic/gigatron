package steps;

import com.fasterxml.jackson.databind.ser.Serializers;
import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.Reporter;
import pages.BasePage;
import pages.LoginLogoutPage;
import tests.BaseTest;

import java.util.Map;
import java.util.ResourceBundle;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        gigatron((env));
    }

    @After
    public void tearDown() {
        quit();
    }

    @Given("a user reads test data from {string} {string} by id {string}")
    public void aUserReadsTestDataFromById(String fileName, String sheetName, String id) throws Exception {
        data = new ExcelSupport().getDataByID(fileName, sheetName, id);
        System.out.println(data.get("name"));
    }


    @And("users clicks on prijava button")
    public void usersClicksOnPrijavaButton() {
        new LoginLogoutPage(driver).logInButton();
    }

    @And("user enters email and password for login")
    public void userEntersEmailAndPasswordForLogin() {
        new LoginLogoutPage(driver).enterEmailAndPassword(data.get("email"), data.get("password"));
    }

    @And("users clicks on prijavi me button")
    public void usersClicksOnPrijaviMeButton() throws InterruptedException {
        new LoginLogoutPage(driver).logInButton2();
    }

    @And("users accept all cookies")
    public void usersAcceptAllCookies() {
        new LoginLogoutPage(driver).acceptAllCookies();
    }

    @Then("user should be verified login action")
    public void userShouldBeVerifiedLoginAction() {
        new BasePage(driver).checkUrlPage(data.get("urlMessage"));
    }

    @Then("users should verify all Korisnik items")
    public void usersShouldVerifyAllKorisnikItems() throws InterruptedException {
        new LoginLogoutPage(driver).checkKorisnikItemsMainMenu();
    }

    @And("users take hover over Korisnik item")
    public void usersTakeHoverOverKorisnikItem() throws InterruptedException {
        new LoginLogoutPage(driver).hoverOverKorisnikMenu();
    }

    @And("user clicks odjavi me button")
    public void userClicksOdjaviMeButton() {
        new LoginLogoutPage(driver).clickOdjaviMebutton();
    }

    @Then("user should be verified logout action")
    public void userShouldBeVerifiedLogoutAction() {
        new LoginLogoutPage(driver).visibilityOfPrijava();
    }

    @Then("users shoud be verified visibility of Korisnik button")
    public void usersShoudBeVerifiedVisibilityOfKorisnikButton() {
        new LoginLogoutPage(driver).visibilityOfKorisnik();
    }

    @Then("users shoud be verified login with wrong email")
    public void usersShoudBeVerifiedLoginWithWrongEmail() {
        Assert.assertEquals(new LoginLogoutPage(driver).getColorEmailLabel(data.get("attributeType")), data.get("color"));
    }

    @Then("users shoud be verified login with empty password")
    public void usersShoudBeVerifiedLoginWithEmptyPassword() {
        Assert.assertEquals(new LoginLogoutPage(driver).getColorPasswordLabel(data.get("attributeType")), data.get("color"));
    }

    @Then("users shoud be verified login with wrong credentials")
    public void usersShoudBeVerifiedLoginWithWrongCredentials() {
        Assert.assertEquals(new LoginLogoutPage(driver).getErrorLoginMessage(), data.get("invalidMessage"));
    }

    @And("users should verify invisibility of Prijavi button")
    public void usersShouldVerifyInvisibilityOfPrijaviButton() {
        new LoginLogoutPage(driver).invisibilityOfPrijavi();
    }
}
