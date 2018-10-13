Feature: Checkout page function of www.heatclinic.com 

@SanityTest 
@End2EndTests 
Scenario: Testing the checkout page functionality for valid users 

	Given Existing Valid User opens browser 
	When Existing Valid User goes to "https://demo.broadleafcommerce.org/" website 
	Then Existing Valid User hovers to sign_in_link 
	Then Existing Valid User clicks sign_in_link 
	Then Existing Valid User enters username and password in login text fields 
		|moltenboy.robin@gmail.com|A1234567@|
	Then Existing Valid User clicks on submit button 
	Then Existing Valid User is taken to member page 
	Then Existing Valid User enters text in search field 
		|Search|
		|Hot|
	Then Logged in User chooses the selection from search box field 
	Then Logged in User filters the selection by choosing price range 
	Then Logged in User clicks on a selection from search result 
	Then Logged in User clicks add to cart 
	Then Logged in User goes to view cart page 
	Then Logged in User goes to checkout page 
	And Logged in User increases the number of selected items to two and then decreases to one 
	Then Logged in User clicks checkout button 
	Then Logged in User fills in shipping information and clicks Continue 
	Then Logged in User fills in payment information 
	Then Logged in User gets purchase confirmation notification 
	Then Logged in User logouts 
	Then Logged out User closes browser