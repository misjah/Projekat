package FinalProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRouteTest extends BasicTests{
    @Test(priority = 10) //Test #1: Forbids visits to home url if not authenticated
    public void forbidsVisitsToHome(){

        driver.get(baseUrl + "/home");
        loginPage.loginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),"[ERROR] does not return to login page");
    }
    @Test(priority = 20) //Test #2: Forbids visits to profile url if not authenticated
    public void forbidsVisitsToProfile(){
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "[ERROR] does not return to login page");
    }
    @Test(priority = 30) //Test #3: Forbids visits to admin cities url if not authenticated
    public void forbidsVisitsToAdminCities(){
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "[ERROR] does not return to login page");
    }
    @Test(priority = 40) //Test #4: Forbids visits to admin users url if not authenticated
    public void forbidsVisitsToAdminUsers(){
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "[ERROR] does not return to login page");
    }
}
