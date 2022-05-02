package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) throws InterruptedException {
         // TC #1: Yahoo Title Verification
        WebDriverManager.chromedriver().setup();


        //1. Open Chrome Browser
        WebDriver driver = new ChromeDriver();

        // maximize the page
        driver.manage().window().maximize();
        //go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");

        WebElement agreeButton = driver.findElement(By.cssSelector("button[type=submit].btn.primary"));// css accept cookies
        agreeButton.click();
        Thread.sleep(3000);








        //3. Verify title:

        // Expected: Yahoo | Mail. Weather, Search, Politics, News, Finance, Sports & Videos

        String expectedTitle = "Yahoo | Mail. Weather, Search, Politics, News, Finance, Sports & Videos";

        // actual title comes from the browser
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){

            System.out.println("Title is as expected.Verification PASSED!");
        }else{
            System.out.println("Title is NOT as expected.Verification Failed");
        }




    }


}


/*
TC #1: Yahoo Title Verification
1.Open Chrome browser
2.Go to https://www.yahoo.com
3.Verify title:
Expected: Yahoo
 */
