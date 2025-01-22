package steps;

import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.Reporter;
import pages.*;
import tests.BaseTest;

import java.util.Map;

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

    @And("user clicks licni podaci i lozinka item")
    public void userClicksLicniPodaciILozinkaItem() {
        new LicniPodaciLozinkaPage(driver).clickLicniPodaciItem();
    }

    @Then("user should veriify opened page")
    public void userShouldVeriifyOpenedPage() {
        new BasePage(driver).checkUrlPage(data.get("urlMessage"));
    }

    @And("users enter name field")
    public void usersEnterNameField() {
        new LicniPodaciLozinkaPage(driver).enterName(data.get("name"));
    }

    @And("users clicks sacuvaj button")
    public void usersClicksSacuvajButton() {
        new LicniPodaciLozinkaPage(driver).clickSacuvajbutton();
    }

    @And("users confirm popup message")
    public void usersConfirmPopupMessage() {
        new LicniPodaciLozinkaPage(driver).confirmPopupMessage();
    }

    @Then("users verify error message of name")
    public void usersVerifyErrorMessageOfName() {
        Assert.assertEquals(new LicniPodaciLozinkaPage(driver).getErrorNameMessage(), data.get("invalidMessage"));
    }

    @And("users enter address field")
    public void usersEnterAddressField() {
        new LicniPodaciLozinkaPage(driver).enterAddress(data.get("address"));
    }

    @Then("users verify error message of address")
    public void usersVerifyErrorMessageOfAddress() {
        Assert.assertEquals(new LicniPodaciLozinkaPage(driver).getErrorAddressMessage(), data.get("invalidMessage"));
    }

    @And("users enter ptt field")
    public void usersEnterPttField() {
        new LicniPodaciLozinkaPage(driver).enterPtt(data.get("ptt"));
    }

    @Then("users verify error message of ptt")
    public void usersVerifyErrorMessageOfPtt() {
        Assert.assertEquals(new LicniPodaciLozinkaPage(driver).getErrorPttMessage(), data.get("invalidMessage"));
    }

    @And("users enter phone field")
    public void usersEnterPhoneField() {
        new LicniPodaciLozinkaPage(driver).enterPhone(data.get("phone"));
    }

    @Then("users verify error message of phone")
    public void usersVerifyErrorMessageOfPhone() {
        Assert.assertEquals(new LicniPodaciLozinkaPage(driver).getErrorPhoneMessage(), data.get("invalidMessage"));
    }

    @And("user clicks adresa dostave item")
    public void userClicksAdresaDostaveItem() {
        new AdresaDostavePage(driver).adresaDostaveItem();
    }

    @And("users delete all adresa dostave")
    public void usersDeleteAllAdresaDostave() {
        new AdresaDostavePage(driver).deleteAllAdresaDostave();
    }

    @And("users clicks sacuvaj button for address")
    public void usersClicksSacuvajButtonForAddress() {
        new AdresaDostavePage(driver).clickSacuvajbutton();
    }

    @And("users enter email field")
    public void usersEnterEmailField() {
        new AdresaDostavePage(driver).enterEmail(data.get("email2"));
    }

    @Then("users should verify obrisi unos button is visible")
    public void usersShouldVerifyObrisiUnosButtonIsVisible() {
        new AdresaDostavePage(driver).visibilityOfSacuvajButton();
    }

    @Then("users verify error message of name for address")
    public void usersVerifyErrorMessageOfNameForAddress() {
        Assert.assertEquals(new AdresaDostavePage(driver).getErrorNameMessage(), data.get("invalidMessage"));
    }

    @Then("users verify error message of address for address")
    public void usersVerifyErrorMessageOfAddressForAddress() {
        Assert.assertEquals(new AdresaDostavePage(driver).getErrorAddressMessage(), data.get("invalidMessage"));
    }

    @And("users clicks proizvodi button")
    public void usersClicksProizvodiButton() {
        new LapTopRacunariMainPage(driver).clickProizvodiButton();
    }

    @And("users clicks laptop racunari item")
    public void usersClicksLaptopRacunariItem() {
        new LapTopRacunariMainPage(driver).clickLaptopRacunariItem();
    }

    @Then("users should verify all laptop items")
    public void usersShouldVerifyAllLaptopItems() throws InterruptedException {
        new LapTopRacunariMainPage(driver).checkLapTopRacunariItems();
    }
}
