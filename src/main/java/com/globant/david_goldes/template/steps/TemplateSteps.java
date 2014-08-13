package com.globant.david_goldes.template.steps;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.globant.david_goldes.template.pages.AgeGate;
import com.globant.david_goldes.template.pages.Home;
import com.globant.david_goldes.template.pages.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TemplateSteps {
    
    private Home home;
    private AgeGate ageGate;        

    public TemplateSteps(PageFactory pageFactory){        
        home = pageFactory.newHome();
        ageGate = pageFactory.newAgeGate();
    }
      
    @Given("I am on budweisertours.com")
    public void goToHomePage (){
    	ageGate.go();
    }
    
    @When("I enter a legal age")
    public void enterLegalAge() {
    	ageGate.enterLegalAge();
    }
    
    @Then("the main page will be displayed")
    public void isMainPage() {
    	assertThat(home.isHomePage(), Matchers.is(true));
    }
}
