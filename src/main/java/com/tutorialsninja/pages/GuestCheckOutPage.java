package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class GuestCheckOutPage extends Utility {
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By email = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By address = By.xpath("//input[@id='input-payment-address-1']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postcode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");

    By continueButton = By.xpath("//input[@id='button-guest']");

    By enterComments= By.tagName("textarea");
    By termsAndConditionsCheckBox = By.xpath("//input[@name='agree']");
    By continueButtonAgain = By.xpath("//input[@id='button-payment-method']");
    By paymentMethodRequiredMessage = By.xpath("//div[text()='Warning: Payment method required!']");

    public void enterFirstName(){
        sendTextToElement(firstName,"Prachi");
    }
    public void enterLastName(){
        sendTextToElement(lastName, "Desai");
    }
    public void enterEmail(){
        sendTextToElement(email,"pd1@gmail.com");
    }
    public void enterTelephone(){
        sendTextToElement(telephone,"07456789012");
    }
    public void enterAddress(){
        sendTextToElement(address,"123, Wellington Avenue");
    }
    public void enterCity(){
        sendTextToElement(city,"London");
    }
    public void enterPostcode(){
        sendTextToElement(postcode,"IG5 8TD");
    }
    public void selectCountry(){
        selectFromDropDownMenu(country,"United Kingdom");
    }
    public void selectRegion(){
        selectFromDropDownMenu(region,"Greater London");
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public void enterComments(){
        sendTextToElement(enterComments,"Thank you");
    }
    public void checkTermsAndConditionsCheckbox(){
        clickOnElement(termsAndConditionsCheckBox);
    }
    public void clickOnContinueButtonAgain(){
        clickOnElement(continueButtonAgain);
    }
    public String getPaymentMethodRequiredMessage(){
        return getTextFromElement(paymentMethodRequiredMessage);
    }
}
