package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_XpathPractice {
    public static void main(String[] args) {

        //XPATH Practice
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #6: XPATH LOCATOR practice
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("https://practice.cydeo.com/multiple_buttons");


        //3. Click on Button 1
        WebElement clickButton1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        clickButton1.click();

        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”

        WebElement actualDisplayedResult1 = driver.findElement(By.xpath("//p[@id='result']"));

        String actualDisplayedResult = actualDisplayedResult1.getText();
        String expectedResult = "Clicked on button one!";


        if(actualDisplayedResult.equals(expectedResult)){
            System.out.println("Verification of displayed text matching with expected result");
        }else {
            System.out.println("Verification of displayed text is not  matching with expected result");
        }




        //USE XPATH LOCATOR FOR ALL WebELEMENT LOCATORS



    }
}
