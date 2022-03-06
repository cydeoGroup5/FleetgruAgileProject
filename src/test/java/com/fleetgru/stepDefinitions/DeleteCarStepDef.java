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

    String deletedCarInfo;

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

    @When("user clicks on delete button")
    public void userClicksOnDeleteButton() {
        new VehiclesPage().clickDeleteButton();
        BrowserUtils.waitFor(1);
    }

    @Then("Delete Confirmation popup should be displayed")
    public void deleteConfirmationPopupShouldBeDisplayed() {
        Assert.assertTrue(new VehiclesPage().deleteConfirmation.isDisplayed());
    }

    @When("user clicks Yes Delete button")
    public void userClicksYesDeleteButton() {
        BrowserUtils.clickWithJS(new VehiclesPage().yesDelete);
        BrowserUtils.waitFor(2);
    }

    @Then("{string} message should be displayed for driver")
    public void messageShouldBeDisplayedForDriver(String ExpectedMessage) {
        String ActualMessage = new VehiclesPage().permissionMessage.getText();
        Assert.assertEquals(ExpectedMessage,ActualMessage);
    }

    @Then("{string} message should be displayed for sales and store manager")
    public void messageShouldBeDisplayedForSalesAndStoreManager(String ExpectedMessage) {
        String ActualMessage = new VehiclesPage().itemDeleted.getText();
        Assert.assertEquals(ExpectedMessage,ActualMessage);
    }

    @And("user clicks on first raw from Cars table")
    public void userClicksOnFirstRawFromCarsTable() {
        BrowserUtils.waitForClickablility(new VehiclesPage().row1, 5);
        deletedCarInfo = new VehiclesPage().getfirstrowText();
        System.out.println("deletedCarInfo = " + deletedCarInfo);
        new VehiclesPage().row1.click();
        new DashboardPage().waitUntilLoaderMaskDisappear();
    }

    @Then("user navigates to General Information Page")
    public void userNavigatesToGeneralInformationPage() {
        String ExpectedHeader = "General Information";
        String ActualHeader = new VehiclesPage().GenInfoPageTitle.getText();
        Assert.assertEquals(ExpectedHeader, ActualHeader);
    }

    @When("user click on delete button")
    public void userClickOnDeleteButton() {
        BrowserUtils.waitForClickablility(new VehiclesPage().GenInfoDeleteButton, 5);
        new VehiclesPage().GenInfoDeleteButton.click();
        BrowserUtils.waitFor(1);
    }


    @Then("{string} message should be displayed for Sales and Store Managers")
    public void messageShouldBeDisplayedForSalesAndStoreManagers(String ExpectedMessage) {
        String ActualMessage = new VehiclesPage().carDeleted.getText();
        Assert.assertEquals(ExpectedMessage,ActualMessage);
    }

    @Then("the corresponding car should also be removed from the Fleet-Vehicle page.")
    public void theCorrespondingCarShouldAlsoBeRemovedFromTheFleetVehiclePage() {
        BrowserUtils.waitFor(2);
        String tableInfo = new VehiclesPage().table.getText();
        System.out.println("tableInfo = " + tableInfo);
        Assert.assertFalse(tableInfo.contains(deletedCarInfo));


    }
}
