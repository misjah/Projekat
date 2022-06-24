package FinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cities {
    private WebDriver driver;

    public Cities(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement newItemButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
    }
    public WebElement nameFieldOnNewItemDialog(){
        return driver.findElement(By.xpath("//input[contains(@id, 'name')]"));
    }
    public WebElement searchField(){
        return driver.findElement(By.id("search"));
    }
    public WebElement newItemField(){
        return driver.findElement(By.xpath
                ("//input[contains(@name, 'name')]"));
    }
    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'dlgNewEdit')]")));
    }
    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//header[contains(@class, 'warning')]")));
    }
    public WebElement saveButtonFromEditDialog(){
        return driver.findElement(By.xpath
                ("//button[contains(@class, 'btnSave')]"));
    }
    public WebElement deleteButtonFromDeleteDialog(){
        return driver.findElement(By.xpath
                ("//div[contains(@class, 'v-dialog__content--active')]/div/div/div/button[2]"));
    }
    public void waitForNumberOfProductRows(int numberOfRows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                ("//table/tbody/tr"), numberOfRows));
    }
    public WebElement productRows(int row, int cell) {
        return driver
                .findElement(By.xpath
                        ("//table/tbody/tr[" + row + "]/td[" + cell + "]"));
    }
    public WebElement editButtonForTheRow(int row){
        return driver.findElement(By.xpath
                ("//button[contains(@id, 'edit')][" + row + "]"));
    }
    public WebElement deleteButtonForTheRow(int row){
        return driver.findElement(By.xpath
                ("//button[contains(@id, 'delete')][" + row + "]"));
    }
    public WebElement editNameFieldInDialog(){
        return driver.findElement(By.xpath
                ("//input[contains(@id, 'name')]"));
    }
}
