package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleTableStepDefs {



    VehiclesPage vp = new VehiclesPage();

    @When("user click on View Per Page button")
    public void userClickOnButton() {

        BrowserUtils.waitForClickablility(vp.viewPerPage,6);
        vp.viewPerPage.click();

    }


    @Then("user should see numbers to be displayed")
    public void userShouldSeeNumbersToBeDisplayed(List<String> parameters) {

        Assert.assertEquals(parameters,vp.getViewOptions());

    }


    @Then("user should see default value is {string}")
    public void userShouldSeeDefaultValueIs(String value) {

        Assert.assertEquals(value,vp.viewPerPage.getText());


    }

    @Then("user can select any value in View Per Page menu")
    public void userCanSelectAnyValueInViewPerPageMenu() {

        WebElement element1 = vp.viewPerPageOptions1;
        BrowserUtils.waitForClickablility(element1,2);
        element1.click();
        Assert.assertTrue(element1.isEnabled());

        WebElement element2 = vp.viewPerPageOptions2;
        Assert.assertTrue(element2.isEnabled());

        WebElement element3 = vp.viewPerPageOptions3;
        Assert.assertTrue(element3.isEnabled());

        WebElement element4 = vp.viewPerPageOptions4;
        Assert.assertTrue(element4.isEnabled());

    }

    @When("user click any {string} two times")
    public void userClickAnyTwoTimes(String header) {
        WebElement element = Driver.get().findElement(By.xpath("//span[normalize-space()='" + header + "'][@class='grid-header-cell__label']"));
        BrowserUtils.scrollToElement(element);
        BrowserUtils.waitForClickablility(element,5);
        element.click();
        BrowserUtils.waitFor(1);
        element.click();
        BrowserUtils.waitFor(1);
    }

    @Then("user should see {string} in {string} order")
    public void userShouldSeeInOrder(String column, String order) {
        Assert.assertTrue(vp.getColumnOrder(order,column));
    }


    @When("user click any {string}")
    public void userClickAny(String header) {
        WebElement element = Driver.get().findElement(By.xpath("//span[normalize-space()='" + header + "'][@class='grid-header-cell__label']"));
        BrowserUtils.scrollToElement(element);
        BrowserUtils.waitForClickablility(element,5);
        element.click();
        BrowserUtils.waitFor(2);
    }

    @When("user click on refresh button")
    public void userClickOnRefreshButton() {
        BrowserUtils.waitForClickablility(vp.refreshbtn,5);
        vp.refreshbtn.click();
        BrowserUtils.waitFor(2);

    }

    @Then("user should see all sorting are removed")
    public void userShouldSeeAllSortingAreRemoved() {

        Assert.assertFalse(vp.getColumnOrder("ascending","Driver"));

    }
}
