package com.fleetgru.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static WebElement waitForClickablility(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

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

    public static void openNewTab(){
        ((JavascriptExecutor)Driver.get()).executeScript("window.open('','_blank');");
        for (String window : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(window);
            if(Driver.get().getTitle().equals("Untitled")){
                return;
            }
        }

    }

    public static void openNewTab(String url){
        ((JavascriptExecutor)Driver.get()).executeScript("window.open('"+url+"','_blank');");
    }
}
