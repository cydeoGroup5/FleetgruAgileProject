package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.AddEventPage;
import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEventStepDefs {
    LoginPage loginPage = new LoginPage();
    AddEventPage addEventPage = new AddEventPage();
    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 20);


    @When("the Driver log in with valid credantials")
    public void theDriverLogInWithValidCredantials() {
        loginPage.loginAsDriver();
        dashboardPage.waitUntilLoaderMaskDisappear();
    }

    @Then("the user Hover Over Fleet and click  Vehicles")
    public void theUserHoverOverFleetAndClickVehicles() {

        dashboardPage.navigateTo("Fleet", "Vehicles");
    }


    @Then("the user click any car info")
    public void the_user_click_any_car_info() {

        try {
            BrowserUtils.waitFor(2);
            addEventPage.XcloseOnAddEvent.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        addEventPage.clickCarGoToAddEvent();
    }


    @Then("verify that General Information page opened and Driver cannot see Add Event Button")
    public void verifyThatGeneralInformationPageOpenedAndDriverCannotSeeAddEventButton() {
        String ActualTitle = addEventPage.Title_General_Info_Page();
        Assert.assertEquals("General Information", ActualTitle);
        wait.until(ExpectedConditions.visibilityOf(addEventPage.AddEvent));
        Boolean ActualFalse = addEventPage.AddEvent.isDisplayed();

            Assert.assertEquals(false, ActualFalse);

    }

    @Then("verify that General Information page opened and Add Event Button is seen")
    public void verify_that_General_Information_page_opened_and_Add_Event_Button_is_seen() {
        String ActualTitle = addEventPage.Title_General_Info_Page();
        Assert.assertEquals("General Information", ActualTitle);
        wait.until(ExpectedConditions.visibilityOf(addEventPage.AddEvent));
        Boolean ActualTrue = addEventPage.AddEvent.isDisplayed();


            Assert.assertEquals(true, ActualTrue);

    }

    @Then("Verify that Add Event page should pop up.")
    public void verify_that_Add_Event_page_should_pop_up() {
        BrowserUtils.waitFor(5);
        addEventPage.AddEvent_Click();
        BrowserUtils.waitFor(10);
        addEventPage.AddEvent_Page_title_verify();
        wait.until(ExpectedConditions.visibilityOf(addEventPage.XcloseOnAddEvent));
        addEventPage.XcloseOnAddEvent.click();

    }

    @Then("Verify that List of Comp.Fields is <Title,Owner,Organizer display name,Organizer email,Start Date,End Date>")
    public void verify_that_List_of_Comp_Fields_is_Title_Owner_Organizer_display_name_Organizer_email_Start_Date_End_Date() {
        BrowserUtils.waitFor(5);
        addEventPage.CompulsoryFieldCheck();

        wait.until(ExpectedConditions.visibilityOf(addEventPage.XcloseOnAddEvent));
        addEventPage.XcloseOnAddEvent.click();

    }

    @Then("The Sales Manager enters {string} , {string} , {string} , {string} , {string} ,{string}")
    public void the_Sales_Manager_enters(String Title, String Owner, String Organizer_display, String Organizer_email, String Start_date, String Stope_date) {
        addEventPage.TitleInput.sendKeys(Title);
        BrowserUtils.waitFor(2);
        addEventPage.OrganizerDisplayNameInput.sendKeys(Organizer_display);
        BrowserUtils.waitFor(2);
        addEventPage.organizeremailInput.sendKeys(Organizer_email);
        BrowserUtils.waitFor(2);
        addEventPage.StartInput.clear();
        BrowserUtils.waitFor(2);
        addEventPage.StartInput.sendKeys(Start_date);
        BrowserUtils.waitFor(2);
        addEventPage.EndInput.clear();
        BrowserUtils.waitFor(2);
        addEventPage.EndInput.sendKeys(Stope_date);
        BrowserUtils.waitFor(2);
        Actions actions = new Actions(Driver.get());
        actions.click().build().perform();
        BrowserUtils.waitFor(2);
    }

    @Then("Click The Save Button")
    public void click_The_Save_Button() {

        BrowserUtils.waitFor(2);
        addEventPage.SaveButton.click();

    }

    @Then("Verify That {string} message appears.")
    public void verify_That_message_appears(String ExpectedMessage) {
        ExpectedMessage = "This value should not be blank.";
        String ActualMessage = "";
        System.out.println("addEventPage.TitleInput.getText() = " + addEventPage.TitleInput.getText());
        if (addEventPage.TitleInput.getText().equals("")) {
            try {
                ActualMessage = addEventPage.TitleInputErrorMessage.getText();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }


        } else if (addEventPage.StartInput.getText().equals("")) {
            try {
                ActualMessage = addEventPage.StartInputerrorMessage.getText();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }

        } else if (addEventPage.EndInput.getText().equals("")) {
            try {
                ActualMessage = addEventPage.EndInputerrorMessage.getText();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }

        } else {

            ActualMessage = addEventPage.AfterSaveMessage.getAttribute("innerText");
        }

        System.out.println("ActualMessage = " + ActualMessage);

        Assert.assertEquals(ExpectedMessage, ActualMessage);


    }


    @Then("The User click Add Event Button")
    public void the_User_click_Add_Event_Button() {
        BrowserUtils.waitFor(10);
        wait.until(ExpectedConditions.visibilityOf(addEventPage.AddEvent));
        addEventPage.AddEvent_Click();
    }


    @Given("the users on the logging page")
    public void theUsersOnTheLoggingPage() {
        dashboardPage.navigateToHomePage();
    }


    @When("the Sales Manager log in with valid credantials")
    public void theSalesManagerLogInWithValidCredantials() {
        loginPage.loginAsSalesManager();
    }

    @When("the Store Manager log in with valid credantials")
    public void theStoreManagerLogInWithValidCredantials() {
        loginPage.loginAsStoreManager();
    }


    @And("user click logout button_AddEvent")
    public void userClickLogoutButton_AddEvent() {
        try {
            BrowserUtils.waitFor(10);
            addEventPage.XcloseOnAddEvent.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        BrowserUtils.waitForClickablility(By.id("user-menu"), 10);
        Driver.get().findElement(By.id("user-menu")).click();
        Driver.get().findElement(By.linkText("Logout")).click();

    }
}
