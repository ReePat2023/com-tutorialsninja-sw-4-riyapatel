package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountLoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.MyAccountRegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountLoginPageTest extends BaseTest {
    MyAccountPage myAccountPage = new MyAccountPage();
    MyAccountRegisterPage accountRegisterPage = new MyAccountRegisterPage();
    MyAccountLoginPage accountLoginPage = new MyAccountLoginPage();

    public AccountLoginPageTest() {
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        this.myAccountPage.clickOnMyAccountTab();
        this.myAccountPage.selectMyAccountOptions("Login");
        this.accountLoginPage.enterEmailAddress();
        this.accountLoginPage.enterValidPassword();
        this.accountLoginPage.clickOnLoginButton();
        this.accountLoginPage.getMyAccountText();
        Assert.assertEquals(this.accountLoginPage.getMyAccountText(), "My Account", "Error Message");
        this.myAccountPage.clickOnMyAccountTab();
        this.myAccountPage.selectMyAccountOptions("Logout");
        this.accountRegisterPage.getAccountLogoutText();
        Assert.assertEquals(this.accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        this.accountRegisterPage.clickOnContinueButtonAgain();
    }
}
