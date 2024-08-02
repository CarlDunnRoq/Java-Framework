package utils.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeWebDriver {

    private static WebDriver driver;

    private static void setupEdgeDriver() {
        WebDriverManager.edgedriver().setup();
    }

    public static WebDriver loadEdgeDriver(String edgeArgument) {
        setupEdgeDriver();

        EdgeOptions options = new EdgeOptions();
        options.addArguments(edgeArgument);

        driver = new EdgeDriver(options);
        return driver;
    }
}