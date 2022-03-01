package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user login as {string}")
    public void user_login_as(String userType) {
        loginPage.loginAsGivenUser(userType);
    }

    @Then("user should land on {string} page")
    public void userShouldLandOnPage(String expectedSubTitle) {
        new DashboardPage().waitUntilLoaderMaskDisappear();
        String actualSubTitle = new DashboardPage().pageSubTitle.getText();
        Assert.assertEquals(expectedSubTitle,actualSubTitle);
    }

}
