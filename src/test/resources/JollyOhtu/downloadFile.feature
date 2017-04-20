
Feature: As a user I want to be able to download references in a file
  

  Scenario: Can download file
    Given Download file view has been selected
    When File name "test" is entered
    And I press Generate file button
    Then the file is downloaded