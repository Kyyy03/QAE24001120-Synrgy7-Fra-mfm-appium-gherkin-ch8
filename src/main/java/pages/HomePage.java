package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    AndroidDriver driver;
    WebDriverWait wait;

    // Locator atau element
    By textProducts = By.xpath("//*[contains(@text, 'PRODUCTS')]");
    By ATC1 = By.xpath("(//android.widget.TextView[@text=\"+\"])[1]");
    By ATC2 = By.xpath("(//android.widget.TextView[@text=\"+\"])[3]");
    By sortContainer = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By sortL2H = By.xpath("//*[contains(@text, 'Price (low to high)')]");
    By sortH2L = By.xpath("//android.widget.TextView[@text=\"Price (high to low)\"]");
    By changeView = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView");
    By itemPrices = By.xpath("//*[contains(@text, '$7.99')]");
    By logoPict = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]");
    By cartButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Action Method
    public boolean textProductIsDisplayed() {
        return driver.findElement(textProducts).isDisplayed();
    }
    public boolean logoPictIsDisplayed() {
        return driver.findElement(logoPict).isDisplayed();
    }
    public void ClickATC1Button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ATC1));
        driver.findElement(ATC1).click();
    }
    public void ClickATC2Button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ATC2));
        driver.findElement(ATC2).click();
    }
    public void ClickCartButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
        driver.findElement(cartButton).click();
    }
    public void ClickSortContainer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortContainer));
        driver.findElement(sortContainer).click();
    }
    public void ClickSortLowtoHigh() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortL2H));
        driver.findElement(sortL2H).click();
    }
    public void ClickSortHightoLow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortH2L));
        driver.findElement(sortH2L).click();
    }
    public void ClickChangeView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeView));
        driver.findElement(changeView).click();
    }
    public boolean isSortedByLowToHigh() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemPrices));
        List<WebElement> priceElements = driver.findElements(itemPrices);
        List<Double> prices = priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());

        for (int i = 0; i > prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
