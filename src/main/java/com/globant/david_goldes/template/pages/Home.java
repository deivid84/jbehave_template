package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;
import static org.seleniumhq.selenium.fluent.Period.secs;

public class Home extends FluentWebDriverPage {

    public Home(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void go() {
        get("http://www.etsy.com");
    }

    public void go(String section) {
        go();
        link(xpath("@title = '" + section + "'")).click();
    }

    public void search(String thing) {
        input(id("search-query")).sendKeys(thing);
        button(id("search_submit")).click();
    }

    public void goToBuySection() {
        link(linkText("Buy")).click();
    }
    
    public boolean isHomePage() {    	    	
    	return getTitle().equals("Budweiser Tours");     	
    }
}
