package com.globant.david_goldes.template.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentMatcher;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;
import org.seleniumhq.selenium.fluent.TestableString;

public class AgeGate extends BaseFluentPage{

	private static final String URL = "http://www.budweiser.com/";
	private static final String UNDER21YEARS_ERROR = "Sorry, you must be 21 or older to view this site";
	private static final String INVALIDYEAR_ERROR = "Sorry, you have entered an invalid date";
	public AgeGate (WebDriverProvider webDriverProvider, PageFactory pageFactory) {
        super(webDriverProvider, pageFactory);
    }
	
	public void go() {
        get(URL);
    }
	
	public BaseFluentPage selectBirthDate(String month, String day, String year){
		selectMonth(month);
		selectDay(day);
		selectYear(year);
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("progressStatus")));
		if(isElementPresent(By.id("content-placeholder"))){
			return pageFactory.newAgeGate();
		} else {
			return pageFactory.newHome();
		}
		
	}
	
	public void selectMonth(String month){
		FluentWebElements months = ul(By.id("age-list-months")).lis();
		for(FluentWebElement e : months){
			if(e.getText().toString().equals(months)){
				e.click();				
				break;
			}
		}
	}
	
	public void selectDay(String day){
		FluentWebElements days = ul(By.id("age-list-days")).lis();
		for(FluentWebElement e : days){
			if(e.getText().toString().equals(day)){
				e.click();				
				break;
			}
		}
	}
	
	public void selectYear(String year){
		FluentWebElements years = ul(By.className("age-year")).lis();
		for(FluentWebElement e : years){
			if(e.getText().toString().equals(year)){
				e.click();
				break;
			}
		}
	}
	
	public boolean isErrorDisplayed(String error){
		return div(By.id("content-placeholder")).getText().toString().equals(error);
	}
}
