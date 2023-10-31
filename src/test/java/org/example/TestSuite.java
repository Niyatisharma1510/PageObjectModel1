package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    HomePage homePage = new HomePage();

    RegisterPage registerPage = new RegisterPage();

    RegisterResultPage registerResultPage = new RegisterResultPage();

    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldAbleToRegisterSuccessfully() {

        homePage.clickOnRegisterButton();  //click on register button

        registerPage.verifyUserIsOnRegisterPage();     //verify user is on register page

        registerPage.enterRegistrationDetails();  //enter registration details

        registerResultPage.verifyUserRegisteredSuccessfully();  //verify user registered successfully
    }

    @Test
    public void verifyRegisteredUserShouldABleToReferAProductToFriendSuccessfully() {


        homePage.clickOnRegisterButton();   //click on register button

        registerPage.verifyUserIsOnRegisterPage();  //verify user is on register page

        registerPage.enterRegistrationDetails();   //enter registration details

        registerResultPage.verifyUserRegisteredSuccessfully();  //verify user registered successfully


    }
     @Test
     public void verifyUserShouldAbleToLogin()
     {

      homePage.clickOnLoginButton();   // user able to click on login button

      loginPage.verifyUserIsOnLoginPage(); //verify user is on login page

      loginPage.enterLoginDetails();   //Enter login Details
        }
}
