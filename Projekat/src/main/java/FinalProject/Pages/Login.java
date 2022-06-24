package FinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
    private WebDriver driver;
    public Login (WebDriver driver){
        this.driver=driver;
    }
    public WebElement loginButton(){
        return  driver.findElement(By.xpath("//span[normalize-space()='Login']"));
    }
    public WebElement emailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement passwordInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement loginButtonAfterInput(){
        return driver.findElement(By.xpath("//div[contains(@class, 'layout ')]/div[3]/button"));
    }
}
