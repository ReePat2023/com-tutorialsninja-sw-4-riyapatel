package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebooksPage extends Utility {
    By clickOnShowAllLaptopsandNoteBooks = By.linkText("Show AllLaptops & Notebooks");
    By sortByPrice = By.id("input-sort");
    By macbookClick = By.linkText("MacBook");
    By macbookText = By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    By macBookAddedToCart = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By MacBookText = By.xpath("(//a[text()='MacBook'])[2]");
    By clearQty = By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]");
    By updateQty = By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]");
    By modifiedShoppingCart = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");
    By totalPrice = By.xpath("//tbody/tr[1]/td[6]");
    By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    By checkoutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutButton= By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]");
    By continueTab = By.xpath("//input[@id='button-account']");

    public void clickOnShowAllLaptopAndNoteBooks() {
        clickOnElement(clickOnShowAllLaptopsandNoteBooks);
    }
    public void originalProductPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
    }
    public void sortByPriceHightoLow() {
        selectFromDropDownMenu(sortByPrice, "Price (High > Low)");
    }
    public void afterSortByPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
    }
    public void clickOnMacbook() {
        clickOnElement(macbookClick);
    }

    public String getMacbooktext() {
        return getTextFromElement(macbookText);
    }
    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }
    public String getMacBookAddedToCartMessage(){
        return getTextFromElement(macBookAddedToCart).substring(0,54);
    }
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCartLink);
    }
    public String getShoppingCartText(){
        return getTextFromElement(shoppingCartText);
    }
    public String getMacBookText(){
        return getTextFromElement(MacBookText);
    }
    public void clearQty(){
        driver.findElement(clearQty).clear();
        sendTextToElement(clearQty,"2");
    }
    public void clickOnUpdateQty(){
        clickOnElement(updateQty);
    }
    public String getModifiedShoppingCartText(){
        return getTextFromElement(modifiedShoppingCart).substring(0,46);
    }
    public String getTotalPrice(){
        return getTextFromElement(totalPrice);
    }
    public void clickOnCheckoutButton(){
        clickOnElement(checkoutButton);
    }

    public String getCheckoutText(){
        return getTextFromElement(checkoutText);
    }
    public String getNewCustomerText(){
        return getTextFromElement(newCustomerText);
    }
    public void clickOnGuestCheckoutButton(){
        clickOnElement(guestCheckoutButton);
    }
    public void clickOnContinueTab(){
        clickOnElement(continueTab);
    }

}