package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ReferAFriend extends Utils{
    String ExpectedResult = "Your message has been sent.";
    public void verifyUserShouldReferaProducttoFriend(){

        clickOnElement(By.xpath("//div[@class='header-menu']/ul[contains(@class,'notmobile')]/li[2]/a[@href='/electronics']"));
        clickOnElement(By.xpath("//div[@class='master-wrapper-content']/div/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[@class='title']/a[@href='/camera-photo']"));
        clickOnElement(By.xpath("//div[3]/div[@class='product-item']/div[2]/h2/a[@href='/leica-t-mirrorless-digital-camera']"));
        clickOnElement(By.xpath("//button[@class='button-2 email-a-friend-button']"));
        typeText(By.xpath("//input[@class='friend-email']"), "sharma12345@gmail.com");
        //typeText(By.xpath("//input[@class='your-email']"), email);
        typeText(By.xpath("//textarea[@class='your-email']"), "your new message");
        clickOnElement(By.xpath("//button[@class='button-1 send-email-a-friend-button']"));
        String actualRegistrationMessage= getTextFromElement(By.xpath("//div[@class='result']"));
        System.out.println(actualRegistrationMessage);
        Assert.assertEquals(actualRegistrationMessage, ExpectedResult, "You have not refered a product to friend");
    }


}
