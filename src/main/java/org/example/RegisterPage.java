package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends Utils{
    public void verifyUserIsOnRegisterPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("register"), "User is NOT on register page");
    }

    public void enterRegistrationDetails(){
        waitForClickable(By.id("register-button"), 10);   // wait for button get clickable
        //Enter registration details
        typeText(By.name("FirstName"), "FirstNameTest");   // Enter First name
        typeText(By.name("LastName"),"LastNameTest");      // Enter Last Name
        selectByText(By.name("DateOfBirthDay"), "21");      //Enter date
        selectByText(By.name("DateOfBirthMonth"), "May");    // Enter Month
        selectByText(By.name("DateOfBirthYear"), "1987");      //Enter year
        typeText(By.name("Email"),"test+"+timeStamp()+"@test.com");  //Enter email by timestamp
        typeText(By.name("Password"),"sharma1234");                  //Enter password
        typeText(By.name("ConfirmPassword"),"sharma1234");            //Confirm password
        clickOnElement(By.id("register-button"));                       //click on register button by method
    }
}
