#Feature: XYZ Banking site tests
#
#  Scenario: User creates a new customer
#
#    Given user is on home page
#    When select Bank manager login
#    When select Add customer
#    Then add First name
#    Then add last name
#    Then add Post code
#    Then click Add customer
#    Then verify new customer Chrome pop-up
#
#  Scenario: User creates a new account
#
#    Given user is on bank manager page
#    When select Open Account
#    Then select Customer
#    Then select Currency
#    Then click Process
#    Then verify open account Chrome pop-up
#
#  Scenario: User logs in as customer
#
#    Given user is on login page
#    When select Customer Login
#    Then select Name
#    Then verify login
#
#  Scenario: User deposits and withdraws money
#
#    Given user is on logged in customer page
#    Then deposit money
#    Then withdraw money
#    Then verify money