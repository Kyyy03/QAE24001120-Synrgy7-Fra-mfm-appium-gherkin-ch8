package stepdefinitions;

import config.SpringConfig;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.*;


@ContextConfiguration(classes = SpringConfig.class)
public class LoginSteps {
    @Autowired
    private AndroidDriver driver;

    @Autowired
    LoginPage loginPage;

    @Autowired
    HomePage homePage;

//    AndroidDriver driver;
//    LoginPage loginPage;
//    HomePage homePage;

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "samsung SM-A307GN");
        capabilities.setCapability("app", "D:/belajar/QA/SYNRGY Academy B7/Chapter 8/sample.apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @When("The user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
    }

    @When("The user enters invalid username and password")
    public void theUserEntersInvalidUsernameAndPassword() {
        loginPage.inputUsername("standard");
        loginPage.inputPassword("secret");
    }

    @When("The user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("The user should see the products page")
    public void theUserShouldSeeTheProductsPage() {
        assert homePage.textProductIsDisplayed();
        assert homePage.logoPictIsDisplayed();
        driver.quit();
    }

    @Then("The user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
        assert loginPage.errorMessageDisplayed();
        assert loginPage.wrongLogoDisplayed();
        driver.quit();
    }
}
