Feature: Change language
  Scenario: I change language from english to hungarian
Given I open Tesco website
And Language is set to english
When I change language to hungarian
Then Language is changed to hungarian