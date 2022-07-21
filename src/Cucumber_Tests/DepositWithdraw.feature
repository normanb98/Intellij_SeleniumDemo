Feature: Deposit Withdraw on the XYZ Banking site

Scenario: User deposits and withdraws money

Given user is on logged in customer page
Then deposit money
Then withdraw money
Then verify money