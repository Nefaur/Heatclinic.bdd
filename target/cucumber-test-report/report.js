$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/TestResource/Features/ValidUserCheckout.feature");
formatter.feature({
  "name": "Checkout page function of www.heatclinic.com",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing the checkout page functionality for valid users",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SanityTest"
    },
    {
      "name": "@End2EndTests"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_goes_to_website(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_clicks_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User enters username and password in login text fields",
  "rows": [
    {
      "cells": [
        "moltenboy.robin@gmail.com",
        "A1234567@"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_enters_username_and_password_in_login_text_fields(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User is taken to member page",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_is_taken_to_member_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Existing Valid User enters text in search field",
  "rows": [
    {
      "cells": [
        "Search"
      ]
    },
    {
      "cells": [
        "Hot"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_enters_text_in_search_field(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User chooses the selection from search box field",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_chooses_the_selection_from_search_box_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User filters the selection by choosing price range",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_filters_the_selection_by_choosing_price_range()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User clicks on a selection from search result",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_clicks_on_a_selection_from_search_result()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User clicks add to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_clicks_add_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User goes to view cart page",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_goes_to_view_cart_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User goes to checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_goes_to_checkout_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User increases the number of selected items to two and then decreases to one",
  "keyword": "And "
});
formatter.match({
  "location": "ValidCheckout.logged_in_user_increases_the_number_of_selected_items_to_two_and_then_decreases_to_one()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User clicks checkout button",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_clicks_checkout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User fills in shipping information and clicks Continue",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_fills_in_shipping_information_and_clicks_Continue()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User fills in payment information",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_fills_in_payment_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User gets purchase confirmation notification",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_gets_purchase_confirmation_notification()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged in User logouts",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_logouts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logged out User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_out_User_closes_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});