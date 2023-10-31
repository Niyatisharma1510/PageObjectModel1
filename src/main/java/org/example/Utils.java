package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage {

    static String email = "jacksmith" +timeStamp() +"@gmail.com";
    static String password = "sharma123";
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public static String timeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }
    public static void selectByText(By by, String text){
        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByVisibleText(text);
    }

   public static void  selectByIndexOfTheElement(By by, int index)
   {
       Select selectMonth = new Select(driver.findElement(by));
       selectMonth.selectByIndex(index);
   }

    public static void waitForClickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

   public static void waitForElementToBeVisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
         wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
