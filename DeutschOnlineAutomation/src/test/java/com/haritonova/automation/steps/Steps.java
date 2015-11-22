package com.haritonova.automation.steps;

import com.haritonova.automation.pages.CoursesPage;
import com.haritonova.automation.pages.MainPage;
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
        logger.info("Get search tittle");
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        logger.info("Page opened");
        mainPage.makeSearch(input);
        logger.info("Search executed");
        String pageTitle = driver.getTitle();
        logger.debug("Search tittle is " + pageTitle);
        return pageTitle;
    }

    public boolean searchResultsContainsInput(String input) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        logger.info("Page opened");
        logger.info("Start search with query - " + input);
        mainPage.makeSearch(input);
        logger.info("Search executed");
        logger.info("Get search results");
        List<WebElement> searchResults = driver.findElements(By.className("eMessage"));
        for (WebElement searchResult : searchResults) {
            if (!searchResult.getText().toLowerCase().contains(input.toLowerCase())) {
               return false;
            }
        }
        return true;
    }
    public boolean isNotEmptySearchResult(String input) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        logger.info("Page opened");
        logger.info("Start search with query - " + input);
        mainPage.makeSearch(input);
        logger.info("Get search results");
        List<WebElement> searchResults = driver.findElements(By.className("eMessage"));
        return !searchResults.isEmpty();
    }
    public boolean courseCountryExists(String countryName) {
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.openPage();
        logger.info("Page opened");
        logger.info("Get the list of course countries");
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
        logger.info("Page opened");
        logger.info("Get the list of course countries");
        List<WebElement> countryList = coursesPage.getAvailableCountries();
        return !countryList.isEmpty();
    }
}
