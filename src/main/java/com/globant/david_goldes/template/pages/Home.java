package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;

public class Home extends FluentWebDriverPage {

	private static final String URL = "http://www.etsy.com";
	
    public Home(WebDriverProvider webDriverProvider, PageFactory pageFactory) {
        super(webDriverProvider);
    }

    public void go() {
        get(URL);
    }    
}
