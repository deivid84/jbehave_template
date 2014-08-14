package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;
import static org.seleniumhq.selenium.fluent.Period.secs;

public class Home extends BaseFluentPage {

	private static final String URL = "http://www.budweisertours.com/";
	
    public Home(WebDriverProvider webDriverProvider, PageFactory pageFactory) {
        super(webDriverProvider, pageFactory);
    }

    public void go() {
        get(URL);
    }
    
    public boolean isHomePage() {    	    	
    	return getTitle().equals("Budweiser Tours");     	
    }
}
