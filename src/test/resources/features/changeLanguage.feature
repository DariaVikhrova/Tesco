Feature: Change language
  @TescoTest
  Scenario: I change language from english to hungarian
    Given I open Tesco website
    And I accept cookies
    And Language is set to english
    When I change language to hungarian
    Then Language is changed to hungarian