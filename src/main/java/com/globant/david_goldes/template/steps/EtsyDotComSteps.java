package com.globant.david_goldes.template.steps;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import com.globant.david_goldes.template.pages.Home;
import com.globant.david_goldes.template.pages.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;

public class EtsyDotComSteps {
    
    private Home home;    

    private String justBought = "";

    public EtsyDotComSteps(PageFactory pageFactory){        
        home = pageFactory.newHome();        
    }        
}
