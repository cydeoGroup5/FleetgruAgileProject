package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DeleteCarStepDef {

    @When("user should navigate to {string} {string} tab")
    public void user_should_navigate_to_tab(String tab, String module) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderMaskDisappear();
        dashboardPage.navigateTo(tab,module);
        dashboardPage.waitUntilLoaderMaskDisappear();
    }


    @And("user hover over the three dots at the end of each row")
    public void userHoverOverTheThreeDotsAtTheEndOfEachRow() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(new VehiclesPage().dots).pause(80).perform();
        BrowserUtils.waitFor(2);
    }

    @Then("user can see the delete button")
    public void userCanSeeTheDeleteButton() {
        Assert.assertTrue(new VehiclesPage().deleteButton.isEnabled());
    }

    @And("user hover over the three dots at the end of each row for driver")
    public void userHoverOverTheThreeDotsAtTheEndOfEachRowForDriver() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(new VehiclesPage().dotsForDriver).pause(80).perform();
        BrowserUtils.waitFor(2);
    }
}
