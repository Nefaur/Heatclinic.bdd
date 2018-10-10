Feature: Search function of www.heatclinic.com

 
@FunctionalTest @SanityTest
Scenario: Testing the search functionality for valid users

Given Valid User opens browser
When Valid User goes to "https://demo.broadleafcommerce.org/" website
Then Valid User hovers to sign_in_link
Then Valid User clicks sign_in_link
Then Valid User enters usercredentials in login text fields
|moltenboy.robin@gmail.com|A1234567@|
Then Valid User clicks on submit button
Then Valid User is taken to member page
Then Valid User enters text in search field
|Search|
|sauce|
Then Valid User chooses the selection from search box field
Then Valid User filters the selection by choosing price range
Then Valid User clicks on third selection from search result
Then Valid User logouts
Then Valid User closes browser