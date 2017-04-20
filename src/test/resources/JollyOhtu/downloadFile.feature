
Feature: As a user I want to be able to download references in a file
  

  Scenario: Can download file
    Given Download file view has been selected
    And File name "test" is entered
    When I press Generate file button
    Then the file is downloaded

    
