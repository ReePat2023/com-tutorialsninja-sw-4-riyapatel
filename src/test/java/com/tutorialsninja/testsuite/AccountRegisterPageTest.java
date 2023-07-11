package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.MyAccountRegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountRegisterPageTest extends BaseTest {
    MyAccountPage myAccountPage = new MyAccountPage();
    MyAccountRegisterPage accountRegisterPage = new MyAccountRegisterPage();

    public AccountRegisterPageTest() {
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        this.myAccountPage.clickOnMyAccountTab();
        this.myAccountPage.selectMyAccountOptions("Register");
        this.myAccountPage.getRegisterAccountText();
        Assert.assertEquals(this.myAccountPage.getRegisterAccountText(), "Register Account", "Register Account not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        this.myAccountPage.clickOnMyAccountTab();
        this.myAccountPage.selectMyAccountOptions("Login");
        this.myAccountPage.getReturningCustomerText();
        Assert.assertEquals(this.myAccountPage.getReturningCustomerText(), "Returning Customer", "Returning Customer Text not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        this.myAccountPage.clickOnMyAccountTab();
        this.myAccountPage.selectMyAccountOptions("Register");
        this.accountRegisterPage.enterFirstName();
        this.accountRegisterPage.enterLastName();
        this.accountRegisterPage.enterEmail();
        this.accountRegisterPage.enterTelephone();
        this.accountRegisterPage.enterPassword();
        this.accountRegisterPage.enterConfirmPassword();
        this.accountRegisterPage.selectSubscribeYesRadioButton();
        this.accountRegisterPage.clickPrivacyPolicyCheckbox();
        this.accountRegisterPage.clickOnContinueButton();
        this.accountRegisterPage.getAccountHasBeenCreatedText();
        Assert.assertEquals(this.accountRegisterPage.getAccountHasBeenCreatedText(), "Your Account Has Been Created!", "Cannot create account");
        this.accountRegisterPage.clickOnContinueButtonAgain();
        this.accountRegisterPage.clickOnMyAccountLink();
        this.myAccountPage.selectMyAccountOptions("Logout");
        this.accountRegisterPage.getAccountLogoutText();
        Assert.assertEquals(this.accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        this.accountRegisterPage.clickOnContinueButtonAgain();
    }
}

