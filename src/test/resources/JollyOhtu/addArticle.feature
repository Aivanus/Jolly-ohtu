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
      | callId | CallId |
      | number | 43      |
      | pages  | 9001    |
      | month  | 1       |
      | note   | nothing |
    And User presses button Add
    Then Message "Reference was saved succesfully!" is presented

  Scenario: User cannot create an article reference if some of mandatory fields is empty
    When Mandatory article information with only author and title is entered:
      | author | Not an article |
      | title  | Lol            |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create an article reference if all of the mandatory fields are empty
    When No mandatory article information is entered:
      | author  |  |
      | title   |  |
      | journal |  |
      | year    |  |
      | volume  |  |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create an article reference with empty mandatory fields and valid optional fields
    When No mandatory article information is entered:
      | author  |  |
      | title   |  |
      | journal |  |
      | year    |  |
      | volume  |  |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId | CallId2  |
      | number | 1        |
      | pages  | 12       |
      | month  | 1        |
      | note   | smtn     |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create an article reference with invalid month
    When Valid mandatory article information is entered:
      | author  | test    |
      | title   | test    | 
      | journal | test    |
      | year    | 1337    |
      | volume  | 12      |
    And Optional fields are chosen
    And Invalid optional field information is entered:
      | callId | CallId3  |
      | number | 1        |
      | pages  | 12       |
      | month  | 13       |
      | note   | smtn     |
    And User presses button Add
    Then Message "Invalid input. Check your input." is presented

  Scenario: User cannot create an article reference if reference already exists
    When Valid mandatory article information is entered:
      | author  | author5  |
      | title   | title5   |
      | journal | journal5 |
      | year    | 2001     |
      | volume  | 12       |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId | CallId4  |
      | number | 1        |
      | pages  | 12       |
      | month  | 12       |
      | note   | smtn     |
    And User presses button Add
    And Message "Reference was saved succesfully!" is presented
    And Valid mandatory article information is entered:
      | author  | author5  |  
      | title   | title5   |
      | journal | journal5 |
      | year    | 2001     |
      | volume  | 12       |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId | CallId5  |
      | number | 1        |
      | pages  | 12       |
      | month  | 12       |
      | note   | smtn     |
    And User presses button Add
    Then Message "The article reference already exists with the ID: CallId4." is presented
