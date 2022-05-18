package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_SelectingValueFromNon_selectDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //TC #7: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void setUpTest(){
        //3. Click to non-select dropdown
        WebElement clickNon_selectDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        clickNon_selectDropdown.click();


        //4. Select Facebook from dropdown
        WebElement selectFacebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        selectFacebook.click();



        //5. Verify title is “Facebook - Log In or Sign Up”

        String expectedTitle = "Facebook - log in or sign up" ;
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);






    }


}
