Feature: As a user I want to be able to add article references

  Background: 
    Given Add article view is selected

  Scenario: User can create an article reference with valid mandatory fields
    When Valid mandatory article information is entered:
      | author  | Writer von Articlesen |
      | title   | Groundbreaking stuff  |
      | journal | Unnaturell            |
      | year    | 1969                  |
      | volume  | 42                    |
    And User presses button Add
    Then Message "Reference was saved succesfully!" is presented

  Scenario: User can create an article reference with valid mandatory fields and optional fields
    When Valid mandatory article information is entered:
      | author  | Johnny Extra |
      | title   | Super long   |
      | journal | Measure      |
      | year    | 2013         |
      | volume  | 872          |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | number | 43      |
      | pages  | 9001    |
      | month  | 11      |
      | note   | nothing |
    And User presses button Add
    Then Message "Reference was saved succesfully!" is presented

  Scenario: User cannot create an article reference if some of mandatory fields is empty
    When Mandatory article information with only author and title is entered:
      | author | Not an article |
      | title  | Lol            |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented
