Feature: Mobile app navigation testing

  Background: App is open
    Given I open Onliner app on mobile device

  # As a user
  # I want login in the mobile app
  Scenario: Log In in the app
    Given I open logIn menu
    When I enter login "test.test33@mail.ru", password "Qwerty1234" and click enter button
    Then I see button logOut
    And I close app

  # As a user
  # I want to logout
  Scenario: Log Out in the app
  	Given I open menu
    And I click button logOut
    Then I see button login
    And I close app
    
  # As a user
  # I entering invalid credentials and see error message
  Scenario: Log In in the app
    Given I open logIn menu
    When I enter login "test@mail.ru", password "Qwerty1234" and click enter button
    Then I see error message
    And I close app