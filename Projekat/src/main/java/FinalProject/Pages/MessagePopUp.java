package FinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUp {
    private WebDriver driver;

    public MessagePopUp(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[@role='status']")));
    }
    public void waitForPopUpAddNewCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));
    }
    public void waitForPopUpDeleteCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));

    }
    public WebElement popupElementsWithVisibleMessagesForCities(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]"));
    }

    public WebElement popupElementsWithVisibleMessages(){
        return driver.findElement(By.xpath("//div[contains(@class, 'container')]/div/div/div/div/div/div/div/ul/li"));
    }
    public void popupWaitForVerificationAccountIsShown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dialog__content ')]/div/div/div/i")));
    }
    public WebElement popupHeadlineVerificationDialog(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
    }
    public WebElement popupCloseButtonVerificationDialog(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }
    public WebElement popupLoginVcard(){
        return driver.findElement(By.xpath("//div[@class='v-card__text']"));
    }
}
