Feature: User Registration testing

  @regression
  Scenario: Successfull Registration of each user
    Given Navigatio to Registration page
    When User need to fill all the mandatory filed with below values
    |	firstName	| Shaik					|
    |	lastName	| Khan					|
    |	telephone	|	746345338738	|
    |	password	|	Welcome@123		|

    And user should enable privacy policy
    And user should click on continue button
    Then user account should get created successfully