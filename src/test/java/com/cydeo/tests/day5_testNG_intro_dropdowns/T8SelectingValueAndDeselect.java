package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8SelectingValueAndDeselect {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //TC #8: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void testingCaseT8(){

        //3. Select all the options from multiple select dropdown.
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        multipleSelectDropdown.getAllSelectedOptions();



        //4. Print out all selected values.
        List<WebElement> selectedOptions = multipleSelectDropdown.getAllSelectedOptions();

        for(WebElement eachOption : selectedOptions){
            System.out.println(eachOption.getText());
        }

        multipleSelectDropdown.deselectAll();

        //5. Deselect all values.


    }


}
