package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTask_Cydeo_Class_Locator {
    public static void main(String[] args) throws InterruptedException {
     //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        Thread.sleep(3000);


        //3- Click to “Home” link
        WebElement home = driver.findElement(By.className("nav-link"));
        home.click();

        //4- Verify title is as expected:
        //Expected: Practice
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Verification of the title PASSED !!!");
        }else{
            System.out.println("Verification of title FAILED !!!");
        }

        driver.quit();



        //PS: Locate “Home” link using “className” locator


    }
}
