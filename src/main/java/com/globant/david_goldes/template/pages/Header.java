package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Header extends BaseFluentPage{

	public Header(WebDriverProvider webDriverProvider, PageFactory pageFactory) {
        super(webDriverProvider, pageFactory);
    }
	
	public boolean isUserLoggedIn() {
    	return isElementPresent(By.linkText("Sign out"));
    }
	
	public boolean isUserLoggedOut(){
		waitForElementToBePresent(By.linkText("Sign in"), 10);
		return isElementPresent(By.linkText("Sign in"));			
	}
}
