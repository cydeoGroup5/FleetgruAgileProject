package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateCarPage extends BasePage{

    @FindBy(xpath = "//div[@class='control-label wrap']/label")
    public List<WebElement> dataTitles;

    @FindBy(xpath = "//div[contains(@id,'type_Tags')]/div/label")
    public List<WebElement> tagsCheckboxesText;

    @FindBy(xpath = "//div[@id='custom_entity_type_Tags-uid-621fd14c7a98e']/div/input")
    public List<WebElement> tagsCheckboxes;

    @FindBy(xpath = "//select[contains(@id,'type_Transmission')]")
    public WebElement transmissionDropdown;

    @FindBy(xpath = "//select[contains(@id,'type_FuelType')]")
    public WebElement fuelTypeDropdown;

    @FindBy(xpath = "//input[contains(@id,'type_Logo')]")
    public WebElement uploadInputBox;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    public WebElement openSaveDropdownBtn;

    @FindBy(className = "message")
    public WebElement successMsgElement;

    public List<String> getCheckboxesNames(){
        List<String> checkboxNames = new ArrayList<>();
        for (WebElement element : Driver.get().findElements(By.xpath("//div[contains(@id,'type_Tags')]/div/label"))) {
            checkboxNames.add(element.getText().trim());
        }
        return checkboxNames;
    }


    public WebElement getInputBox(String inputBoxName){
        inputBoxName = inputBoxName.replace(" ","");
        return Driver.get().findElement(By.xpath("//input[contains(@id,'type_"+inputBoxName+"')]"));
    }

    public List<String> getTransmissionOptions(){
        List<WebElement> transmissionOptions = new Select(transmissionDropdown).getOptions();
        List<String> transmissionOptionsTexts = new ArrayList<>();
        for (int i = 1; i < transmissionOptions.size(); i++) {
            transmissionOptionsTexts.add(transmissionOptions.get(i).getText().trim());
        }
        return transmissionOptionsTexts;
    }

    public void selectTransmission(String transmission ){
        Select select = new Select(transmissionDropdown);
        select.selectByVisibleText(transmission);
    }

    public List<String> getFuelTypeOptions(){
        List<WebElement> fuelTypeOptions = new Select(fuelTypeDropdown).getOptions();
        List<String> fuelTypeOptionsTexts = new ArrayList<>();
        for (int i = 1; i < fuelTypeOptions.size(); i++) {
            fuelTypeOptionsTexts.add(fuelTypeOptions.get(i).getText().trim());
        }
        return fuelTypeOptionsTexts;
    }

    public void selectFuelType(String fuelType){
        Select select = new Select(fuelTypeDropdown);
        select.selectByVisibleText(fuelType);
    }

    public void selectTag(String tagName){
        Driver.get().findElement(By.xpath("//div[contains(@id,'type_Tags')]//label[text()='"+tagName+"']/../input")).click();
    }

    public void uploadFile(String logo){
        String path = System.getProperty("user.dir")+"/src/test/resources/"+logo;
        uploadInputBox.sendKeys(path);
    }

    public List<String> getSaveOptions(){
        BrowserUtils.waitForClickablility(openSaveDropdownBtn,5);
        openSaveDropdownBtn.click();
        return BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//li/button[@type='submit']")));
    }

    public void selectSaveOption(String option){
        BrowserUtils.waitForClickablility(openSaveDropdownBtn,5);
        openSaveDropdownBtn.click();
        Driver.get().findElement(By.xpath("//li/button[@type='submit'][normalize-space()='"+option+"']")).click();
    }

    public void selectDate(String dateTitle,String data){
        WebElement dateElement = Driver.get().findElement(By.xpath("(//input[contains(@id,'type_" + dateTitle + "')])[2]"));
        dateElement.sendKeys(data);
        String day = data.substring(data.indexOf(",") - 1, data.indexOf(","));
        Driver.get().findElement(By.linkText(day)).click();
    }

    public List<String> getDataTitles(){
        List<String> dataTitlesText = new ArrayList<>();
        for (int i = 0; i < dataTitles.size()-2; i++) {
           dataTitlesText.add(dataTitles.get(i).getText().trim());
        }
        return dataTitlesText;
    }

    public void fillForm(Map<String,Object> formData){
        for (String dataTitle : getDataTitles()) {
            String titleForLocator = dataTitle;
            if(titleForLocator.contains("(")){
                titleForLocator = titleForLocator.substring(0,titleForLocator.indexOf("("));
                titleForLocator = titleForLocator.replace(" ","");
            }
            if (titleForLocator.contains(" ")){
                titleForLocator = dataTitle.replace(" ","");
            }

            if(dataTitle.equals("Tags")){
                selectTag((String) formData.get(dataTitle));
            }else if(dataTitle.equals("Transmission")){
                selectTransmission((String) formData.get(dataTitle));
            }else if(dataTitle.equals("Fuel Type")){
                selectFuelType((String) formData.get(dataTitle));
            }else if(dataTitle.contains("Date")){
                selectDate(titleForLocator, (String) formData.get(dataTitle));
            }else if(dataTitle.contains("Logo")){
                uploadFile((String) formData.get(dataTitle));
            }else {
                getInputBox(titleForLocator).sendKeys((CharSequence) formData.get(dataTitle));
            }
        }
    }

    public String getMsg(){
        return successMsgElement.getText();
    }

}
