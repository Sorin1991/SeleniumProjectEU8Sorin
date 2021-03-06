package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        //TC#3: Google search
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://google.com
        driver.get("https://www.google.com");

        WebElement agreeButton=driver.findElement(By.id("L2AGLb"));
        agreeButton.click();
        Thread.sleep(2000);


        //3- Write “apple” in search box
        //4- Click google search button
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        //5- Verify title:
        //Expected: Title should start with “apple” word

        String expectedInTitle = "apple";
        String actualInTitle = driver.getTitle();

        if(actualInTitle.startsWith(expectedInTitle)){
            System.out.println("Title Verification PASSED !!!");
        }else{
            System.out.println("Title verification FAILED");
        }

        Thread.sleep(4000);

        driver.quit();




    }

}
