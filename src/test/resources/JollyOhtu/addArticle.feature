Feature: As a user I want to be able to add article references

  Background: 
    Given Add article view is selected

  Scenario: User can create an article reference with valid mandatory fields
    When Valid mandatory article information is entered:
      | author  | Jonh Johnman     |
      | title   | Interesting Book |
      | journal | Unnature         |
      | year    | 1984             |
      | volume  | 42               |
    And User presses button Add
    Then Message "Reference was saved succesfully!" is presented
