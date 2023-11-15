package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProduct extends Utils{
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
        driver.findElement(By.xpath("//input[@class='search-box-text ui-autocomplete-input']")).sendKeys("Apple MacBook Pro 13");
        //wait till page appear
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Click on search button
        clickOnElement(By.xpath("//button[@class=\"button-1 search-box-button\"]"));
        //wait till page appear
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //click on add to cart button from the search result page
        clickOnElement(By.xpath("//button[@class=\"button-1 add-to-cart-button\"]"));
        //click on add to cart button from the link given on header
        clickOnElement(By.xpath("//li[@id='topcartlink']/a/span[@class='cart-label']"));
        //Tick on check box of terms and condition
       driver.findElement(By.xpath("//div[@class='terms-of-service']/input")).isSelected();
        //click on checkout button
        clickOnElement(By.xpath("//div[@class='checkout-buttons']/button"));

    }

}
