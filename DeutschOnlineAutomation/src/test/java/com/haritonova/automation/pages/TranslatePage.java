package com.haritonova.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Veronica_Haritonova.
 */
public class TranslatePage extends AbstractPage {
    private final String BASE_URL = "http://www.de-online.ru/index/onlajn_perevodchik_nemecko_russkij_russko_nemeckij/0-611";

    @FindBy(id = "bTranslate")
    private WebElement translateButton;

    @FindBy(id = "source_text")
    private WebElement fromArea;

    @FindBy(className = "ref_result")
    private List<WebElement> resultList;

    public TranslatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
    public List<String> translate(String word) {
        fromArea.sendKeys(word);
        translateButton.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElements(By.className("ref_result")).isEmpty();
            }
        });
        List<String> resultStringList = new ArrayList<>(resultList.size());
        for (WebElement webElement : resultList) {
            resultStringList.add(webElement.getText());
        }
        return resultStringList;
    }
}
