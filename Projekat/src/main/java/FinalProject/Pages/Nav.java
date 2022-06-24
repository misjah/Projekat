package FinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nav {
    private WebDriver driver;

    public Nav(WebDriver driver){
        this.driver = driver;
    }
    public WebElement homeButton(){
        return driver.findElement(By.xpath("//span[normalize-space()='Home']"));
    }
    public WebElement aboutButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-help')]"));
    }
    public WebElement myProfileButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-face')]"));
    }
    public WebElement adminButton(){
        return driver.findElement(By.xpath("//span[normalize-space()='Admin']"));
    }
    public WebElement citiesAdminFromDropdown(){
        return driver.findElement(By.xpath("//a[contains(@href, '/admin/cities')]"));
    }

    public WebElement usersLinkFromDropdown(){
        return driver.findElement(By.xpath("//a[contains(@href, '/admin/users')]"));
    }
    public WebElement logoutButton(){
        return driver.findElement(By.xpath("//i[contains(@class, 'mdi-exit')]"));
    }
    public WebElement changeLanguageButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__content')]/div[3]/button"));
    }
    public WebElement langEnButtonDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div"));
    }
    public WebElement langEsButtonDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[2]"));
    }
    public WebElement langFrButtonDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[3]"));
    }
    public WebElement langChButtonDropdown(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[4]"));
    }
    public WebElement headerFromChangedLanguage(){
        return driver.findElement(By.xpath("//div[contains(@class, 'container')]/div/div/h1"));
    }
    public WebElement switchDarkMode(){
        return driver.findElement(By.xpath("//div[@class='v-list-item__action']//div[@class='v-input--selection-controls__ripple']"));
    }
}

