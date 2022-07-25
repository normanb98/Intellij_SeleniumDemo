Feature: Open new account on the XYZ Banking site

Scenario: User creates a new account

Given user is on bank manager page
When select Open Account
Then select Customer
Then select Currency
Then click Process
Then verify open account Chrome pop-up