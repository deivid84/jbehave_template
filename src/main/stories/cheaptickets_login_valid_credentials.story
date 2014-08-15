Login to Cheaptickets.com

Meta:
@category advanced
@color red

Narrative: 

In order to login
As a user
I have to provide my credentials

Scenario: Login to site with valid credentials

Given I am browsing Cheaptickets.com
When I select the login option
And I fill the login form with my email test22@test.com and password 123456
Then the login will be succesful