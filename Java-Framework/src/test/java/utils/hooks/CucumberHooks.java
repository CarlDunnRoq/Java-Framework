package utils.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.selenium.DriverController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CucumberHooks {


    @Before("@Chrome")
    public void beforeChrome(){
        DriverController.instance.startChrome("--disable-extensions");
    }

    @Before("@Firefox")
    public void beforeFirefox() throws Exception {
        DriverController.instance.startFirefox("--disable-extensions");
    }

    @Before("@Edge")
    public void beforeEdge() throws Exception {
        DriverController.instance.startEdge("--disable-extensions");
    }

    @Before("@HeadlessChrome")
    public void beforeChromeHeadless() {
        DriverController.instance.startChrome("--headless");
    }

    @Before("@HeadlessFirefox")
    public void beforeHeadlessFirefox() throws Exception {
        DriverController.instance.startFirefox("--headless");
    }

    @After("@HeadlessEdge")
    public void beforeHeadlessEdge() throws Exception {
        DriverController.instance.startEdge("--headless");
    }

    @After
    public void stopWebDriver() {
        DriverController.instance.stopWebDriver();
    }

    @Before("@Web")
    public void beforeWeb() throws IOException {
        Properties browserProps = new Properties();
        browserProps.load(new FileInputStream("src/test/resources/config.properties"));

        String browser = browserProps.getProperty("browserName");
        String url = browserProps.getProperty("baseUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            DriverController.instance.startChrome("--disable-extensions");
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            DriverController.instance.startFirefox("--disable-extensions");
        }
        else if (browser.equalsIgnoreCase("headlessChrome")) {
            DriverController.instance.startChrome("--headless");
        }
        else if (browser.equalsIgnoreCase("headlessFirefox")) {
            DriverController.instance.startFirefox("--headless");
        }
    }
}