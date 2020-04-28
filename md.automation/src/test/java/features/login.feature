Feature: Login to ECP

   As a user I should be able to login to the ECP application
   
 Background: common login steps
 Given the user is launch the ECP application

@Regression
Scenario: Validate ECP login with valid credentials
    When User navigate to login Page
    Then the user enters valid userName and Password
    And the user click on Login button
    When User navigate to ECP home page
   
@Smoke
Scenario: Validate ECP login with valid credentials
    When User navigate to login Page
    Then the user enters below userName and Password
    |UserName |Password |
    |mohan.sridhar@lavu.com |Testing@1234|
    And the user click on Login button
    When User navigate to ECP home page
 
@Regression   
Scenario Outline: Validate ECP login with different data sets
    When User navigate to login Page
    Then the user enters "<UserName>" and "<Password>"
    And the user click on Login button
    When User navigate to ECP home page
    Examples:
    |UserName 								|Password 		|
    |mohan.sridhar@lavu.com 	|Testing@1234	|
    |mohan.sridhar@lavu.com 	|Testing@1234	|