package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    By firstNameField = AppiumBy.accessibilityId("test-First Name");
    By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    By zipField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckoutInformationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void InputFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstname);
    }
    public void InputLastName(String lastname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys(lastname);
    }
    public void InputPostalCode(String postalcode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipField));
        driver.findElement(zipField).sendKeys(postalcode);
    }
    public void ClickContinueButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

}