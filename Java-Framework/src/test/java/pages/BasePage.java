package pages;

import static utils.selenium.Driver.browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.selenium.Settings;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.Keys;

import java.util.List;

public class BasePage extends Page {

    public WebDriver driver = browser();

    public void navigateToBaseUrl(){
        String baseUrl = Settings.baseUrl;
        browser().navigate().to(baseUrl);
        System.out.println("Welcome to the Automation Framework");
    }

    public void validatePageTitle(String expectedTitle){
        Assert.assertTrue(getTitle().contains(expectedTitle));
        System.out.println(":: The title of the site is: " + getTitle());
    }

    public void validatePageUrl(String expectedUrl){
        Assert.assertTrue(getUrl().contains(expectedUrl));
        System.out.println(":: The URL of the page is: " + getUrl());
    }

    public void validatePageSource(String expectedPageSource){
        Assert.assertTrue(getPageSource().contains(expectedPageSource));
        System.out.println(":: The page source is: " + getPageSource());
    }

    public void validateMultipleInPageSources(List<String> table){
        for (String row : table){
            Assert.assertTrue(getPageSource().contains(row));
            System.out.println("The text " + row + " is in the PageSource");
        }
    }
}
