package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TestSuite extends BaseTest {
    //Homepage object Created
    HomePage homePage = new HomePage();
    //RegisterPage object created
    RegisterPage registerPage = new RegisterPage();
    //RegisterResultPage object created
    RegisterResultPage registerResultPage = new RegisterResultPage();
    //LoginPage object created
    LoginPage loginPage = new LoginPage();
    //ReferAFriend class object created
    ReferAFriend referAFriend = new ReferAFriend();

    //Object for checkout class
    Checkout checkout =new Checkout();
    //checkout confirm page object created
    CheckoutConfirm checkoutConfirm= new CheckoutConfirm();

    @Test(priority = 1)
    public void verifyUserShouldAbleToRegisterSuccessfully() {

        //verify user is on register page
        registerPage.verifyUserIsOnRegisterPage();

        //enter registration details
        registerPage.enterRegistrationDetails();

        //verify user registered successfully
        registerResultPage.verifyUserRegisteredSuccessfully();
    }

    @Test(priority = 2)
    public void verifyUserShouldAbleToLogin() {
        //Click pn registration link
        homePage.clickOnRegisterButton();

        //verify user is on registration page
        registerPage.verifyUserIsOnRegisterPage();

        // enter registration detail
        registerPage.enterRegistrationDetails();

        // click on login button
        homePage.clickOnLoginButton();

        //verify user is on login page
        loginPage.verifyUserIsOnLoginPage();

        //Enter login Details and verify
        loginPage.verifyUserShouldAbleToLoginSuccessfully();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void verifyRegisteredUserShouldABleToReferAProductToFriendSuccessfully() {

        //click on register button
        homePage.clickOnRegisterButton();
        //verify user is on register page
        registerPage.verifyUserIsOnRegisterPage();
        //enter registration details
        registerPage.enterRegistrationDetails();
        //verify user registered successfully
        registerResultPage.verifyUserRegisteredSuccessfully();
        //click on login button
        homePage.clickOnLoginButton();
        //verify user is on login page
        loginPage.verifyUserIsOnLoginPage();
        // verify user able to login successfully
        loginPage.verifyUserShouldAbleToLoginSuccessfully();
        //  verify user able to refer a product to a friend
        referAFriend.verifyUserShouldReferaProducttoFriend();
    }

    @Test
    public void acceptSearchAlert() throws InterruptedException {

        //Click on the button to activate the alert
        homePage.clickOnSearchButton();

        //wait till pop up comes on screen
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //accept that alert from the pop up
        driver.switchTo().alert().accept();
    }

    @Test
    public void getTextFromPopUp() throws InterruptedException {

        //Click on vote button
        homePage.clickOnVoteButton();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // get text from the pop up
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);

    }

    @Test
    public void getListOfProductsName()
    {   //Calling method from homepage to get all products number
        homePage.getAllProductTitles();
    }
    @Test
    public void selectByCurrency()
    {
        //calling method from homepage to change currency and verify that currency on homepage
        homePage.userAbleToChangeTheCurrency();
    }
    @Test
    public void giveCommentAndVerifyOnNewsSection()
    {
        homePage.userAbleToAddCommentonNewReleaseOfNewsSection();
    }
    @Test
    public void SearchForNikeProductandVerify()
    {
        homePage.userAbletoSearchForNikeProductFromSearchButton();
    }
    @Test
    public void addToCartProductandVerify()
    {   //click on register button
        homePage.clickOnRegisterButton();
        //click on register button
        homePage.clickOnRegisterButton();
        //verify user is on register page
        registerPage.verifyUserIsOnRegisterPage();
        //enter registration details
        registerPage.enterRegistrationDetails();
        //verify user registered successfully
        registerResultPage.verifyUserRegisteredSuccessfully();
        //click on login button
        homePage.clickOnLoginButton();
        //verify user is on login page
        loginPage.verifyUserIsOnLoginPage();
        // verify user able to login successfully
        loginPage.verifyUserShouldAbleToLoginSuccessfully();
        //search for macbook
        homePage.searchForMacbookAndAddToCart();
        //user can checkout through this method
        checkout.userCanCheckout();
        //user can confirm that he has done successfully checkout
        checkoutConfirm.verifyUserCheckoutSuccessfully();

    }

}
