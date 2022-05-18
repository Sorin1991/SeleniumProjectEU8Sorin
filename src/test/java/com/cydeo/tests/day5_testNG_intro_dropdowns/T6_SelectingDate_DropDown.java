package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_SelectingDate_DropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void setUpTest(){

        //3. Select “December 1st, 1923” and verify it is selected.
        //Select year using : visible text
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1923");
        String expectedYear = "1923";
        String actualYear = year.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedYear,actualYear);


        //Select month using : value attribute
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        String expectedValue = "December";
        String actualValue = month.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedValue,actualValue);

        //Select day using : index number
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
        String expectedDay = "1";
        String actualDay = day.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedDay,actualDay);

    }



}
