package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class GridSettingsStepDefs {
    VehiclesPage vehiclesPage=new VehiclesPage();
    @When("user clicks on the gear icon")
    public void userClicksOnTheGearIcon() {
        vehiclesPage.gearIcon.click();

    }

    @Then("user should be able to see grid settings")
    public void userShouldBeAbleToSeeGridSettings() {
        String expected="Grid Settings";
        String actual=vehiclesPage.gridSettingsText.getText();
        Assert.assertEquals("Expected and actual is NOT same",expected,actual);

    }



    @Then("user should be able to see following options")
    public void userShouldBeAbleToSeeFollowingOptions(List<String> menuOptions) {
        List<String> actualOptions=BrowserUtils.getElementsText(vehiclesPage.gridSettingsList);
        Assert.assertEquals(menuOptions,actualOptions);


    }
}
