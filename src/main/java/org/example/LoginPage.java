package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Utils {


    public void verifyUserIsOnLoginPage(){

        // clicking on link by below xpath
        // clickOnElement(By.xpath("//a[@class='ico-login']"));

        // verify by below assertion that user is on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "User is NOT on Login page");
    }

    public void verifyUserShouldAbleToLoginSuccessfully() {

        //Enter Email id
        typeText(By.id("Email"), email);
        //Enter password
        typeText(By.xpath("//input[@id='Password']"), password);
        //Click on login button
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
    }
}
