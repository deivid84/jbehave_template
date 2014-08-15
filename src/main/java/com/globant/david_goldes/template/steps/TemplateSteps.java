package com.globant.david_goldes.template.steps;

import org.apache.commons.lang.IllegalClassException;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverPage;

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
    
    @Given("Go to home page")
    public void goToHomePage (){
    	Home home = pageFactory.newHome();
    	home.go();
    	currentPage = home;
    }
    
    private <T extends WebDriverPage> T castCurrentPage(Class<T> pageClass) {
        if (!pageClass.isAssignableFrom(this.currentPage.getClass())) {
            throw new IllegalClassException(this.currentPage.getClass(), pageClass);
        }
        return pageClass.cast(this.currentPage);
    }
}
