package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddEventPage {
    public AddEventPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    Actions action = new Actions(Driver.get());
    @FindBy(xpath = "//div[@class='responsive-cell responsive-cell-no-blocks']/div")
    public List<WebElement> menu;


    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement FleetTab;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a") ///index num=3
    public WebElement Fleetvehicle;

    @FindBy(xpath = "//tbody[@class='grid-body']//tr")
    public List<WebElement> AllCarRow;  ///25 row var!!!!
    @FindBy(xpath = "//a[text()='Add Event']")
    public WebElement AddEvent;
    @FindBy(xpath = "//*[@aria-describedby='ui-id-1']")
    public WebElement AddEventPopUp;
    @FindBy(xpath = "//*[@id='ui-id-2']")
    public WebElement AddEventPopUpTitle;
    @FindBy(xpath = "//*[@class='control-label wrap']//em[contains(text(),'*')]/parent::*")
    public List<WebElement> CompulsoryField;
    @FindBy(xpath = "//tr[@class='grid-row row-click-action'][1]")
    public WebElement OneCarToAddEvent;

    @FindBy(xpath = "//*[@id=\"oro_calendar_event_form_title-uid-621e90e022579-error\"]/span/span")
    public WebElement TitleAlertMessage;///Add event sayfasında boş bırakırsan titlı verdiği mesaj

    @FindBy(xpath = "//*[@id=\"flash-messages\"]/div/div")
    public WebElement AfterSaveMessage; // getAttribute(innerText: "×\nCalendar event saved")
    @FindBy(xpath = "//h5//span")
    public WebElement GeneralInformationPage;

    ///////////addevent page deki zorunlu alanlar///////////////
    @FindBy(css = "input[id^='oro_calendar_event_form_title-uid-']")
    public WebElement TitleInput;
    @FindBy(css = "input[id^='oro_calendar_event_form_organizerDisplayName-uid-']")
    public WebElement OrganizerDisplayNameInput;
    @FindBy(css = "input[id^='oro_calendar_event_form_organizerEmail-uid-']")
    public WebElement organizeremailInput;
    @FindBy(css = "input[id^='date_selector_oro_calendar_event_form_start-uid-']")
    public WebElement StartInput;
    @FindBy(css = "input[id^='date_selector_oro_calendar_event_form_end-uid-']")
    public WebElement EndInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SaveButton;
    @FindBy(xpath = "//button[@title='close']")
    public WebElement XcloseOnAddEvent;
    @FindBy(xpath = "(//*[@class='control-label wrap']//em[contains(text(),'*')]/parent::*)[1]")
    public WebElement titledeneme;
    //////new methods/////////
    @FindBy(xpath = "//span[@style='top: 181px; left: 421px;']/span")
    public WebElement TitleInputErrorMessage;
    @FindBy(xpath = "//span[@style='top: 507.8px; left: 294px;']/span")
    public WebElement StartInputerrorMessage;
    @FindBy(xpath = "//span[@style='top: 555.8px; left: 169px;']/span")
    public WebElement EndInputerrorMessage;



    ///////////methods///////////////
    public void AddEvent_Click() {

        AddEvent.click();
    }

    public void AddEvent_Page_title_verify() {
        String ActualTitle = AddEventPopUpTitle.getText();
        String ExpectedTitle = "Add Event";
        Assert.assertEquals(ExpectedTitle, ActualTitle);

        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
            wait.until(ExpectedConditions.visibilityOf(AddEventPopUp));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  /*  public void Loginpage() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(5);
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        new DashboardPage().Username.sendKeys(username);
        new DashboardPage().Password.sendKeys(password);
        new DashboardPage().LogInButton.click();
    }
    */

    public void setFleetTabVehicles() {


        action.moveToElement(FleetTab).perform();
        BrowserUtils.waitFor(2);
        action.moveToElement(Fleetvehicle).click().perform();
    }

    public void clickCarGoToAddEvent() {

        OneCarToAddEvent.click();

    }

    public void AllCars_To_AddEvent() {
        for (int i = 1; i < 26; i++) {
            action.moveToElement(AllCarRow.get(i)).click().perform();
            Assert.assertEquals("Add Event", AddEvent.getText());
        }
    }


    public void CompulsoryFieldCheck() {
        System.out.println("addEventPage.titledeneme.getText() = " + titledeneme.getText());
        System.out.println("CompulsoryField.size() = " + CompulsoryField.size());
        System.out.println(CompulsoryField);
        System.out.println("CompulsoryField.get(0).getText() = " + CompulsoryField.get(0).getText());
        List<String> ActualCompulsoryFields = new ArrayList<>();
        for (WebElement elm : CompulsoryField) {
            ActualCompulsoryFields.add(elm.getText());
        }

        System.out.println("ActualCompulsoryFields.size() = " + ActualCompulsoryFields.size());
        System.out.println("ActualCompulsoryFields = " + ActualCompulsoryFields);

        String[] array = {"Title*", "Owner*", "Organizer display name*", "Organizer email*", "Start*", "End*" };
        ArrayList<String> ExpectedCompulsoryFields = new ArrayList<>(Arrays.asList(array));
        System.out.println("ExpectedCompulsoryFields = " + ExpectedCompulsoryFields);

        Assert.assertEquals(ExpectedCompulsoryFields, ActualCompulsoryFields);
    }

    public String Title_General_Info_Page() {
        BrowserUtils.waitFor(5);
        String ActualTitle = GeneralInformationPage.getText();
        return ActualTitle;
    }


}
