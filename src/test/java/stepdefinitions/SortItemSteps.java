package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.*;

public class SortItemSteps {
    AndroidDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Given("The user is logged in")
    public void UserIsLoggedInForSorting() {
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

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("The user sorts items by price from low to high")
    public void theUserSortsItemsByPriceFromLowToHigh() {
        homePage.ClickSortContainer();
        homePage.ClickSortLowtoHigh();
    }

    @Then("The items should be sorted by price from low to high")
    public void theItemsShouldBeSortedByPriceFromLowToHigh() {
        assert homePage.isSortedByLowToHigh();
        driver.quit();
    }
}
