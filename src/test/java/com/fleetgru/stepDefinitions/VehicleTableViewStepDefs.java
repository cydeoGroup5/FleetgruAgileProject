package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VehicleTableViewStepDefs {
    @Then("Users can see all vehicle information table")
    public void usersCanSeeAllVehicleInformationTable() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(vehiclesPage.vehicleTable.isDisplayed());
    }

    @Then("User can see page number")
    public void userCanSeePageNumber() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(vehiclesPage.pageNumber.isDisplayed());
        System.out.println("vehiclesPage.pageNumber.getText() = " + vehiclesPage.pageNumber.getAttribute("value"));
    }

    @Then("User can click on a forward button")
    public void userCanClickOnAForwardButton() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.pageForwardBtn.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(vehiclesPage.pageForwardBtn.isEnabled());
    }

    @And("User can click on a backwards button")
    public void userCanClickOnABackwardsButton() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.pageBackwardsBtn.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(vehiclesPage.pageBackwardsBtn.isEnabled());
    }

    @Then("User can see recording number of vehicles")
    public void userCanSeeRecordingNumberOfVehicles() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        Assert.assertTrue(vehiclesPage.totalRecordings.isDisplayed());
    }

    @Then("User can download XLS file from Export Grid")
    public void userCanDownloadXLSFileFromExportGrid() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.exportBtn.click();
        BrowserUtils.waitFor(1);
        vehiclesPage.csvBtn.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(vehiclesPage.exportMessage.isDisplayed());
    }

    @And("User can download CSV file from Export Grid")
    public void userCanDownloadCSVFileFromExportGrid() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.exportBtn.click();
        BrowserUtils.waitFor(1);
        vehiclesPage.xlsxBtn.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(vehiclesPage.exportMessage.isDisplayed());
    }
}
