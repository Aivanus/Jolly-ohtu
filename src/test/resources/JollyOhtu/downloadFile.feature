
Feature: As a user I want to be able to download references in a file
  

  Scenario: Can download file
    Given Download file view has been selected
<<<<<<< HEAD
    And File name "test" is entered
    When I press Generate file button
=======
    When File name "test" is entered
    And I press Generate file button
>>>>>>> topi
    Then the file is downloaded

    
