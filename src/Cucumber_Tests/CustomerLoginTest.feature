Feature: Testing customer login

  Scenario: The user logs into the interface

    Given user is on home page
    When select Customer Login
    Then select Harry Potter
    Then verify the name