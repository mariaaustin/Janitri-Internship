package com.janitri;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("");
        loginPage.enterPassword("");
        Assert.assertFalse(loginPage.isLoginButtonEnabled());
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("invalid@user.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        Assert.assertFalse(loginPage.getErrorMessage().isEmpty());
        System.out.println("Error Message: " + loginPage.getErrorMessage());
    }

    @Test
    public void testPasswordMaskedButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("samplePassword");
        Assert.assertTrue(loginPage.isPasswordMasked());
        if (loginPage.isEyeIconPresent()) {
            loginPage.togglePasswordVisibility();
            Assert.assertFalse(loginPage.isPasswordMasked());
        }
    }

    @Test
    public void testPresenceOfPageElements() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUserIdInputPresent());
        Assert.assertTrue(loginPage.isPasswordInputPresent());
        Assert.assertTrue(loginPage.isLoginButtonPresent());
        Assert.assertTrue(loginPage.isEyeIconPresent());
        Assert.assertTrue(loginPage.isPageTitlePresent());
    }
}
