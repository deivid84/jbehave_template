package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseFluentPage extends FluentWebDriverPage {
    
    protected final PageFactory pageFactory;

    public BaseFluentPage(WebDriverProvider driverProvider, PageFactory pageFactory) {
        super(driverProvider);
        this.pageFactory = pageFactory;
    }
    
    public void openNewTabAndCloseCurrentTab(){
    	WebElement body = findElement(By.tagName("body")); 
    	body.sendKeys(Keys.CONTROL + "t");
    	body.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB));
    	body.sendKeys(Keys.CONTROL + "w");
    }

    protected boolean isElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), 1);
	    try {
		    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    } catch (TimeoutException timeOutException) {
	    	return false;
	    }
	    return true;
    }
}
