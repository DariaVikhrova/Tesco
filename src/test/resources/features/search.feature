@TescoTest
Feature: Search for an item

  Scenario: I search for a cream
    Given I open Tesco website
    And I accept cookies
    When I input "cream" in search field
    And I click on the search button
    Then I see the page with the word "cream"