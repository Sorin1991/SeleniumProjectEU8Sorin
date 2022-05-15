package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_cssSelectorPractice {
    public static void main(String[] args) {


        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/forgot_password
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/forgot_password");


        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //b. “Forgot password” header
        //c. “E-mail” text
        //d. E-mail input box
        //e. “Retrieve password” button
        //f. “Powered by Cydeo text
        WebElement homeLink = driver.findElement(By.cssSelector("body > nav > ul > li > a"));
        WebElement forgotPasswordHeader = driver.findElement(By.cssSelector("#content > div > h2"));
        WebElement emailText = driver.findElement(By.cssSelector("#forgot_password > div > div > label"));
        WebElement inputEmailBox = driver.findElement(By.cssSelector("#forgot_password > div > div > input[type=text]"));
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("#form_submit > i"));
        WebElement poweredByCydeoText = driver.findElement(By.cssSelector("#page-footer > div > div > a"));


        //4. Verify all web elements are displayed.
        System.out.println("homeLink.isDisplayed(), expecting true = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() expecting true = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailText.isDisplayed(), expecting true = " + emailText.isDisplayed());
        System.out.println("inputEmailBox.isDisplayed() expecting true = " + inputEmailBox.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed(), expecting true = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() expecting true = " + poweredByCydeoText.isDisplayed());

        driver.quit();

        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible




    }

}
