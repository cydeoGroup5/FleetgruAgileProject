package com.fleetgru.pages;

import com.fleetgru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage{

    @FindBy(xpath = "//div/a[contains(text(),'Create Car')]")
    public WebElement createCarBtn;

 

}
