package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    @Test
    public void dropdown_task() throws InterruptedException {

        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");


        //We located the dropdown and it is ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");


        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.

        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText,expectedOptionText);





    }



}
