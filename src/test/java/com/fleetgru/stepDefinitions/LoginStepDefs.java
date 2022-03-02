package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(5);
    }

    /**
     * Login with specified user type.
     * ATTENTION: Check loginAsGivenUser() method for specific userTypes.
     * @param userType
     */
    @When("user login as {string}")
    public void user_login_as(String userType) {
        loginPage.loginAsGivenUser(userType);
    }

    /**
     * Checking whether login successfully or not with checking pageSubTitle (not title)
     * @param expectedSubTitle
     */
    @Then("user should land on {string} page")
    public void userShouldLandOnPage(String expectedSubTitle) {
        new DashboardPage().waitUntilLoaderMaskDisappear();
        String actualSubTitle = new DashboardPage().pageSubTitle.getText();
        Assert.assertEquals(expectedSubTitle,actualSubTitle);
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMsg) {
        String actualMsg = loginPage.invalidCredentialErrorMsg.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    /**
     * !!ATTENTION: there is no submitting after sending credentials
     * @param username
     * @param password
     */
    @When("user enter {string} and {string}")
    public void user_enter_and(String username, String password) {
        loginPage.usernameInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.loginBtn.click();
    }

    /**
     * This assertion for sending empty credentials
     * It will check both username and password input boxes
     * @param expectedMsg
     */
    @Then("{string} pop up should be displayed")
    public void popUpShouldBeDisplayed(String expectedMsg) {
        Assert.assertTrue(expectedMsg.equals(loginPage.usernameInputBox.getAttribute("validationMessage")) ||
                expectedMsg.equals(loginPage.passwordInputBox.getAttribute("validationMessage")));
    }

    @Then("user should see {string} link is displayed")
    public void user_should_see_link_is_displayed(String elementText) {
        Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed() && loginPage.forgotPasswordLink.getText().contains(elementText));
    }

    @When("user click Forgot Password? link")
    public void userClickForgotPasswordLink() {
        loginPage.forgotPasswordLink.click();
    }

    @Then("user should navigate to {string} page")
    public void userShouldNavigateToPage(String expectedPage) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals(expectedPage,Driver.get().getTitle());
    }

    @Then("user should see Remember me checkbox is displayed")
    public void userShouldSeeRememberMeCheckboxIsDisplayed() {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue(loginPage.rememberMeBtn.isEnabled());
    }

    @When("user click Remember Me checkbox")
    public void userClickRememberMeCheckbox() {
        BrowserUtils.clickWithJS(loginPage.rememberMeBtn);
    }

    @Then("checkbox should be selected")
    public void checkbox_should_be_selected() {
        Assert.assertTrue(loginPage.rememberMeBtn.isSelected());
    }

    @Then("user should see password as bullet sign")
    public void userShouldSeePasswordAsBulletSign() {
        Assert.assertEquals("password",loginPage.passwordInputBox.getAttribute("type"));
    }

    @When("user hit Enter key")
    public void user_hit_Enter_key() {
        loginPage.passwordInputBox.sendKeys(Keys.ENTER);
    }

    @Then("user should see {string} in the profile menu")
    public void userShouldSeeInTheProfileMenu(String expectedUsername) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderMaskDisappear();
        String actualUsername = dashboardPage.myUserName.getText();
        Assert.assertEquals(expectedUsername,actualUsername);
    }

}
