package com.fleetgru.pages;

import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInputBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInputBox;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(id = "remember_me")
    public WebElement rememberMeBtn;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver(){
        usernameInputBox.sendKeys(ConfigurationReader.get("driver_username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

    public void loginAsStoreManager(){
        usernameInputBox.sendKeys(ConfigurationReader.get("storemanager_username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

    public void loginAsSalesManager(){
        usernameInputBox.sendKeys(ConfigurationReader.get("salesmanager_username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

    public void loginAsGivenUser(String userType){
        String username;
        String password = ConfigurationReader.get("password");
        switch (userType){
            case "driver":
                username = ConfigurationReader.get("driver_username");
                break;
            case "sales manager":
                username = ConfigurationReader.get("salesmanager_username");
                break;
            case "store manager":
                username = ConfigurationReader.get("storemanager_username");
                break;
            default:
                throw  new NullPointerException("Please enter a valid user type");
        }
        login(username,password);
    }

    @FindBy(css = ".alert.alert-error")
    public WebElement invalidCredentialErrorMsg;



}
