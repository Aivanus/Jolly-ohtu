Feature: As a user I want to be able to add book references

  Scenario: User can create a book reference
    Given Add book view is selected
    When Valid book author "Writer", title "Interesting Book", year 1984 and publisher "PaperPress" are given
    Then new book reference is created