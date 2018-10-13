Feature: Login function test of www.heatclinic.com 
	Description: Test to check whether a user can follow the process to login and logout of Member Page.

@FunctionalTest 
@SmokeTest 
@SanityTest 
Scenario:
User enters valids username and password to enter authorized login homepage 

	Given User opens browser 
	When User goes to "https://demo.broadleafcommerce.org/" website 
	Then User hovers to sign_in_link 
	Then User clicks sign_in_link 
	Then User enters "moltenboy.robin@gmail.com" as username 
	Then User enters "A1234567@" as password 
	Then User clicks on submit button 
	Then User is taken to member page 
	Then User logsout 
	Then User closes browser