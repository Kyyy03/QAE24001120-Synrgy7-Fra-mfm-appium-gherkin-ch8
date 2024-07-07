package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {
    AndroidDriver driver;
    WebDriverWait wait;

    By finishButton = AppiumBy.accessibilityId("test-FINISH");

    public CheckoutOverviewPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void ScrollAndClickFinishButton() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                        "new UiSelector().description(\"test-FINISH\"));"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
        driver.findElement(finishButton).click();
    }
}
