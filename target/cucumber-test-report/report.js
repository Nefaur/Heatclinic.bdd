$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/TestResource/Features/Invalidlogin.feature");
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
  "status": "passed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"moltenboy.robin@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"123456789\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "passed"
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
  "status": "passed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"moltenboy@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"A1234567@\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "passed"
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
  "status": "passed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"moltenboy@gmail.com\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "passed"
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
  "status": "passed"
});
formatter.step({
  "name": "Invalid User hovers to sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_hovers_to_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks sign_in_link",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_clicks_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"\" as username",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_username(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User enters \"A1234567@\" as password",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_enters_as_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User clicks on submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_User_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User gets failed login message",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_gets_failed_login_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid User closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Invalidlogin.invalid_user_closes_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});