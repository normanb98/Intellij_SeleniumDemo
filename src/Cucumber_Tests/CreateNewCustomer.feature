Feature: Creates new customer on the XYZ Banking site

  Scenario: User creates a new login

    Given user is on home Page
    When select Bank manager login
    When select Add customer
    Then add First name
    Then add last name
    Then add Post code
    Then click Add customer
    Then verify new customer Chrome pop-up