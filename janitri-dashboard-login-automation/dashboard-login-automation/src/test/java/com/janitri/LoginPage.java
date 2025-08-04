package com.janitri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userIdInput = By.xpath("//input[@name='email']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By pwEyeIcon = By.xpath("//button[contains(@aria-label, 'Show password') or contains(@aria-label, 'Hide password')]");
    private By errorMsg = By.xpath("//*[contains(@class,'MuiAlert-message') or contains(text(),'Invalid') or contains(text(),'incorrect')]");
    private By pageTitle = By.xpath("//h1|//h2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdInput).clear();
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        return driver.findElement(passwordInput).getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(pwEyeIcon).click();
    }

    public boolean isEyeIconPresent() {
        return !driver.findElements(pwEyeIcon).isEmpty();
    }

    public boolean isUserIdInputPresent() {
        return !driver.findElements(userIdInput).isEmpty();
    }

    public boolean isPasswordInputPresent() {
        return !driver.findElements(passwordInput).isEmpty();
    }

    public boolean isLoginButtonPresent() {
        return !driver.findElements(loginButton).isEmpty();
    }

    public boolean isPageTitlePresent() {
        return !driver.findElements(pageTitle).isEmpty();
    }

    public String getErrorMessage() {
        if (!driver.findElements(errorMsg).isEmpty()) {
            return driver.findElement(errorMsg).getText();
        } else {
            return "";
        }
    }

    public By getUserIdInput() {
        return userIdInput;
    }

    public void setUserIdInput(By userIdInput) {
        this.userIdInput = userIdInput;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(By loginButton) {
        this.loginButton = loginButton;
    }

    public By getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(By errorMsg) {
        this.errorMsg = errorMsg;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(By passwordInput) {
        this.passwordInput = passwordInput;
    }

    public By getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(By pageTitle) {
        this.pageTitle = pageTitle;
    }

    public By getPwEyeIcon() {
        return pwEyeIcon;
    }

    public void setPwEyeIcon(By pwEyeIcon) {
        this.pwEyeIcon = pwEyeIcon;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
