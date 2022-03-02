package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDesf {

    DashboardPage dashboardPage = new DashboardPage();
    private final String blankTabTitle = "Untitled";

    @When("user click logout button")
    public void user_click_logout_button() {
        dashboardPage.logOut();
    }

    //TODO:We can add more convenient wait for navigating login page
    /**
     *
     * @param expectedPage
     */
    @Then("user should ends up the {string} page")
    public void user_should_ends_up_the_page(String expectedPage) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals("Page titles are not same",expectedPage, Driver.get().getTitle());
    }

    @When("user click back button")
    public void userClickBackButton() {
        Driver.get().navigate().back();
    }

    /**
     * Check the BrowserUtils for method
     * It is one of the homemade method :)
     */
    @And("user open a new tab")
    public void userOpenANewTab() {
        BrowserUtils.waitFor(1);
        BrowserUtils.openNewTab();
    }

    /**
     * Check the BrowserUtils for method
     * It is one of the homemade method :)
     * @param closingTabTitle
     */
    @When("user close the {string} page")
    public void userCloseThePage(String closingTabTitle) {
        BrowserUtils.closeSpecificTab(closingTabTitle);
        BrowserUtils.switchToWindow(blankTabTitle);
    }

}
