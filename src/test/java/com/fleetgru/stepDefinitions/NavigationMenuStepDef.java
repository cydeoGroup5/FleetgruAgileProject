package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.GeneralInfoPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class NavigationMenuStepDef {
        GeneralInfoPage generalInfoPage = new GeneralInfoPage();
    @And("the user navigates to {string}, {string}")
    public void theUserNavigatesTo(String tab, String module) {
        //selenium code
        BrowserUtils.waitFor(3);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateTo(tab, module);
        dashboardPage.waitUntilLoaderMaskDisappear();
        System.out.println("the user navigates to Fleet, Vehicles");
        BrowserUtils.waitFor(3);
    }


    @Then("the user should land on the {string} page")
    public void theUserShouldLandOnThePage(String expectedTitle) {
        BrowserUtils.waitFor(5);
        String actualTitle = Driver.get().getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
        BrowserUtils.waitForPageToLoad(3);

    }


    @And("user clicks on the eye icon")
    public void userClicksOnTheEyeIcon() {
        new DashboardPage().waitUntilLoaderMaskDisappear();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(generalInfoPage.managerThreeDot).pause(80).perform();
        BrowserUtils.waitFor(2);
        generalInfoPage.clickeyeIcon();
        BrowserUtils.waitFor(3);

    }

    @And("user clicks on the eye icon for driver")
    public void userClicksOnTheEyeIconForDriver() {
        new DashboardPage().waitUntilLoaderMaskDisappear();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(generalInfoPage.driverThreeDot).pause(80).perform();
        BrowserUtils.waitFor(2);
        generalInfoPage.clickeyeIcon();
        BrowserUtils.waitFor(3);

    }

    @Then("the user should land on the {string}")
    public void theUserShouldLandOnThe(String generalInfo) {
        BrowserUtils.waitFor(3);
        String actualTitle= generalInfoPage.genInfoPageTitle.getText();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(generalInfo,actualTitle);
    }

    @Then("the user should see {string} {string} {string} buttons")
    public void the_user_should_see_buttons(String drvAddEventBtn, String editBtn, String deleteBtn) {
        BrowserUtils.waitFor(5);
        Boolean actualAddEventBtn=generalInfoPage.driverAddEventBtn.isDisplayed();
        Assert.assertEquals(true,actualAddEventBtn);

        Boolean actualEditBtn= generalInfoPage.editBtn.isDisplayed();
        Assert.assertEquals( true,actualEditBtn);

        Boolean actualDeleteBtn = generalInfoPage.deleteBtn.isDisplayed();
        Assert.assertEquals( true,actualDeleteBtn);
    }


    @Then("the user should not see {string} {string} {string} buttons")
    public void the_user_should_not_see_buttons(String editBtn, String addEventBtn, String deleteBtn) {

        try {
            Boolean actualAddEventBtn = generalInfoPage.driverAddEventBtn.isDisplayed();
            Assert.assertEquals(false, actualAddEventBtn);
        } catch (Exception e) {
            Boolean actualEditBtn = generalInfoPage.editBtn.isDisplayed();
            Assert.assertEquals(false, actualEditBtn);

            Boolean actualDeleteBtn = generalInfoPage.deleteBtn.isDisplayed();
            Assert.assertEquals(false, actualDeleteBtn);


        }
    }
    @And("the user take the information from General Information page")
    public void theUserTakeTheInformationFromGeneralInformationPage() {

        generalInfoPage.setMenu();

    }
    @And("the user goes back the {string} page")
    public void thUserGoesBackThePage(String fleeetVehiclePage) {
        BrowserUtils.waitFor(2);
        Driver.get().navigate().back();

    }

    @And("the user take the information from Fleet-Vehicle page")
    public void theUserTakeTheInformationFromFleetVehiclePage() {
        BrowserUtils.waitFor(2);
        generalInfoPage.setMenu1();
    }
    @Then("Vehicle information displayed on the {string} page and {string} page should be the same")
    public void vehicleInformationDisplayedOnThePageAndPageShouldBeTheSame(String genInformation, String VehicleInformation) {
        BrowserUtils.waitFor(2);
       Assert.assertEquals("setMenu","setMenu1");


    }

}
