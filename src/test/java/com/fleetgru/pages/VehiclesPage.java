package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    public WebElement viewPerPage;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement viewPerPageOptions1;

    @FindBy(xpath = "//a[contains(text(),'25')]")
    public WebElement viewPerPageOptions2;

    @FindBy(xpath = "//a[contains(text(),'50')]")
    public WebElement viewPerPageOptions3;

    @FindBy(xpath = "//a[contains(text(),'100')]")
    public WebElement viewPerPageOptions4;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[3]/i[1]")
    public WebElement refreshbtn;

    public List<String> getViewOptions(){
        List<String> groupView = new ArrayList<>();

        for (WebElement element : Driver.get().findElements(By.cssSelector(".dropdown-item"))) {
            groupView.add(element.getText().trim());
        }

        return groupView;

    }

    public boolean getColumnOrder(String order,String column){
        List<String> drivers = new ArrayList<>();
        List<String> sortedDrivers = new ArrayList<>();

        for (int i = 10; i <= 15; i++) {
            drivers.add(Driver.get().findElement(By.xpath("(//tbody/tr/td[contains(@data-column-label,'"+column+"')])["+i+"]")).getText());
            sortedDrivers.add(Driver.get().findElement(By.xpath("(//tbody/tr/td[contains(@data-column-label,'"+column+"')])["+i+"]")).getText());
        }

        Collections.sort(sortedDrivers);

        switch (order){
            case"ascending":
                break;
            case"descending":
                Collections.reverse(sortedDrivers);
                break;
        }

        if(sortedDrivers.equals(drivers)){
          return true;
      }
      return false;
    }


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

    //


}
