package com.globant.david_goldes.template.steps;

import org.apache.commons.lang.IllegalClassException;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverPage;

import com.globant.david_goldes.template.pages.Header;
import com.globant.david_goldes.template.pages.Home;
import com.globant.david_goldes.template.pages.PageFactory;
import com.globant.david_goldes.template.pages.SignIn;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TemplateSteps {
        
    private final PageFactory pageFactory;
    private FluentWebDriverPage currentPage;

    public TemplateSteps(PageFactory pageFactory){        
        this.pageFactory = pageFactory;           
    }  
    
    @Given("I am browsing Cheaptickets.com")
    public void goToHomePage (){
    	Home home = pageFactory.newHome();
    	home.go();
    	currentPage = home;
    }
    
    @When("I select the login option")
    public void selectLoginOption() {
    	Home home = castCurrentPage(Home.class);
    	currentPage = home.clickLogin();
    }
    
    @When("I select the logout option")
    public void selectLogoutOption() {
    	Home home = castCurrentPage(Home.class);
    	currentPage = home.clickLogout();
    }
    
    @When("I fill the login form with my email $email and password $pass")
    @Aliases(values= {"I fill the login form with a wrong email $email and password $pass",
    				  "I fill the login form with my email $email and wrong password $pass"})
    public void fillLoginForm(String email, String pass) {
    	SignIn signIn = castCurrentPage(SignIn.class);
    	currentPage = signIn.fillForm(email, pass);
    }
    
    @Then("the login will be succesful")
    public void isLoginSuccesful() {
    	Header header = castCurrentPage(Header.class);
    	assertThat(header.isUserLoggedIn(), Matchers.is(true));
    }
    
    @Then("the login will be unsuccesful")
    @Alias("I should be logged out")
    public void isLoginUnsuccesful() {
    	Header header = castCurrentPage(Header.class);
    	assertThat(header.isUserLoggedOut(), Matchers.is(true));
    }
    
    private <T extends WebDriverPage> T castCurrentPage(Class<T> pageClass) {
        if (!pageClass.isAssignableFrom(this.currentPage.getClass())) {
            throw new IllegalClassException(this.currentPage.getClass(), pageClass);
        }
        return pageClass.cast(this.currentPage);
    }
}
