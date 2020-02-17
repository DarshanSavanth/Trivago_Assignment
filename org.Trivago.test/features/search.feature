#Author: Darshan Savanth
#Feature: Trivago standard search scenarios
#Background: List of steps run before each of the scenarios
@tag 
Feature: Standard search 
	To check that the user is able to use the standard search feature of Trivago, view the results and navigate to appropriate hotel booking page

Background: 
	Given User has navigated to Trivago website 
 	When User provides input of place and type
	And Clicks on the search button
	Then User is redirected to the search results page 
	
@tag1 
Scenario: As a user, he/she should be able to filter the results based on choices 
	Given User is on the search results page 
	When chooses for custom applied filters
	And clicks on Done button
	And user sorts the results by price only
	Then User sees the relevant recommendations   