package com.haritonova.automation.pages;

import org.openqa.selenium.WebDriver;

/**
 * @author Veronica_Haritonova
 */
 public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
