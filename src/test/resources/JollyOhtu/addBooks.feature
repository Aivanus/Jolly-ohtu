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
    Then new book reference is created

  Scenario: User can create a book reference with valid mandatory and optional fields
    When Valid mandatory book information is entered:
      | author    | Jonh Johnman     |
      | title     | Interesting Book |
      | year      | 1984             |
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
    Then new book reference is created
