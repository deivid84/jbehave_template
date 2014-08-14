package com.globant.david_goldes.template.browser_manager;

import org.jbehave.web.selenium.WebDriverProvider;

import com.globant.david_goldes.template.pages.PageFactory;

public class BrowserManager {
	
	private final PageFactory pageFactory;
	private final WebDriverProvider webDriverProvider;
	
	public BrowserManager(WebDriverProvider webDriverProvider, PageFactory pageFactory){
		this.pageFactory = pageFactory;
		this.webDriverProvider = webDriverProvider;
	}
	
	
}
