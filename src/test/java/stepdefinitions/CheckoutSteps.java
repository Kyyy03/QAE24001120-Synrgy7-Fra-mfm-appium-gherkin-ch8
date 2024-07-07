package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import io.cucumber.java.en.*;

public class CheckoutSteps {
    AndroidDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Given("The user is logged in")
    public void UserIsLoggedInForCheckout() {
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

    @When("The user adds items to the cart")
    public void theUserAddsItemsToTheCart() {
        homePage.ClickATC1Button();
        homePage.ClickATC2Button();
    }

    @When("The user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        cartPage = new CartPage(driver);
        // cartPage.ClickCartContainer();
        cartPage.scrollAndClickCheckoutButton();
    }

    @When("The user enters shipping information")
    public void theUserEntersShippingInformation() {
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.InputFirstName("John");
        checkoutInformationPage.InputLastName("Doe");
        checkoutInformationPage.InputPostalCode("12345");
        checkoutInformationPage.ClickContinueButton();
    }

    @When("The user completes the checkout")
    public void theUserCompletesTheCheckout() {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.ScrollAndClickFinishButton();
    }

    @Then("The user should see the order confirmation")
    public void theUserShouldSeeTheOrderConfirmation() {
        checkoutCompletePage = new CheckoutCompletePage(driver);
        assert checkoutCompletePage.getCheckOutTitle();
        driver.quit();
    }
}
