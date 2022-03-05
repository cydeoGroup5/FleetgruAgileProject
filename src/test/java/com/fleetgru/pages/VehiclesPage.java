package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage{

    @FindBy(xpath = "//tbody/tr[2]/td[21]")
    public WebElement dots;

    @FindBy(xpath = "//tbody/tr[2]/td[20]")
    public WebElement dotsForDriver;

    @FindBy(xpath = "//a[@title='Delete']")
    public WebElement deleteButton;
    //onur
    @FindBy(xpath = "//body/div[@id='page']//div[3]/div[3]/div[2]//div[1]/div[1]/div[3]/div[1]/div[1]/a[1]")
    public WebElement filterIcon;
    //onur
    @FindBy(linkText = "Manage filters")
    public  WebElement manageFilters;
    //onur
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement searchBoxInput;
    //onur
    @FindBy(xpath= "//label[@title=\"Tags\"]")
    public WebElement option1;
    //onur
    @FindBy(xpath = "(//*[@class='fa-refresh'])[2]")
    public WebElement refreshFilterButton;

    public void clickDeleteButton(){
        for (WebElement webElement : Driver.get().findElements(By.xpath("//a[@title='Delete']"))) {
            if (webElement.isEnabled()){
                BrowserUtils.clickWithJS(webElement);
            }
        }
    }


}
