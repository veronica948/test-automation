package com.haritonova.automation.steps;

import com.haritonova.automation.pages.CoursesPage;
import com.haritonova.automation.pages.MainPage;
import com.haritonova.automation.pages.TranslatePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Veronica_Haritonova
 */
public class Steps {
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver()
    {
        driver.quit();
        logger.info("Browser closed");
    }


    public String getSearchTitle(String input) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.makeSearch(input);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
    public String translateWord(String word) {
        TranslatePage translatePage = new TranslatePage(driver);
        translatePage.openPage();
        return translatePage.translate(word);
    }
    public boolean searchResultsContainsInput(String input) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.makeSearch(input);
        List<WebElement> searchResults = driver.findElements(By.className("eMessage"));
        for (WebElement searchResult : searchResults) {
            if (!searchResult.getText().toLowerCase().contains(input.toLowerCase())) {
               return false;
            }
        }
        return true;
    }
    public boolean courseCounrtyExists(String countryName) {
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.openPage();
        List<WebElement> countryList = coursesPage.getAvailableCountries();
        for(WebElement country : countryList) {
            if(country.getText().toLowerCase().contains(countryName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public boolean isNotEmptyCourseCountriesList() {
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.openPage();
        List<WebElement> countryList = coursesPage.getAvailableCountries();
        return !countryList.isEmpty();
    }
}
