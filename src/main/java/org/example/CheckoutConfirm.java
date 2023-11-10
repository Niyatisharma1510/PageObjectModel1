package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutConfirm extends Utils{
    String expectedCheckoutSuccessMessage = "Your order has been successfully processed!";
    public void verifyUserCheckoutSuccessfully(){
        //verify user checkout successfully or not
        String actualCheckoutMessage= getTextFromElement(By.xpath("//div[@class=\"title\"]/strong"));
        Assert.assertEquals(actualCheckoutMessage, expectedCheckoutSuccessMessage, "Your order has been successfully processed!");

    }
}
