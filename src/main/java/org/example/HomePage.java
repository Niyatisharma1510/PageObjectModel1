package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends Utils {



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







    }


