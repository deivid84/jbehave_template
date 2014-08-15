package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class SignIn extends BaseFluentPage{

	
	public SignIn(WebDriverProvider webDriverProvider, PageFactory pageFactory){
		super(webDriverProvider, pageFactory);
	}
	
	public BaseFluentPage fillForm(String email, String pass) {
		waitForElementToBePresent(By.cssSelector("[type='email']"), 10);
		input(By.cssSelector("[type='email']")).sendKeys(email);
		input(By.cssSelector("[type='password']")).sendKeys(pass);
		input(By.name("_eventId_submit")).click();
		if(isElementPresent(By.className("error")))
			return pageFactory.newSignIn();
		else
			return pageFactory.newHome();
	}
}
