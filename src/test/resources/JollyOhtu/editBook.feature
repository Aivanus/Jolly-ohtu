Feature: As a user I want to be able to edit book references

  Scenario: User can edit an book reference
    Given Book reference is successfully created with following fields:
      | author    | author          |
      | title     | InterestingBook76234 |
      | publisher | PaperPresser23       |
      | year      | 1977                 |
      | callId    | callID3DELBOOK       |
      | volume    | 11                   |
      | series    | 1                    |
      | address   | Bakerstreet13asdf    |
      | edition   | 52                   |
      | month     | 1                    |
      | note      | DeleteOneBookTest    |
    When List view is selected
    And Edit button is pressed
    And User enters edited information as following:
      | title | edited title |
    And Update button is pressed
    Then Message "Reference was updated successfully!" is presented
    But Title has been changed to "edited title"
