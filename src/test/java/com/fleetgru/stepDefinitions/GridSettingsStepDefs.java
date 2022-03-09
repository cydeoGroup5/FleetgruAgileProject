package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GridSettingsStepDefs {
    VehiclesPage vehiclesPage=new VehiclesPage();
    List<WebElement> element=vehiclesPage.gridSettingsList;
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
    @And("user types {string}")
    public void userTypes(String columnName) {
        vehiclesPage.typeAnyOptionForQuickSearch(columnName);

    }
    @Then("user should be able to see {string} column")
    public void userShouldBeAbleToSeeColumn(String columnName) {
        System.out.println("vehiclesPage.isQuickSearchWorkingProperly(columnName) = " + vehiclesPage.isQuickSearchWorkingProperly(columnName));

    }


    @When("user clicks on the {string}")
    public void userClicksOnThe(String columnName) {
        vehiclesPage.clickOnColumnNames(columnName);
    }

    @Then("user should be able to select the {string}")
    public void userShouldBeAbleToSelectThe(String arg0) {
      Assert.assertTrue(vehiclesPage.isColumnNameDisplayed(arg0));
    }

    @Then("user should be able to arrange the order of the columns")
    public void userShouldBeAbleToArrangeTheOrderOfTheColumns() {
        vehiclesPage.dragAndDropColumns();
    }

    @Then("user should be able to see the {string}")
    public void userShouldBeAbleToSeeThe(String arg0) {
        Assert.assertTrue(vehiclesPage.isColumnNameDisplayed(arg0));
    }




}
