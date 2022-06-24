package FinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp {
    private WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement nameInput(){
        return driver.findElement(By.id("name"));
    }
    public WebElement emailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement passwordInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement confirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement signUpButton(){return driver.findElement(By.xpath("//a[contains(@href, '/signup')]"));
    }
    public WebElement signUpCompleteButton(){
        return driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
    }
}
