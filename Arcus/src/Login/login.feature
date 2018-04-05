Feature: Arcus HIS
 
  Scenario Outline: Arcus login
  
Given i open the browser


Given i navigate the application "<url>"

When i enter username "<username>"

When i enter password "<password>"

When we click login

Then application should loginsuccessfully


 
 Examples: 
|url|username|password|
|https://192.168.1.52:8080/#!/authentication/login|admin|beacon@123|
