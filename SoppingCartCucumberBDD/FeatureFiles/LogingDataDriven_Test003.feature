Feature: Loging application by using Excel Data driven test

  Scenario Outline: Loging with various credintials
    Given the user navigates to login page
    Then user should successfull loged in with excel data "<row_index>"

    Examples: row_index
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |