package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.helpers.WebDriverHelpers;
import utils.helpers.WebElementHelpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.selenium.Driver.browser;

public class Page {

    public WebDriver driver = browser();
    public String getTitle(){return driver.getTitle();}
    public String getUrl(){return driver.getCurrentUrl();}
    public String getPageSource(){return driver.getPageSource();}

    protected WebElementHelpers elementHelpers = new WebElementHelpers();
    protected WebDriverHelpers driverHelpers = new WebDriverHelpers();

    public void getProperties()throws IOException {
        Properties browserProps = new Properties();
        browserProps.load(new FileInputStream("src/test/resources/config.properties"));

        String browser = browserProps.getProperty("browserName");
        String url = browserProps.getProperty("baseUrl");
    }

    public static <T extends BasePage> T instanceOf(Class<T> clazz) {
        return PageFactory.initElements(browser(), clazz);
    }
}