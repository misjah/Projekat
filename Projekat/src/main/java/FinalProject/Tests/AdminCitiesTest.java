package FinalProject.Tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BasicTests{

    String oldCity = "Nis"; String newCity = "Bor";

    @Test (priority = 10) //Test #1: Visits the admin cities page and list cities
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.switchDarkMode().click();
        loginPage.loginButton().click();
        loginPage.emailInput().click();
        loginPage.emailInput().sendKeys(adminDefault);
        loginPage.passwordInput().click();
        loginPage.passwordInput().sendKeys(adminDefaultPassword);
        loginPage.loginButtonAfterInput().click();
        navPage.adminButton().click();
        navPage.citiesAdminFromDropdown().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Url does not contain /admin/cities");
    }
    @Test (priority = 20) //Test #2: Checks input types for create/edit new city
    public void checksInputTypesForCreateEditNewCity(){
        navPage.adminButton().click();
        navPage.citiesAdminFromDropdown().click();
        cities.newItemButton().click();
        cities.waitForEditDialogToBeVisible();
        Assert.assertTrue(cities.newItemField().getAttribute("type").contains("text"),
                "[ERROR] Attribute does not contain text");
    }
    @Test (priority = 30) //Test #3: Create new city
    public void createNewCity(){
        navPage.adminButton().click();
        navPage.citiesAdminFromDropdown().click();
        cities.newItemButton().click();
        cities.waitForEditDialogToBeVisible();
        cities.nameFieldOnNewItemDialog().click();
        cities.nameFieldOnNewItemDialog().sendKeys(oldCity);
        cities.saveButtonFromEditDialog().click();
        messagePopUp.waitForPopUpAddNewCityToBeVisible();
        Assert.assertTrue(messagePopUp.popupElementsWithVisibleMessagesForCities().getText().contains("Saved"),
                "[ERROR] City not saved");
    }
    @Test (priority = 40) //Test #4: Edit city
    public void editCity(){
        navPage.adminButton().click();
        navPage.citiesAdminFromDropdown().click();
        cities.searchField().click();
        cities.searchField().sendKeys(oldCity);
        cities.waitForNumberOfProductRows(1);
        cities.editButtonForTheRow(1).click();
        cities.editNameFieldInDialog().click();
        cities.waitForEditDialogToBeVisible();
        cities.editNameFieldInDialog().sendKeys(Keys.CONTROL, "a");
        cities.editNameFieldInDialog().sendKeys(newCity);
        cities.saveButtonFromEditDialog().click();
        messagePopUp.waitForPopUpAddNewCityToBeVisible();
        Assert.assertTrue(messagePopUp.popupElementsWithVisibleMessagesForCities().getText().contains("Saved"),
                "[ERROR] City not saved");
    }
    @Test (priority = 50) //Test #5: Search city
    public void searchCity(){
        navPage.adminButton().click();
        navPage.citiesAdminFromDropdown().click();
        cities.searchField().sendKeys(newCity);
        cities.waitForNumberOfProductRows(1);
        Assert.assertTrue(cities.productRows(1,2).getText().contains(newCity),
                "[ERROR] Text mismatch");
    }
    @Test (priority = 60) //Test #6: Delete city
    public void deleteCity(){
        navPage.adminButton().click();
        navPage.citiesAdminFromDropdown().click();
        cities.searchField().sendKeys(newCity);
        cities.waitForNumberOfProductRows(1);
        Assert.assertTrue(cities.productRows(1,2).getText().contains(newCity),
                "[ERROR] No such text on this page");
        cities.deleteButtonForTheRow(1).click();
        cities.waitForDeleteDialogToBeVisible();
        cities.deleteButtonFromDeleteDialog().click();
        messagePopUp.waitForPopUpDeleteCityToBeVisible();
        Assert.assertTrue(messagePopUp.popupElementsWithVisibleMessagesForCities().getText().contains("Deleted"),
                "[ERROR] City not deleted");
    }
}
