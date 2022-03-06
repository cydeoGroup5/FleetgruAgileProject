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

    @FindBy(xpath = "//h3[contains(text(),'Delete Confirmation')]")
    public WebElement deleteConfirmation;

    @FindBy(xpath = "//a[contains(text(),'Yes, Delete')]")
    public WebElement yesDelete;

    @FindBy(css = ".message")
    public WebElement permissionMessage;

    @FindBy(xpath = "//div[contains(text(),'Item deleted')]")
    public WebElement itemDeleted;

    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement row1;

    @FindBy(xpath = "//span[contains(text(),'General Information')]")
    public WebElement GenInfoPageTitle;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement GenInfoDeleteButton;

    @FindBy(xpath = "//div[contains(text(),'Car deleted')]")
    public WebElement carDeleted;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div[1]/table[1]")
    public WebElement table;

    public void clickDeleteButton(){
        for (WebElement webElement : Driver.get().findElements(By.xpath("//a[@title='Delete']"))) {
            if (webElement.isEnabled()){
                BrowserUtils.clickWithJS(webElement);
            }
        }
    }

    public String getfirstrowText(){
        return row1.getText();
    }


}
