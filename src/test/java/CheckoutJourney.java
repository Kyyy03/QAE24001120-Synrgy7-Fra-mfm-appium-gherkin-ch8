import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;


public class CheckoutJourney {
    AndroidDriver driver;

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "samsung SM-A307GN");
        capabilities.setCapability("app", "D:/belajar/QA/SYNRGY Academy B7/Chapter 8/apkchallenge.apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }
    @Test
    public void testCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        homePage.ClickChangeView();
        homePage.ClickATC1Button();
        homePage.ClickATC2Button();
        homePage.ClickCartButton();
        cartPage.scrollAndClickCheckoutButton();
        checkoutInformationPage.InputFirstName("aaa");
        checkoutInformationPage.InputLastName("aaa");
        checkoutInformationPage.InputPostalCode("111");
        checkoutInformationPage.ClickContinueButton();
        checkoutOverviewPage.ScrollAndClickFinishButton();

        // assertion
        checkoutCompletePage.getCompleteHeader();
        checkoutCompletePage.getCheckOutTitle();

    }
    @AfterTest
    public void cloeSession() {
        if (driver != null) {
            driver.quit();
        }
    }
}