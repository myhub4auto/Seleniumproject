Feature: smart bear application



Scenario Outline: Verify login with test data

Given i open the browser


Given i navigate the application "<url>"

When i enter username "<username>"

When i enter password "<password>"

When we click login

Then application should loginsuccessfully



Examples:

|url|username|password|
|http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx|Tester|test|



