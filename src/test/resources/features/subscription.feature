Feature: Choose membership tariff
  Scenario: I choose membership tariff option for one year
    Given I open Tesco website
    When I click on Online club
    And Click on radio button
    And Click on Start trial
    Then I see login page with an error