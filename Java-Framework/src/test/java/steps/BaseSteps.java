package steps;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.BasePage;
import pages.Page;

import java.util.List;

public class BaseSteps extends Page {
    @Given("a DuckDuckGo user is on the base page")
    public void aDuckDuckGoUserIsOnTheBasePage() throws Throwable{
        instanceOf(BasePage.class).navigateToBaseUrl();
    }

    @Then("they see the page title contains {string}")
    public void theySeeThePageTitleContains(String expectedTitle) throws Throwable{
        instanceOf(BasePage.class).validatePageTitle(expectedTitle);
    }

    @Then("they see the page Url contains {string}")
    public void theySeeThePageUrlContains(String expectedUrl) throws Throwable {
        instanceOf(BasePage.class).validatePageUrl(expectedUrl);
    }

    @Then("they see {string} in the PageSource")
    public void theySeeInThePageSource(String expectedPageSource) {
        instanceOf(BasePage.class).validatePageSource(expectedPageSource);
        throw new PendingException();
    }

    @Then("they see")
    public void theySee(List<String> existsInPageSource) throws Throwable{
        instanceOf(BasePage.class).validateMultipleInPageSources(existsInPageSource);
        throw new PendingException();
    }
}
