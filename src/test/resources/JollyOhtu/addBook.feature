Feature: As a user I want to be able to add book references

  Background: 
    Given Add book view is selected

  Scenario: User can create a book reference with valid mandatory fields
    When Valid mandatory book information is entered:
      | author    | Jonh Johnman     |
      | title     | Interesting Book |
      | year      | 1984             |
      | publisher | PaperPress       |
    And User presses button Add
    Then Message "Reference was saved succesfully!" is presented

  Scenario: User can create a book reference with valid mandatory and optional fields
    When Valid mandatory book information is entered:
      | author    | Jonh Johnman     |
      | title     | Interesting Book |
      | year      | 1985             |
      | publisher | PaperPress       |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | volume  | 1                |
      | series  | 12               |
      | address | Bakerstreet 1337 |
      | edition | 42               |
      | month   | 5                |
      | note    | smtn             |
    And User presses button Add
    Then Message "Reference was saved succesfully!" is presented

  Scenario: User cannot create a book reference if some of mandatory fields is empty
    When Mandatory book information with only author and title is entered:
      | author | Not a book       |
      | title  | Interesting Book |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create a book reference if all of the mandatory fields are empty
    When No mandatory book information is entered:
        |author||
        |title ||
        |year  ||
        |publisher||
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create a book reference with empty mandatory fields and valid optional fields
    When No mandatory book information is entered:
        |author||
        |title ||
        |year  ||
        |publisher||
    And Optional fields are chosen
    And Valid optional field information is entered:
      | volume  | 1                |
      | series  | 12               |
      | address | Bakerstreet 1337 |
      | edition | 42               |
      | month   | 5                |
      | note    | smtn             |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create a book reference with invalid month
    When Valid mandatory book information is entered:
        | author | test          |
        | title  | test          |
        | year   | 1337           |
        | publisher| test        |
    And Optional fields are chosen
    And Invalid optional field information is entered:
        | volume  | 1                |
      | series  | 12               |
      | address | Bakerstreet 1337 |
      | edition | 42               |
      | month   | 13               |
      | note    | smtn             |
    And User presses button Add
    Then Message "Invalid input. Check your input." is presented

  Scenario: User cannot create a book reference if reference already exists
    When Valid mandatory book information is entered:
        | author | testi          |
        | title  | testi          |
        | year   | 1337           |
        | publisher| testi        |
    And User presses button Add
    And Message "Reference was saved succesfully!" is presented
    And Valid mandatory book information is entered:
        | author | testi          |
        | title  | testi          |
        | year   | 1337           |
        | publisher| testi        |
    And User presses button Add
    Then Message "The book reference already exists." is presented