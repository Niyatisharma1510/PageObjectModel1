
Feature: Register

  @register
  Scenario: As a user, I should able to register successfully

    Given I am on Nopecommerce HomePage
    When I click on Register button
    And I enter all required registration details
    Then I should able to register successfully