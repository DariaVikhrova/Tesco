Feature: Choosing categories
  @TescoTest
  Scenario: I check the list of the products under groceries
    Given I open Tesco website
    And I accept cookies
    When I choose categories
    Then I see product list