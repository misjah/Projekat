package FinalProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BasicTests{
    @Test(priority = 10) //Test #1: Visits the signup page
    public void visitsTheSignupPage(){
        navPage.switchDarkMode().click();
        signUp.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
                "[ERROR] Page url does not contain /signup");
    }
    @Test (priority = 20) //Test #2: Checks input types
    public void checksInputTypes(){
        signUp.signUpButton().click();
        Assert.assertTrue(signUp.emailInput().getAttribute("type").contains("email"),
                "[ERROR] Attribute type does not contains email");
        Assert.assertTrue(signUp.passwordInput().getAttribute("type").contains("password"),
                "[ERROR] Attribute type does not contains password");
        Assert.assertTrue(signUp.confirmPasswordInput().getAttribute("type").contains("password"),
                "[ERROR] Attribute type does not contain password");
    }
    @Test (priority = 30) //Test #3: Displays errors when user already exists
    public void displaysErrorsWhenUserAlreadyExists(){
        signUp.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");
        signUp.nameInput().sendKeys("Another User");
        signUp.emailInput().sendKeys("admin@admin.com");
        signUp.passwordInput().sendKeys("12345");
        signUp.confirmPasswordInput().sendKeys("12345");
        signUp.signUpCompleteButton().click();
        messagePopUp.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUp.popupElementsWithVisibleMessages().getText(),
                "E-mail already exists",
                "[ERROR] Error message is not displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
                "[ERROR] Page url does not contain /signup");
    }
    @Test (priority = 40) //Test #4: Signup
    public void signUp(){
        signUp.signUpButton().click();
        signUp.nameInput().sendKeys("Miki Milic");
        signUp.emailInput().sendKeys("misjah@yahoo.com");
        signUp.passwordInput().sendKeys("12345");
        signUp.confirmPasswordInput().sendKeys("12345");
        signUp.signUpCompleteButton().click();
        messagePopUp.popupCloseButtonVerificationDialog().click();
        navPage.logoutButton().click();
        loginPage.emailInput().sendKeys("misjah@yahoo.com");
        loginPage.passwordInput().sendKeys("12345");
        loginPage.loginButtonAfterInput().click();
        messagePopUp.popupWaitForVerificationAccountIsShown();
        Assert.assertEquals(messagePopUp.popupHeadlineVerificationDialog().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] There is no warning message");
        messagePopUp.popupCloseButtonVerificationDialog().click();
        navPage.logoutButton().click();
    }
}
