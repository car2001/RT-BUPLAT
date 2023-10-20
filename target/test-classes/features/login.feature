Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And  click on login button
    Then user is navigated to the applications home