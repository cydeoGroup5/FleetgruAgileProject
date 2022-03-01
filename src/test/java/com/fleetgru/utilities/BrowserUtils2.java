package com.fleetgru.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils2 {

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param by
     * @param attempts
     */
    public static void clickWithWait(By by, int attempts){
        int counter = 0;

        while (counter < attempts){
            try {
                clickWithJS(Driver.get().findElement(by));
                break;
            }catch (WebDriverException e){
                e.printStackTrace();
                ++counter;
                waitFor(1);
            }
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor)Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     *  checks that an element is present on the DOM of a page. This does not
     *    * necessarily mean that the element is visible.
     * @param by
     * @param time
     */
    public static void waitForPresenceOfElement(By by, long time){
        new WebDriverWait(Driver.get(),time).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForVisibility(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)Driver.get()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void clickWithTimeOut(WebElement element, int timeout){
        for (int i = 0; i < timeout; i++) {
             try {
                 element.click();
                 return;
             }catch (WebDriverException e){
                 waitFor(1);
             }
        }
    }

    /**
     * This method open a new blank tab and switch to this new tab
     */
    public static void openNewTab(){
        ((JavascriptExecutor)Driver.get()).executeScript("window.open('','_blank');");
        for (String window : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(window);
            if(Driver.get().getTitle().equals("Untitled")){
                return;
            }
        }

    }

    /**
     * This method open a new tab and goes for given url
     * But it doesn't switch to new tab. Driver going to stay at current page
     * @param url
     */
    public static void openNewTab(String url){
        ((JavascriptExecutor)Driver.get()).executeScript("window.open('"+url+"','_blank');");
    }
}
