import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class UnSuccessfullyLogin {
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
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("standard");
        loginPage.inputPassword("secret");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.errorMessageDisplayed());
        Assert.assertTrue(loginPage.wrongLogoDisplayed());

    }
    @AfterTest
    public void cloeSession() {
        if (driver != null) {
            driver.quit();
        }
    }
}