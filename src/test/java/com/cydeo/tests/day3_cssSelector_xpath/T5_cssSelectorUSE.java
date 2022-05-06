package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_cssSelectorUSE {
    public static void main(String[] args) throws InterruptedException {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement enterIncorrectUsername = driver.findElement(By.cssSelector("input[class='login-inp']"));

        enterIncorrectUsername.sendKeys("ILoveSelenium");



        //4- Click to `Reset password` button
        WebElement clickResetPassword = driver.findElement(By.cssSelector("button[class='login-btn']"));
        clickResetPassword.click();

        //5- Verify “error” label is as expected
        WebElement labelError = driver.findElement(By.cssSelector("div[class='errortext']"));
        String actualLabelError = labelError.getText();

        //Expected: Login or E-mail not found
        String expectedLabelError = "Login or E-mail not found";

        if(actualLabelError.equals(expectedLabelError)){
            System.out.println("Label check PASSED !!!");
        }else {
            System.out.println("Label check FAILED");
        }

        Thread.sleep(3000);

        driver.close();


        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from




    }
}
