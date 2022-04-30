Feature: Login functionality of LeafTaps application
Scenario Outline: TC001_Login with valid credentials 
Given Open the Chrome browser
And Load the application url
And Enter the username as <username>
And Enter the password as <password>
When click on Login button
Then Homepage should be displayed
And CRM/SFA link is displayed

Examples: 
|username|password|
|'Demosalesmanager'|'crmsfa'|
|'Democsr'|'crmsfa'|


Scenario: TC001_Login with invalid credentials 
Given Open the Chrome browser
And Load the application url
And Enter the username as 'Demo'
And Enter the password as 'crmsfa'
When click on Login button
But Error message should be displayed
