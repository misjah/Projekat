package FinalProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BasicTests{
    @Test(priority = 10) //Test #1: Set locale to ES
    public void setLocaleToES(){
        navPage.switchDarkMode().click();
        navPage.changeLanguageButton().click(); navPage.langEsButtonDropdown().click();
        Assert.assertTrue(navPage.headerFromChangedLanguage().getText().contains("Página de aterrizaje"),
                "[ERROR] Header not containing language text");
    }
    @Test (priority = 20) //Test #2: Set locale to EN
    public void setLocaleToEn(){
        navPage.changeLanguageButton().click(); navPage.langEnButtonDropdown().click();
        Assert.assertTrue(navPage.headerFromChangedLanguage().getText().contains("Landing"),
                "[ERROR] Header not containing language text");
    }
    @Test (priority = 30) //Test #3: Set locale to CN
    public void setLocaleToCN(){
        navPage.changeLanguageButton().click(); navPage.langChButtonDropdown().click();
        Assert.assertTrue(navPage.headerFromChangedLanguage().getText().contains("首页"),
                "[ERROR] Header not containing language text");
    }
    @Test (priority = 40) //Test #4: Set locale to FR
    public void setLocaleToFR() {
        navPage.changeLanguageButton().click(); navPage.langFrButtonDropdown().click();

        Assert.assertTrue(navPage.headerFromChangedLanguage().getText().contains("Page d'atterrissage"),
                "[ERROR] Header not containing language text");
    }
}
