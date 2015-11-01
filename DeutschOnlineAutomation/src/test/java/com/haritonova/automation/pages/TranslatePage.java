package com.haritonova.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Veronica_Haritonova.
 */
public class TranslatePage extends AbstractPage {
    private final String BASE_URL = "http://www.de-online.ru/index/onlajn_perevodchik_nemecko_russkij_russko_nemeckij/0-611";

    @FindBy(id = "trans")
    private WebElement translateButton;

    @FindBy(id = "from")
    private WebElement fromArea;

    @FindBy(id = "w")
    private WebElement result;

    @FindBy(id = "dictArticles")
    private WebElement otherResultsBlock;

    public TranslatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
    public String translate(String word) {
        fromArea.sendKeys(word);
        translateButton.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElement(By.id("w")).getText().isEmpty();
            }
        });
        return result.getText();
    }
}
