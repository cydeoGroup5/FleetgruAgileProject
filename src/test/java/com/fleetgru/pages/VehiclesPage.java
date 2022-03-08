package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.CSS;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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

    @FindBy(css = ".fa-cog.hide-text")
    public WebElement gearIcon;

    @FindBy(css = ".column-manager-title")
    public WebElement gridSettingsText;

    @FindBy(xpath = "//table//tbody/tr//td[@class='title-cell']")
    public List<WebElement> gridSettingsList;

    @FindBy(css = ".column-manager-search")
    public WebElement quickSearch;

    @FindBy(css = ".grid-header")
    public WebElement tableHeader;

    @FindBy(css = ".fa-arrows-v.handle.ui-sortable-handle")
    public List<WebElement> sort;

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



    public void typeAnyOptionForQuickSearch(String columnName){
            WebDriverWait t = new WebDriverWait(Driver.get(), 15);
            t.until(ExpectedConditions.visibilityOf(quickSearch));

            Actions actions=new Actions(Driver.get());

            BrowserUtils.waitFor(2);
            actions.sendKeys(columnName).perform();
        }

        public boolean isQuickSearchWorkingProperly(String columnName){
            boolean verify=false;
            for (WebElement webElement : gridSettingsList) {
                if(webElement.getText().equals(columnName)&& webElement.isDisplayed()){
                    verify=true;
                }
            }
            return verify;
        }
       




    public void clickOnColumnNames(String columnName){
        for (WebElement webElement : gridSettingsList) {
            if(webElement.getText().equals(columnName)){
                BrowserUtils.waitFor(2);
                webElement.click();
                webElement.click();
            }
        }
    }

    public boolean isColumnNameDisplayed(String arg0){
        if(tableHeader.getText().contains(arg0.toUpperCase())){
            return true;
        }else{
            return false;
        }
    }

    public void dragAndDropColumns(){
        Actions actions=new Actions(Driver.get());
        BrowserUtils.waitFor(2);
        actions.clickAndHold(sort.get(5)).perform();
        BrowserUtils.waitFor(3);
        actions.dragAndDropBy(sort.get(5),0,50).perform();
    }





}
