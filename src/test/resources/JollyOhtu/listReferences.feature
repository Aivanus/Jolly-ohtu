Feature: As a user I want to be able to list all the references

  Scenario: List view exists
    Given List view is selected
    Then List view is shown

  Scenario: Book reference is visible after successful reference creation
    Given Book reference is successfully created with following fields:
      | callId    | callID2LVBook       |
      | author    | Jonh Jon            |
      | title     | Interesting Book 76 |
      | year      | 1977                |
      | publisher | PaperPresser        |
      | volume    | 11                  |
      | series    | 1                   |
      | address   | Bakerstreet 13      |
      | edition   | 52                  |
      | month     | 1                   |
      | note      | ListViewBookTest    |
    When List view is selected
    Then Book reference row should be visible with following fields:
      | callID2LVBook       |
      | Jonh Jon            |
      | Interesting Book 76 |
      | 1977                |
      | PaperPresser        |
      | 11                  |
      | 1                   |
      | Bakerstreet 13      |
      | 52                  |
      | 1                   |
      | ListViewBookTest    |
