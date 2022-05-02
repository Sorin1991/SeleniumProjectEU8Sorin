package com.cydeo.tests.day2_locators_getText_getAttribute;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {
    public static void main(String[] args) {

       // TC #1: Cydeo practice tool verifications
       // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



       // 2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");


      //  3. Verify URL contains
        // Expected: cydeo
        String actualURL = driver.getCurrentUrl();

        String expectedURL = "cydeo";

        if(actualURL.contains(expectedURL)){
            System.out.println("URL Verification PASSED !!!");
        }else{
            System.out.println("URL verification FAILED !!!");
        }



        // 4. Verify title:
        // Expected: Practice
       String actualTitle =  driver.getTitle();
        String expectedTitle = "Practice";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED !!!");
        }else {
            System.out.println("Title verification FAILED !!!");
        }


        driver.close();







    }


}
