
Feature: As a user I want to be able to list all the references
  
Background:
Given I am on the front page

  Scenario: Add two numbers
    When I press the List references button
    Then the result should be "Test" on the screen
    