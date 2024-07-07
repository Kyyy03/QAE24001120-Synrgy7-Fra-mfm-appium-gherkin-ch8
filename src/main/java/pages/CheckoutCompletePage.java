package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    AndroidDriver driver;
    WebDriverWait wait;

    By checkOutTitle = By.xpath("//*[contains(@text, 'CHECKOUT: COMPLETE!')]");
    By completeHeader = By.xpath("//*[contains(@text, 'THANK YOU FOR YOU ORDER')]");

    public CheckoutCompletePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public boolean getCheckOutTitle() {
        return driver.findElement(checkOutTitle).isDisplayed();
    }
    public boolean getCompleteHeader() {
        return driver.findElement(completeHeader).isDisplayed();
    }
}
