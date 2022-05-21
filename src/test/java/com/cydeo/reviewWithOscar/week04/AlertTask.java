package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class AlertTask {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test
    public void testAlertTask() throws InterruptedException {

        //Navigate to laptop -> Sony vaio i5
        WebElement sonyI5 = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        sonyI5.click();

        // click on "Add to cart"
        WebElement addToCart = driver.findElement(By.xpath("//a[.='Add to cart']"));
        addToCart.click();

        Thread.sleep(3000);

        //Accept pop up confirmation.
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }




}

 /*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
     */
