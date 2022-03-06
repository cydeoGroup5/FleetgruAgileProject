package com.fleetgru.pages;

import com.fleetgru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage_omer extends BasePage{

    public WebElement getCreateCarBtn(){
        WebElement createCarBtn = null;
        try {
            createCarBtn = Driver.get().findElement(By.xpath("//div/a[contains(text(),'Create Car')]"));
        }catch (NoSuchElementException e){}
        return createCarBtn;
    }



}
