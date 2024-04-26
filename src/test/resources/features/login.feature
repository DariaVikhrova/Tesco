Feature: Login Page
  Scenario: I click on 'Sign in' button login page appears
    Given I open Tesco website
    When I click on Sign in button
    Then I see login page with an error