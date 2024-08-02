package utils.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.selenium.DriverController;

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
}