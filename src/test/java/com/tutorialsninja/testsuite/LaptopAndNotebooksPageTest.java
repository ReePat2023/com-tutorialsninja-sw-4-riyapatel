package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.GuestCheckOutPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebooksPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopAndNotebooksPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopAndNotebooksPage laptopsAndNotebooksPage = new LaptopAndNotebooksPage();
    ShoppingCartPage shoppingCartpage = new ShoppingCartPage();
    GuestCheckOutPage guestCheckoutPage = new GuestCheckOutPage();


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        this.homePage.mouseHoverAndClickLaptopsAndNotebooks();
        this.laptopsAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        this.laptopsAndNotebooksPage.originalProductPrice();
        this.laptopsAndNotebooksPage.sortByPriceHightoLow();
        this.laptopsAndNotebooksPage.afterSortByPrice();
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        this.shoppingCartpage.clickOnCurrencyTab();
        this.shoppingCartpage.clickOnPoundSterling();
        this.homePage.mouseHoverAndClickLaptopsAndNotebooks();
        this.laptopsAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        this.laptopsAndNotebooksPage.sortByPriceHightoLow();
        this.laptopsAndNotebooksPage.clickOnMacbook();
        Assert.assertEquals(this.laptopsAndNotebooksPage.getMacbooktext(), "MacBook", "Macbook product not found");
        this.laptopsAndNotebooksPage.clickOnAddToCartButton();
        this.laptopsAndNotebooksPage.getMacBookAddedToCartMessage();
        Assert.assertEquals(this.laptopsAndNotebooksPage.getMacBookAddedToCartMessage(), "Success: You have added MacBook to your shopping cart!", "Cannot add MacBook");
        this.laptopsAndNotebooksPage.clickOnShoppingCartLink();
        Assert.assertEquals(this.laptopsAndNotebooksPage.getShoppingCartText(), "Shopping Cart  (0.00kg)", "Shopping cart message not found");
        Assert.assertEquals(this.laptopsAndNotebooksPage.getMacBookText(), "MacBook", "MacBook product not found");
        this.laptopsAndNotebooksPage.clearQty();
        this.laptopsAndNotebooksPage.clickOnUpdateQty();
        this.laptopsAndNotebooksPage.getModifiedShoppingCartText();
        Assert.assertEquals(this.laptopsAndNotebooksPage.getModifiedShoppingCartText(), "Success: You have modified your shopping cart!", "Cart not modified");
        Assert.assertEquals(this.laptopsAndNotebooksPage.getTotalPrice(), "£737.45", "incorrect price");
        this.laptopsAndNotebooksPage.clickOnCheckoutButton();
        Assert.assertEquals(this.laptopsAndNotebooksPage.getCheckoutText(), "Checkout", "Error Message");
       // this.(By.xpath("//h2[contains(text(),'New Customer')]"), 5);
        Assert.assertEquals(this.laptopsAndNotebooksPage.getNewCustomerText(), "New Customer", "New Customer text not displayed");
        this.laptopsAndNotebooksPage.clickOnGuestCheckoutButton();
        this.laptopsAndNotebooksPage.clickOnContinueTab();
        this.guestCheckoutPage.enterFirstName();
        this.guestCheckoutPage.enterLastName();
        this.guestCheckoutPage.enterEmail();
        this.guestCheckoutPage.enterTelephone();
        this.guestCheckoutPage.enterAddress();
        this.guestCheckoutPage.enterCity();
        this.guestCheckoutPage.enterPostcode();
        this.guestCheckoutPage.selectCountry();
        this.guestCheckoutPage.selectRegion();
        this.guestCheckoutPage.clickOnContinueButton();
        this.guestCheckoutPage.enterComments();
        this.guestCheckoutPage.checkTermsAndConditionsCheckbox();
        this.guestCheckoutPage.clickOnContinueButtonAgain();
        Assert.assertEquals(this.guestCheckoutPage.getPaymentMethodRequiredMessage(), "Warning: Payment method required!\n×");
    }
}
