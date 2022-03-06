package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.CreateCarPage_omer;
import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.VehiclesPage_omer;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyTestClass {

    @Test
    public void test1(){
        LoginStepDefs login = new LoginStepDefs();
        Driver.get().manage().window().maximize();
        login.user_on_the_login_page();

        login.user_login_as("store manager");
        new DashboardPage().waitUntilLoaderMaskDisappear();
        BrowserUtils.waitFor(3);
        new DashboardPage().navigateTo("Fleet","Vehicles");
        BrowserUtils.waitFor(4);
        new VehiclesPage_omer().waitUntilLoaderMaskDisappear();

        Driver.get().findElement(By.partialLinkText("Create Car")).click();

        CreateCarPage_omer page = new CreateCarPage_omer();
        page.waitUntilLoaderMaskDisappear();
        BrowserUtils.waitFor(5);

        WebElement date = Driver.get().findElement(By.xpath("(//div[@class='controls']//input)[15]"));
        BrowserUtils.waitFor(1);
        date.sendKeys("Mar 1, 2020");

        BrowserUtils.waitFor(5);

    }

    public static void main(String[] args) {

        String licencePlate = "290 JCC";

        Faker faker = new Faker();
        System.out.println(faker.funnyName().name());
        System.out.println(faker.lordOfTheRings().character());

    }
}
