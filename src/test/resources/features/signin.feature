@TescoTest
Feature: Sign in page

  Scenario: I click on 'Sign in' button login page appears
    Given I open Tesco website
    And I accept cookies
    When I click on Sign in button
    And I see login page
    And I input 'user123@mail.com' and 'password123'
    And I click on log in button
    Then I see an error