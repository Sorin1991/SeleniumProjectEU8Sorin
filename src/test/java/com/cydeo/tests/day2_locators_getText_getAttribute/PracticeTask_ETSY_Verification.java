package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTask_ETSY_Verification {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");



        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button"));
        acceptCookies.click();





        //3. Search for “wooden spoon”
        WebElement searchWoodenSpoon = driver.findElement(By.name("search_query"));
        searchWoodenSpoon.sendKeys("wooden spoon" + Keys.ENTER);

        WebElement acceptCookies2 = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[2]/div/div[2]/div[2]/button"));
        acceptCookies2.click();

        //4. Verify title:
        //Expected: “Wooden spoon | Etsy”

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy UK";

        System.out.println(actualTitle);

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }

        Thread.sleep(3000);

        driver.quit();




    }
}
