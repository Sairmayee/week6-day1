Feature: Create Lead functionality of Leaftaps application

Background:
Given Open the chrome browser
And Load the application url
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA and Leads


Scenario: TC003_Create new lead with mandatory information
When Click on Create Lead
Then Enter required details and click Submit

Scenario: TC004_Create duplicate lead with valid information
When Click on Find Lead
Then Enter Phone number and click Find Leads
When Select Lead and click Duplicate Lead button
Then Enter required details and click Submit

Scenario: TC005_Delete lead
When Click on Find Lead
Then Enter Phone number and click Find Leads
Then Select Lead and click Delete
When Find Leads
Then Error message should be displayed 

Scenario: TC006_Edit lead
When Click on Find Lead
Then Enter Phone number and click Find Leads
Then Select Lead and click Edit
Then Edit details and submit


