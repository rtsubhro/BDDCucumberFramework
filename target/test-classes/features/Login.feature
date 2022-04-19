Feature: Application Login Feature
 
 @LoginTest
 Scenario: User Login Scenario
 	Given User Has Clicked the Login button on the Home Page
 	And Has Landed on the Login page
 	And The Page Title is Cogmento CRM
 	When The User Enters the Email Address
 	And The User Enters the Password
 	And The User Clicks the Login button
 	Then The User Navigates to the User Profile Page
 
 @LoginTest
 Scenario: Duplicate Email Scenario
 	Given User Has Clicked the Sign Up button on the Home Page
 	And Has Landed on the User Registration Page
 	And User fills up the SignUp form
 	And User Clicks the SignUp Submit button
 	Then Application Displays Already Registered Email Message
 	And Application Navigates to Reset Password Page

 	 


