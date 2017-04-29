Feature: As a user I want to be able to edit article references

  Scenario: User can edit an article reference
    Given Article reference is successfully created with following fields:
      | callId  | CallID3DELETEARTICLE |
      | author  | DarthnotVaderasfdasf |
      | title   | title                |
      | journal | Measuresasfd234      |
      | year    | 2014                 |
      | volume  | 87                   |
      | number  | 4                    |
      | pages   | 901                  |
      | month   | 1                    |
      | note    | EditArticleTest      |
    When List view is selected
    And Edit button is pressed
    And User enters edited information as following:
      | title | edited title |
    And Update button is pressed
    Then Message "Reference was updated successfully!" is presented
    But Title has been changed to "edited title"
