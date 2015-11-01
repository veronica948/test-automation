package com.haritonova.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Veronica_Haritonova
 */
public class CoursesPage extends AbstractPage{
    private final String BASE_URL = "http://www.de-online.ru/board/";

    @FindBy(className = "kurse_land")
    List<WebElement> availableCountries;

    public CoursesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public List<WebElement> getAvailableCountries() {
        return availableCountries;
    }
}
