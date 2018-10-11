$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/InvalidLogin.feature");
formatter.feature({
  "name": "Invalid login function of www.heatclinic.com",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Testing the login functionality for invalid users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "name": "Invalid User opens browser",
  "keyword": "Given "
});
formatter.step({
  "name": "Invalid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.step({
  "name": "Invalid User enters \u003cusername\u003e as username",
  "keyword": "Then "
});
formatter.step({
  "name": "Invalid User enters \u003cpassword\u003e as password",
  "keyword": "Then "
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "\"moltenboy.robin@gmail.com\"",
        "\"123456789\""
      ]
    },
    {
      "cells": [
        "\"moltenboy@gmail.com\"",
        "\"A1234567@\""
      ]
    },
    {
      "cells": [
        "\"moltenboy@gmail.com\"",
        "\"\""
      ]
    },
    {
      "cells": [
        "\"\"",
        "\"A1234567@\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing the login functionality for invalid users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_goes_to_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.Invalidlogin.invalid_user_goes_to_website(Invalidlogin.java:26)\r\n\tat ✽.Invalid User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/InvalidLogin.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"moltenboy.robin@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"123456789\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Testing the login functionality for invalid users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_goes_to_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.Invalidlogin.invalid_user_goes_to_website(Invalidlogin.java:26)\r\n\tat ✽.Invalid User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/InvalidLogin.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"moltenboy@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"A1234567@\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Testing the login functionality for invalid users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_goes_to_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.Invalidlogin.invalid_user_goes_to_website(Invalidlogin.java:26)\r\n\tat ✽.Invalid User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/InvalidLogin.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"moltenboy@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Testing the login functionality for invalid users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_goes_to_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.Invalidlogin.invalid_user_goes_to_website(Invalidlogin.java:26)\r\n\tat ✽.Invalid User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/InvalidLogin.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User enters \"A1234567@\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/SearchTest.feature");
formatter.feature({
  "name": "Search function of www.heatclinic.com",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing the search functionality for valid users",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SanityTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Valid User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchWebsite.valid_User_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Valid User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "SearchWebsite.valid_User_goes_to_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.SearchWebsite.valid_User_goes_to_website(SearchWebsite.java:30)\r\n\tat ✽.Valid User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/SearchTest.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Valid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User enters usercredentials in login text fields",
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
  "location": "SearchWebsite.valid_User_enters_usercredentials_in_login_text_fields(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User is taken to member page",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_is_taken_to_member_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User enters text in search field",
  "rows": [
    {
      "cells": [
        "Search"
      ]
    },
    {
      "cells": [
        "sauce"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_enters_text_in_search_field(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User chooses the selection from search box field",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_chooses_the_selection_from_search_box_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User filters the selection by choosing price range",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_filters_the_selection_by_choosing_price_range()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User clicks on third selection from search result",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_clicks_on_third_selection_from_search_result()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User logouts",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_logouts()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Valid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchWebsite.valid_User_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/ValidLogin.feature");
formatter.feature({
  "name": "Login function test of www.heatclinic.com",
  "description": "Description: Test to check whether a user can follow the process to login and logout of Member Page.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User enters valids username and password to enter authorized login homepage",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@SmokeTest"
    },
    {
      "name": "@SanityTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User opens browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Validlogin.user_opens_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User goes to \"https://demo.broadleafcommerce.org/\" website",
  "keyword": "When "
});
formatter.match({
  "location": "Validlogin.user_goes_to_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.Validlogin.user_goes_to_website(Validlogin.java:28)\r\n\tat ✽.User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/ValidLogin.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters \"moltenboy.robin@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_enters_as_username(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters \"A1234567@\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_enters_as_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User is taken to member page",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_is_taken_to_member_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User logsout",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_logsout()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Validlogin.user_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/ValidUserCheckout.feature");
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
  "error_message": "java.lang.NullPointerException\r\n\tat com.heatclinic.pages.HomePage.delay(HomePage.java:69)\r\n\tat com.heatclinic.pages.HomePage.goToHomepage(HomePage.java:40)\r\n\tat com.heatclinic.steps.ValidCheckout.existing_Valid_User_goes_to_website(ValidCheckout.java:35)\r\n\tat ✽.Existing Valid User goes to \"https://demo.broadleafcommerce.org/\" website(I:/eclipse-workspace/heatclinic.bdd/src/main/resources/TestResource/Features/ValidUserCheckout.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Existing Valid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Existing Valid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_clicks_sign_in_link()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.step({
  "name": "Existing Valid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Existing Valid User is taken to member page",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.existing_Valid_User_is_taken_to_member_page()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User chooses the selection from search box field",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_chooses_the_selection_from_search_box_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User filters the selection by choosing price range",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_filters_the_selection_by_choosing_price_range()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User clicks on a selection from search result",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_clicks_on_a_selection_from_search_result()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User clicks add to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_clicks_add_to_cart()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User goes to view cart page",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_goes_to_view_cart_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User goes to checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_goes_to_checkout_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User increases the number of selected items to two and then decreases to one",
  "keyword": "And "
});
formatter.match({
  "location": "ValidCheckout.logged_in_user_increases_the_number_of_selected_items_to_two_and_then_decreases_to_one()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User clicks checkout button",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_clicks_checkout_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User fills in shipping information and clicks Continue",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_fills_in_shipping_information_and_clicks_Continue()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User fills in payment information",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_fills_in_payment_information()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User gets purchase confirmation notification",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_gets_purchase_confirmation_notification()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged in User logouts",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_in_User_logouts()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged out User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidCheckout.logged_out_User_closes_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});