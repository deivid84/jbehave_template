Access Budweiser

Meta:
@category browsing
@color red


Narrative: 

In order to acces the Budweiser site
As a user
I need to provide a legal age

Scenario: Accessing the Budweiser Age Gate with a legal age, closing the tab and reentering the site

Given I am on budweisertours.com
When I enter a legal age, close the tab and enter the site again
Then the main page will be displayed