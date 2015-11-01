package com.haritonova.automation;

import com.haritonova.automation.steps.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Veronica_Haritonova
 */
public class AutomationTest {
    private Steps steps;

    @Before
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @After
    public void stopBrowser()
    {
        steps.closeDriver();
    }

    @Test
    public void testTranslation() {
        String word = "sonne";
        String expectedTranslation = "солнце";
        assertEquals("Translation is incorrect", expectedTranslation, steps.translateWord(word));
    }

    @Test
    public void testSearchTitle() {
        String input = "text";
        assertTrue("Title of search is incorrect", steps.getSearchTitle(input).contains(input));
    }

    @Test
    public void testSearchResults() {
        String input = "text";
        assertTrue("Incorrect search results", steps.searchResultsContainsInput(input));
    }

    @Test
    public void testCoursesPage() {
        String countryName = "Германия";
        assertTrue("Incorrect courses list", steps.courseCounrtyExists(countryName));
    }

    @Test
    public void testNotEmptyCoursesList() {
        assertTrue("Empty courses list", steps.isNotEmptyCourseCountriesList());
    }
}
