package org.example;

import org.openqa.selenium.By;

public class Checkout extends Utils {
    public void userCanCheckout()

    {   //Enter country name

        {   //Enter country name for billing information
            selectByText(By.xpath("//div[@class=\"inputs\"]/select[@id=\"BillingNewAddress_CountryId\"]"), "United Kingdom");
            //Enter City Name for billing information
            typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_City\"]"), "London");

            //Add address line 2
            typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_Address1\"]"), "43 Ninja Road");

            typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_ZipPostalCode\"]"), "SKJ 8HJ");
            //enter mobile number
            typeText(By.xpath("//div[@class=\"inputs\"]/input[@id=\"BillingNewAddress_PhoneNumber\"]"), "07896541236");
            //click on  billing continue button
            clickOnElement(By.xpath("//div[@class=\"buttons\"]/button[@onclick=\"Billing.save()\"]"));
            //shipping method continue button
            driver.findElement(By.xpath("//div[@class=\"method-name\"]/label[@for=\"shippingoption_0\"]")).isSelected();
            //Click on continue button
            clickOnElement(By.xpath("//div[@id=\"shipping-method-buttons-container\"]/button[@onclick=\"ShippingMethod.save()\"]"));
            //Click on money order option
            clickOnElement(By.xpath("//div[@class=\"payment-details\"]/input[@id=\"paymentmethod_0\"]"));
            //Click on payment method continue button
            clickOnElement(By.xpath("//div[@id=\"payment-method-buttons-container\"]/button[@onclick=\"PaymentMethod.save()\"]"));
            //payment information continue button
            clickOnElement(By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]"));
            //click on Last confirm button
            clickOnElement(By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]"));


        }
    }
}
