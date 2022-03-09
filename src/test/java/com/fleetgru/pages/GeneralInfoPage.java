package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class GeneralInfoPage extends BasePage{

    @FindBy (xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div[1]/div/a")
    public WebElement driverAddEventBtn;

    @FindBy (xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div[1]/div[1]")
    public WebElement editBtn;

    @FindBy (xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]")
    public WebElement deleteBtn;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div[1]/div[3]/a")
    public WebElement managerAddEventBtn;

    @FindBy(xpath = "//tbody/tr[2]/td[19]")
    public WebElement driverThreeDot;

    @FindBy(xpath = "//tbody/tr[2]/td[20]")
    public WebElement managerThreeDot;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5/span")
    public WebElement genInfoPageTitle;


    public void clickeyeIcon() {
            BrowserUtils.waitFor(2);
        for (WebElement webElement : Driver.get().findElements(By.xpath("//a[@title='View']"))) {
            if (webElement.isEnabled()) {
                BrowserUtils.clickWithJS(webElement);
            }
        }

    }

        public void setMenu(){

            List<String> array = new ArrayList<>();

            for (int i = 1; i < 23; i++) {

             String text = Driver.get().findElement(By.xpath("(//*[@id='container']/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div)[" + i + "]")).getText();
             array.add(text);
            }
            System.out.println(array);
        }
        public void setMenu1(){
            List<String> array1 = new ArrayList<>();

            for (int i = 1; i < 21; i++) {
                String text1 = Driver.get().findElement(By.xpath("(//*[@id='grid-custom-entity-grid-1466424087']/div[2]/div[2]/div[2]/div/table/thead[1]/tr/th)[" + i + "]")).getText();
                array1.add(text1);
            }
            System.out.println(array1);
        }

    }

