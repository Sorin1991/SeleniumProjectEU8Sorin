package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTsk3_Back_and_ForthNavigation {

    public static void main(String[] args) throws InterruptedException {

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");
        WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
        acceptCookies.click();


        //3- Click to Gmail from top right.
        WebElement clickGmail = driver.findElement(By.className("gb_d"));
        clickGmail.sendKeys("Gmail"+ Keys.ENTER);

        //4- Verify title contains:
        //Expected: Gmail
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Verification of title PASSED !!!");

        }else {
            System.out.println("Verification of title FAILED !!!");
        }

        Thread.sleep(3000);


        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google

        String actualTitleForGoogle = driver.getTitle();
        String expectedTitleForGoogle = "Google";

        if(actualTitleForGoogle.equals(expectedTitleForGoogle)){
            System.out.println("Verification of title PASSED !!!");

        }else {
            System.out.println("Verification of title FAILED !!!");
        }

        Thread.sleep(3000);

        driver.quit();



    }
}
