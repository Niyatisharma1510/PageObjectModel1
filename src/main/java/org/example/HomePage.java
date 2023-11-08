package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends Utils {

    String expectedCommentMessage = "News comment is successfully added.";

    public void clickOnRegisterButton() {
        clickOnElement(By.linkText("Register"));    //Click on Register link on homepage
    }
    public void clickOnLoginButton(){
        clickOnElement(By.xpath("//a[@class='ico-login']"));
    }
    public void getAllProductTitles()
    {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-item']"));
        System.out.println(products.size());
        List<String> productsNameList = new ArrayList<>();
        for (WebElement ele:products)
        {
            productsNameList.add(ele.getText());
        }
    }
    public void clickOnSearchButton(){
        clickOnElement(By.xpath("//button[@class='button-1 search-box-button']"));
    }
    public void clickOnVoteButton(){
        clickOnElement(By.xpath("//button[@class='button-2 vote-poll-button']"));

    }
   public void userAbleToChangeTheCurrency()
   {
        //Search locator of currency and store it in currency variable
        By _currency = By.id("customerCurrency");
        //Select drop down option with the help of select by text method created in utills class
        selectByText(_currency, currency);
        //verify all Element got choosen euro currency
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> currencyOption = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        for (WebElement we : currencyOption) {
           System.out.println(we.getText());
           softAssert.assertTrue(we.getText().contains("€"), "$ not found" + we.getText());
           System.out.println("This is Euro currency");
          }
         softAssert.assertAll();
   }
    public void userAbleToAddCommentonNewReleaseOfNewsSection()
    {
        //Click on details button
        clickOnElement(By.xpath("//div[@class='news-items']/div[2]/div[3]/a"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //Verify that we are landing on the right url by keeping assertion here
        Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce-new-release"), "User is NOT on Nop-Commerce news release page");
        //Comment title has been given through typetext method
        typeText(By.xpath("//div[@class='inputs']/input[@class='enter-comment-title']"), "Comment title given by Niyati");
        // Comment discription has been added through type text method
        typeText(By.xpath("//div[@class='inputs']/textarea[@class='enter-comment-text']"),"This is comment description given by niyati This is comment description given by niyati This is comment description given by niyati");
        //Click on submit button
        clickOnElement(By.xpath("//div[@class='buttons']/button[@type='submit']"));
        //Getting actual Comment message in this variable
        String actualCommentMessage= getTextFromElement(By.xpath("//div[@class='result']"));
        //Verify that message with expected comment message
        Assert.assertEquals(actualCommentMessage, expectedCommentMessage, "Your Comment is not added successfully");
        System.out.println(actualCommentMessage);
    }
    public void userAbletoSearchForNikeProductFromSearchButton()
    {
        typeText(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"),"Nike");
        clickOnElement(By.xpath("//button[@class='button-1 search-box-button']"));
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> nikeOption = driver.findElements(By.xpath("//div[@class='details']/h2"));
        for (WebElement ne : nikeOption) {
            System.out.println(ne.getText());
            softAssert.assertTrue(ne.getText().contains("Nike"), "Nike not found" + ne.getText());
            System.out.println("This is Nike search result");
        }
        softAssert.assertAll();
    }
    public void searchForMacbookAndAddToCart()
    {   // Type Apple macbook in Search textbox
        typeText(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"),"Apple MacBook Pro 13-inch");
        //Click on search button
        clickOnElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));
        //click on add to cart button from the search result page
        clickOnElement((By.xpath("//div[@class='add-to-cart-panel']/button")));
        //click on add to cart button from the link given on header
        clickOnElement(By.xpath("//li[@id='topcartlink']/a/span[@class='cart-label']"));
        //Tick on check box of terms and condition
        driver.findElement(By.xpath("//div[@class='terms-of-service']/input")).isSelected();
        //click on checkout button
        clickOnElement(By.xpath("//div[@class='checkout-buttons']/button"));

    }





    }


