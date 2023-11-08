package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends Utils{
    public void verifyUserIsOnRegisterPage()
    {       //verify that user is on register page by this assertion
         Assert.assertTrue(driver.getCurrentUrl().contains("register"), "User is NOT on register page");
    }
   //Enter registration detail
    public void enterRegistrationDetails(){
        // wait for button get clickable
        waitForClickable(By.id("register-button"), 10);
        //Enter First Name
        typeText(By.name("FirstName"), "FirstNameTest");
        // Enter Last Name
        typeText(By.name("LastName"),"LastNameTest");
        //Enter date
        selectByText(By.name("DateOfBirthDay"), "21");
        // Enter Month
        selectByText(By.name("DateOfBirthMonth"), "May");
        //Enter year
        selectByText(By.name("DateOfBirthYear"), "1987");
        //Print email
        System.out.println(email);
        //Enter email
        typeText(By.name("Email"),email);
        //Enter password
        typeText(By.name("Password"),password);
        //Confirm password
        typeText(By.name("ConfirmPassword"),password);
        //click on register button by method
        clickOnElement(By.id("register-button"));
    }
}
