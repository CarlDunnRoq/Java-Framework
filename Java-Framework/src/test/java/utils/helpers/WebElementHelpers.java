package utils.helpers;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static utils.selenium.Driver.browser;

public class WebElementHelpers {

    public WebDriverWait weWaitForSeconds() {
        WebDriverWait wait = new WebDriverWait(browser(), Duration.ofSeconds(10));
        return wait;
    }

    public boolean weElementIsDisplayed(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean weElementToBeClickable(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public void weClick(WebElement element) {
        weElementToBeClickable(element);
        element.click();
    }

    public void weSendKeys(WebElement element, String text, boolean clearFirst) {
        weElementIsDisplayed(element);
        if (clearFirst) weClick(element);
        element.sendKeys(text);
    }

    public boolean weElementIsInvisible(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.invisibilityOf(element));
        return !element.isDisplayed();
    }

    public static String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}
