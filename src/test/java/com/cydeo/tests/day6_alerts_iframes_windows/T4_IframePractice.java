package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //TC #4: Iframe practice
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make setups

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");


    }

    // @Ignore if you want to skip
    @Test
    public void iframe_test() {

        //We need to switch driver's focus to iframe
        // driver.switchTo().frame("mce_0_ifr");

        //option #2 - passing index number of iframe

       // driver.switchTo().frame(0);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        //locate the p tag
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());


        //4. Assert: “Your content goes here.” Text is displayed.


        //To be able to verify the header, wem ust switch back to "main HTML"
        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        //assertion of header text is displayed or not
        Assert.assertTrue(headerText.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}
