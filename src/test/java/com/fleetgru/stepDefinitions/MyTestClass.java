package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.CreateCarPage;
import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.VehiclesPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        new VehiclesPage().waitUntilLoaderMaskDisappear();

        Driver.get().findElement(By.partialLinkText("Create Car")).click();

        CreateCarPage page = new CreateCarPage();
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
