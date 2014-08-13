package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class AgeGate extends FluentWebDriverPage{

	public AgeGate (WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }
	
	public void go() {
        get("http://www.budweisertours.com/");
    }
	
	public void enterLegalAge(){	
		input(By.name("xmonth")).sendKeys("09");
		input(By.name("xday")).sendKeys("14");
		input(By.name("xyear")).sendKeys("84");	
		button(By.id("enter-btn")).submit();
	}
}
