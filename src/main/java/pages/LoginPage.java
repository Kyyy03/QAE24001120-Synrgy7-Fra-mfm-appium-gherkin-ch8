package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    AndroidDriver driver;
    WebDriverWait wait;

    // Locator atau element
    By usernameField = AppiumBy.accessibilityId("test-Username");
    By passwordField = AppiumBy.accessibilityId("test-Password");
    By clickLoginButton = AppiumBy.accessibilityId("test-LOGIN");
    By errorMessage = By.xpath("//*[contains(@text, 'Username and password do not match any user in this service.')]");
    By wrongLogo = By.xpath("//*[contains(@bounds, '[623,443][650,476]')]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Action Method
    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }
    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }
    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickLoginButton)).click();

    }
    public boolean errorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
    public boolean wrongLogoDisplayed() {
        return driver.findElement(wrongLogo).isDisplayed();
    }
}