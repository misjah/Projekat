package FinalProject.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTests{
    @Test(priority = 10) //Test #1: Visits the login page
    public void visitsTheLoginPage() throws InterruptedException {
        navPage.switchDarkMode().click();
        navPage.changeLanguageButton().click();
        navPage.langEnButtonDropdown().click();
        loginPage.loginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain login");

    }
    @Test (priority = 20) //Test #2: Checks input types
    public void checksInputTypes() throws InterruptedException {
        loginPage.loginButton().click();
        Assert.assertEquals(loginPage.emailInput()
                        .getAttribute("type"), ("email")
                ,"[ERROR] Attribute type does not contain email");
        Assert.assertEquals(loginPage.passwordInput()
                        .getAttribute("type"), ("password")
                ,"[ERROR] Attribute type does not contain password");

    }
    @Test (priority = 30) //Test #3: Displays errors when user does not exist
    public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {
        loginPage.loginButton().click();
        loginPage.emailInput().click();
        loginPage.emailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.passwordInput().click();
        loginPage.passwordInput().sendKeys("password123");
        loginPage.loginButtonAfterInput().click();
        messagePopUp.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUp.popupElementsWithVisibleMessages().getText(),
                "User does not exists",
                "[ERROR] No error message displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain login");

    }
    @Test (priority = 40) //Test #4: Displays errors when password is wrong
    public void displaysErrorsWhenPasswordIsWrong() throws InterruptedException {
        loginPage.loginButton().click();
        loginPage.emailInput().click();
        loginPage.emailInput().sendKeys("admin@admin.com");
        loginPage.passwordInput().click();
        loginPage.passwordInput().sendKeys("password123");
        loginPage.loginButtonAfterInput().click();
        messagePopUp.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUp.popupElementsWithVisibleMessages().getText(),
                "Wrong password",
                "[ERROR] There is no error message displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "[ERROR] Page url does not contain login");

    }
    @Test (priority = 50) //Test #5: Login
    public void login() throws InterruptedException {
        loginPage.loginButton().click();
        loginPage.emailInput().click();
        loginPage.emailInput().sendKeys(adminDefault);

        loginPage.passwordInput().click();
        loginPage.passwordInput().sendKeys(adminDefaultPassword);

        loginPage.loginButtonAfterInput().click();
        wait.until(ExpectedConditions.urlContains("/home"));
  //      Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/home")), "[error]");

    }
    @Test (priority = 60) //Test #6: Logout
    public void logOut() throws InterruptedException {
        Assert.assertTrue(navPage.logoutButton().isDisplayed(),
                "[ERROR] Element not visible");
        navPage.logoutButton().click();


    }
}
