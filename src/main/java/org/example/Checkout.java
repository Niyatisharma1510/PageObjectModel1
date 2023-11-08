package org.example;

import org.openqa.selenium.By;

public class Checkout extends Utils{
    public void userCanCheckout()
    {
       selectByText(By.xpath("//div[@class=\"inputs\"]/select[@id=\"BillingNewAddress_CountryId\"]"),"United Kingdom");
       typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_City\"]"),"London");
       typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_Address1\"]"),"43 Ninja Road");
       typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_ZipPostalCode\"]"),"SKJ 8HJ");
       
    }
}
