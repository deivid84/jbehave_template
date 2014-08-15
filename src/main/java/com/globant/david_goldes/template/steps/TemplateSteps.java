package com.globant.david_goldes.template.steps;

import java.util.Date;

import org.apache.commons.lang.IllegalClassException;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverPage;

import com.gargoylesoftware.htmlunit.PageCreator;
import com.globant.david_goldes.template.pages.AgeGate;
import com.globant.david_goldes.template.pages.BaseFluentPage;
import com.globant.david_goldes.template.pages.Home;
import com.globant.david_goldes.template.pages.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TemplateSteps {
    
	private final PageFactory pageFactory;
	private FluentWebDriverPage currentPage;           

    public TemplateSteps(PageFactory pageFactory){        
        this.pageFactory = pageFactory;
    }
      
    @Given("I am on budweisertours.com")
    public void goToHomePage (){
    	AgeGate ageGate = pageFactory.newAgeGate();
    	ageGate.go();
    	currentPage = ageGate;
    }
    
    @When("I enter date $month $day of $year")
    public void enterDate(String month, String day, String year) {
    	AgeGate ageGate = castCurrentPage(AgeGate.class);
    	currentPage = ageGate.selectBirthDate(month, day, year);
    }
    
    @When("I enter a legal age, $month $day of $year")
    @Composite(steps = {"When I enter date $month $day of $year"})
    public void enterLegalAge(String month, String day, String year) {    	
    }
    
    @When("I enter a non legal age, $month $day of $year")
    @Composite(steps = {"When I enter date $month $day of $year"})
    public void enterNonLegalAge(String month, String day, String year) {    	
    }
    
    @When("I enter an incorrect date, $month $day of $year")
    @Composite(steps = {"When I enter date $month $day of $year"})
    public void enterIncorrectDate(String month, String day, String year) {
    }
    
    @When("I enter a legal age, $month $day of $year , close the tab and enter the site again")
    @Composite(steps = { "When I enter a legal age, $month $day of $year",
    "When I close the tab and open a new one", "When I enter the site again" })
    public void enterSiteWithLegalAgeCloseAndReturn(){    	
    }
    
    @When("I close the tab and open a new one")
    public void closeAndOpenTab() {
    	BaseFluentPage basePage = castCurrentPage(BaseFluentPage.class);
    	basePage.openNewTabAndCloseCurrentTab();
    }
    
    @When("I enter the site again")
    public void enterSite() {
    	Home home = pageFactory.newHome();
    	home.go();
    	currentPage = home;
    }
    
    @When("I enter a legal age, $month $day of $year , close the browser, open another browser and enter the site again")
    @Composite(steps = {"When I enter a legal age, $month $day of $year", "When I close the browser", "When I open another browser", "When I enter the site again"})
    public void closeAndOpenBrowser(){    	
    }
    
    @When("When I close the browser")
    public void closeBroserWindow(){
    	
    }
    
    @Then("the main page will be displayed")
    public void isMainPage() {
    	Home home = castCurrentPage(Home.class);
    	assertThat(home.isHomePage(), Matchers.is(true));
    }
    
    @Then("an error will be displayed")
    public void errorDisplayed() {
    	AgeGate ageGate = castCurrentPage(AgeGate.class);
    	assertThat(ageGate.isErrorDisplayed("error"), Matchers.is(true));
    }
    
    private <T extends WebDriverPage> T castCurrentPage(Class<T> pageClass) {
        if (!pageClass.isAssignableFrom(this.currentPage.getClass())) {
            throw new IllegalClassException(this.currentPage.getClass(), pageClass);
        }
        return pageClass.cast(this.currentPage);
    }
}
