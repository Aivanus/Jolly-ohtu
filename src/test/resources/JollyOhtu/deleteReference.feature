Feature: User can delete references

  Scenario: User can delete a book reference
    Given Book reference is successfully created with following fields:
      | author    | DeleteThis1          |
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
      And Checkbox next to the book with title "InterestingBook76234" is selected
And User presses button Delete Selected for books
Then Message "One book reference was deleted succesfully." is presented
But Row with ID "callID3DELBOOK" should not be visible