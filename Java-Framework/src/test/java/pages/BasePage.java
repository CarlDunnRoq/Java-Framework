package pages;

import static utils.selenium.Driver.browser;
import org.openqa.selenium.WebDriver;

public class BasePage extends Page {

    public WebDriver driver = browser();
}
