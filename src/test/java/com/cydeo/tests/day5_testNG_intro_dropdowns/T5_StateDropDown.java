package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_StateDropDown {
    WebDriver driver;

    @BeforeMethod
    public  void setUpMethod(){

        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void testDropDown() throws InterruptedException {



        //3. Select Illinois
        Select stateOption = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        stateOption.selectByVisibleText("Illinois");
        stateOption.selectByValue("IL");
        stateOption.selectByIndex(14);



        //4. Select Virginia
        stateOption.selectByVisibleText("Virginia");
        stateOption.selectByValue("VA");
        stateOption.selectByIndex(47);



        //5. Select California
        stateOption.selectByVisibleText("California");
        stateOption.selectByValue("CA");
        stateOption.selectByIndex(5);



        //6. Verify final selected option is California.


        String expectedFinalSelectedOption = "California";
        String actualFinalSelectedOption = stateOption.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedFinalSelectedOption,actualFinalSelectedOption);


        //Use all Select options. (visible text, value, index)
    }

    @AfterMethod
    public void closeMethod(){
        driver.close();
    }






}
