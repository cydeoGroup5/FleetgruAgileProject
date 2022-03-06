package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.LoginPage;
import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

//      _________                               _______
//     |         |   |\       |   |         |  |       |
//     |         |   | \      |   |         |  |       |
//     |         |   |  \     |   |         |  |       |
//     |         |   |   \    |   |         |  |_______|
//     |         |   |    \   |   |         |  |    \
//     |         |   |     \  |   |         |  |     \
//     |         |   |      \ |   |         |  |      \
//     |_________|   |       \|   |_________|  |       \

public class FilterViewStepDefs {

    @When("user clicks on filter icon")
    public void user_clicks_on_filter_icon() {
        BrowserUtils.waitFor(2);
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.filterIcon.click();
    }


    @Then("the {string} button should be visible")
    public void the_button_should_be_visible(String string) {
        BrowserUtils.waitFor(2);
        VehiclesPage vehiclesPage = new VehiclesPage();

        vehiclesPage.manageFilters.click();
        Assert.assertTrue(vehiclesPage.manageFilters.isDisplayed());
    }

    @And("user click {string}")
    public void userClick(String manageFilter) {
        BrowserUtils.waitFor(2);
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.filterIcon.click();
        vehiclesPage.manageFilters.click();

    }

    @When("user apply filters by typing {string}")
    public void userApplyFiltersByTyping(String option) {

        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.searchBoxInput.sendKeys(option);

    }

    @Then("user can apply filters by  clicking on the {string}")
    public void userCanApplyFiltersByClickingOnThe(String option) {
        String path = "//label[@title='" + option + "']";
        WebElement optionElement = Driver.get().findElement(By.xpath(path));
        optionElement.click();
        String path1 = "//label[@title='" + option + "']//input";
        Assert.assertTrue("Verify that" + option + "is selected", Driver.get().findElement(By.xpath(path1)).isSelected());
    }

    // It is important for dynamic locator for  manage filter menu
    @Then("the {string} should be seen and clickable")
    public void theShouldBeSeenAndClickable(String option) {
        BrowserUtils.waitFor(2);

        String path = "//label[@title='" + option + "']";
        WebElement optionElement = Driver.get().findElement(By.xpath(path));

        String title = optionElement.getAttribute("title");
        Assert.assertEquals("Verify option1 same with searh text", option, title);
    }

    @When("User clicks {string}{string}{string}")
    public void userClicks(String option1, String option2, String option3) {
        BrowserUtils.waitFor(2);
        String path1 = "//label[@title='" + option1 + "']";
        String path2 = "//label[@title='" + option2 + "']";
        String path3 = "//label[@title='" + option3 + "']";
        Driver.get().findElement(By.xpath(path1)).click();
        Driver.get().findElement(By.xpath(path2)).click();
        Driver.get().findElement(By.xpath(path3)).click();
    }

    @Then("the filters {string}{string}{string} are checked")
    public void theFiltersAreChecked(String option1, String option2, String option3) {
        BrowserUtils.waitFor(2);
        String path1 = "//label[@title='" + option1 + "']//input";
        String path2 = "//label[@title='" + option2 + "']//input";
        String path3 = "//label[@title='" + option3 + "']//input";


        BrowserUtils.waitFor(2);
        Assert.assertTrue("Verify that" + option1 + "is selected", Driver.get().findElement(By.xpath(path1)).isSelected());
        Assert.assertTrue("Verify that" + option2 + "is selected", Driver.get().findElement(By.xpath(path2)).isSelected());
        Assert.assertTrue("Verify that" + option3 + "is selected", Driver.get().findElement(By.xpath(path3)).isSelected());

    }

    @When("user clicks on the reset icon")
    public void userClicksOnTheResetIcon() {
        BrowserUtils.waitFor(1);
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.filterIcon.click();
        vehiclesPage.manageFilters.click();
        String path1 = "//label[@title='Tags']";
        Driver.get().findElement(By.xpath(path1)).click();
        vehiclesPage.refreshFilterButton.click();
        Assert.assertFalse(Driver.get().findElement(By.xpath(path1)).isDisplayed());
    }

    @Then("All filters should be removed")
    public void all_filters_should_be_removed() {
        String path1 = "//label[@title='Tags']";
        Assert.assertFalse(Driver.get().findElement(By.xpath(path1)).isDisplayed());
    }


}
