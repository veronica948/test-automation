package com.haritonova.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Veronica_Haritonova
 */
public class MainPage extends AbstractPage {

    private final String BASE_URL = "http://www.de-online.ru";

    @FindBy(name = "q")
    private WebElement inputSearch;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void makeSearch(String input) {
        inputSearch.sendKeys(input);
        inputSearch.submit();
    }
}
