Feature: As a user I want to be able to add book references

  Scenario: User can create a book reference with valid mandatory fields
    Given Add book view is selected
    When Valid mandatory book information is entered:
      | author    | Jonh Johnman     |
      | title     | Interesting Book |
      | year      | 1984             |
      | publisher | PaperPress       |
    Then new book reference is created
