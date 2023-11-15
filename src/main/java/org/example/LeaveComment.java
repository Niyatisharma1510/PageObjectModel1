package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeaveComment extends Utils {
    String expectedCommentMessage = "News comment is successfully added.";

    public void userAbleToAddCommentonNewReleaseOfNewsSection() {
        //Click on details button
        clickOnElement(By.xpath("//div[@class='news-items']/div[2]/div[3]/a"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //Verify that we are landing on the right url by keeping assertion here
        Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce-new-release"), "User is NOT on Nop-Commerce news release page");
        //Comment title has been given through typetext method
        typeText(By.xpath("//div[@class='inputs']/input[@class='enter-comment-title']"), "Comment title given by Niyati");
        // Comment discription has been added through type text method
        typeText(By.xpath("//div[@class='inputs']/textarea[@class='enter-comment-text']"), "This is comment description given by niyati This is comment description given by niyati This is comment description given by niyati");
        //Click on submit button
        clickOnElement(By.xpath("//div[@class='buttons']/button[@type='submit']"));

    }
    public void verifyCommentIsPosted()
    {
        //Getting actual Comment message in this variable
        String actualCommentMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        //Verify that message with expected comment message
        Assert.assertEquals(actualCommentMessage, expectedCommentMessage, "Your Comment is not added successfully");
        System.out.println(actualCommentMessage);
    }
    public void verifyCommentAddedLast()  {
        List<WebElement> commentsection = driver.findElements(By.xpath("//div[@class=\"comment-list\"]"));

        System.out.println(commentsection.size());
        int comments= commentsection.size();
        System.out.println(commentsection.get(comments-1).getText());

        Assert.assertEquals(commentsection.get(comments-1).getText(),"Comment title given by Niyati","comment is not added in last");
//        List<String> commentsectionList = new ArrayList<>();
//        for (WebElement ele:commentsection)
//        {
//            commentsectionList.add(ele.getText());
//        }
    }

}
