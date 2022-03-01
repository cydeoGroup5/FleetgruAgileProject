package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDesf {

    DashboardPage dashboardPage = new DashboardPage();

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
        BrowserUtils.waitFor(2);
        Assert.assertEquals("Page titles are not same",expectedPage, Driver.get().getTitle());
    }
}
