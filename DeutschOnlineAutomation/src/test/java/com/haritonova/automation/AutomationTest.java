package com.haritonova.automation;

import com.haritonova.automation.steps.Steps;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Veronica_Haritonova
 */
public class AutomationTest {
    Logger logger = Logger.getLogger(AutomationTest.class);
    private Steps steps;

    @Before
    public void setUp()
    {
        logger.info("Setting parameters");
        steps = new Steps();
        steps.initBrowser();
    }

    @After
    public void stopBrowser()
    {
        logger.info("Test stopped");
        steps.closeDriver();
    }

    @Test
    public void testTranslation() {
        logger.info("Test: check translation");
        String word = "sonne";
        String expectedTranslation = "солнце";
        assertTrue("Translation is incorrect", steps.translateWord(word).contains(expectedTranslation));
    }

    @Test
    public void testSearchTitle() {
        logger.info("Test: check the correct search tittle");
        String input = "text";
        assertTrue("Title of search is incorrect", steps.getSearchTitle(input).contains(input));
    }

    @Test
    public void testSearchResults() {
        logger.info("Test: check the correct search result");
        String input = "text";
        assertTrue("Incorrect search results", steps.searchResultsContainsInput(input));
    }

    @Test
    public void testCoursesPage() {
        logger.info("Test: check the existence of country on courses page");
        String countryName = "Германия";
        assertTrue("Incorrect courses list", steps.courseCounrtyExists(countryName));
    }

    @Test
    public void testNotEmptyCoursesList() {
        logger.info("Test: check courses list");
        assertTrue("Empty courses list", steps.isNotEmptyCourseCountriesList());
    }
}
