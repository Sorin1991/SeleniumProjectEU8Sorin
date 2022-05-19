package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices_T2_and_T3 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //TC #1: Information alert practice
        //1. Open browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to website: https://practice.cydeo.com/javascript_alerts
       driver.get("https://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void alert_test1() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        informationAlertButton.click();


        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();
        Thread.sleep(2000);

        //5. Verify “You successfully clicked an alert” text is displayed.

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));


        // Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result test is not as expected!!!");

    }

    @Test
    public void alert_test2() throws InterruptedException {
        //3. Click to “Click for JS Confirm” button
        WebElement clickJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickJSConfirm.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);

        //5. Verify “You clicked: Ok” text is displayed
        WebElement resultTextOfJSConfirm = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultTextOfJSConfirm.isDisplayed(),"Result text is not Displayed");

        String actualResultOfJSConfirm = resultTextOfJSConfirm.getText();
        String expectedResultOfJSConfirm = "You clicked: Ok";

        Assert.assertEquals(actualResultOfJSConfirm,expectedResultOfJSConfirm,"Actual result test is not as expected!!!");



    }

    @Test
    public void alert_test3() throws InterruptedException {
        //3. Click to “Click for JS Prompt” button
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();

        Thread.sleep(2000);

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed

        WebElement result = driver.findElement(By.xpath("//p[@style='color:green']"));

        Assert.assertTrue(result.isDisplayed(),"Result text is NOT displayed");

        String actualResult = result.getText();
        String expectedResult = "You entered: hello";

        Assert.assertEquals(actualResult,expectedResult,"Actual result test is not as EXPECTED !!!");




    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }





}
