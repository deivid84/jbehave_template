package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;

public class Home extends Header {

	private static final String URL = "http://www.cheaptickets.com";
	
    public Home(WebDriverProvider webDriverProvider, PageFactory pageFactory) {
        super(webDriverProvider, pageFactory);
    }

    public void go() {
        get(URL);
    }    
    
    public SignIn clickLogin() {
    	link(By.linkText("Sign in")).click();    	
    	return pageFactory.newSignIn();
    }
    
    public SignOut clickLogout() {    	
    	link(By.linkText("Sign out")).click();    	
    	return pageFactory.newSignOut();
    }       
}
