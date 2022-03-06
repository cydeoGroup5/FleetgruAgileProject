package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.CreateCarPage_omer;
import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.VehiclesPage_omer;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefs {

    CreateCarPage_omer carPage = new CreateCarPage_omer();
    VehiclesPage_omer vehiclePage = new VehiclesPage_omer();

    @When("user navigate to {string} {string}")
    public void user_navigate_to(String tab, String module) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderMaskDisappear();
        dashboardPage.navigateTo(tab,module);
        dashboardPage.waitUntilLoaderMaskDisappear();
    }

    @Then("user should not see Create Car button")
    public void user_should_not_see_Create_Car_button() {
        VehiclesPage_omer vehicle = new VehiclesPage_omer();
    }

    @Then("user should see Create Car button")
    public void user_should_see_Create_Car_button() {
        Assert.assertTrue(vehiclePage.getCreateCarBtn().isDisplayed());
    }

    @When("user click Create Car button")
    public void user_click_Create_Car_button() {
        vehiclePage.getCreateCarBtn().click();
        vehiclePage.waitUntilLoaderMaskDisappear();
    }

    @Then("user should see following titles")
    public void user_should_see_following_titles(List<String> expectedDataTitles) {
        Assert.assertEquals(expectedDataTitles,carPage.getDataTitles());
    }

    @Then("user should see following check box names")
    public void user_should_see_following_check_box_names(List<String> expectedCheckboxNames) {
        Assert.assertEquals(expectedCheckboxNames,carPage.getCheckboxesNames());
    }

    @Then("user should see following option under Transmission dropdown")
    public void user_should_see_following_option_under_Transmission_dropdown(List<String> expectedDropdownOptions) {
        Assert.assertEquals(expectedDropdownOptions,carPage.getTransmissionOptions());
    }

    @Then("user should see following option under Fuel Type dropdown")
    public void user_should_see_following_option_under_Fuel_Type_dropdown(List<String> expectedDropdownOptions) {
        Assert.assertEquals(expectedDropdownOptions,carPage.getFuelTypeOptions());
    }

    @And("user upload {string}")
    public void userUpload(String logo) {
        carPage.uploadFile(logo);
    }

    @Then("user can upload {string}")
    public void userCanUpload(String logo) {
        Assert.assertTrue(carPage.uploadInputBox.getAttribute("value").contains(logo));
    }

    @Then("user should see following option under sava dropdown")
    public void userShouldSeeFollowingOptionUnderSavaDropdown(List<String> dropdownOptions) {
        Assert.assertEquals(dropdownOptions,carPage.getSaveOptions());
    }

    @When("user choose {string} option")
    public void userChooseOption(String saveOption) {
        carPage.selectSaveOption(saveOption);
        carPage.waitUntilLoaderMaskDisappear();
    }

    @Then("user should see {string} message after saving")
    public void user_should_see_message_after_saving(String expectedMsg) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(expectedMsg,carPage.getMsg());
    }

    @Then("user get titles")
    public void userGetTitles() {
        CreateCarPage_omer page = new CreateCarPage_omer();
        page.getDataTitles();
    }

    @And("user fill the form")
    public void userFillTheForm(Map<String,Object> formData) {
        carPage.fillForm(formData);
    }

}
