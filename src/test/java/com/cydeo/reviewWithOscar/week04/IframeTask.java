package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTask {
    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @Test
    public void testIframe(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
        // 3. Get the text “Double-click me to change my text color.” and verify the text
        WebElement text = driver.findElement(By.xpath("//p[.='Double-click me to change my text color.']"));
        String expectedText = "Double-click me to change my text color.";
        String actualText = text.getText();

        Assert.assertEquals(actualText,expectedText,"The text is not matching");

        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);


    }


}
//1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//2. Switch to iframe.
//3. Get the text “Double-click me to change my text color.” and verify the text
