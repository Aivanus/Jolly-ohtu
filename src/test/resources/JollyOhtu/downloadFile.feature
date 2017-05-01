Feature: As a user I want to be able to download references in a file


   

  Scenario: User can go to download page
    Given List view is selected
    Then Download button is shown

  Scenario: User can download a File without selecting anything
     Given List view is selected
     Then Download button is pressed
    
  Scenario: User can download a File
    
    Given Test book reference is created
      | author    | testing123    |
      | title     | Interesting Book |
      | year      | 1984             |
      | publisher | PaperPress       |
    And Test article reference is created
      | author  | testing123 |
      | title   | Groundbreaking stuff  |
      | journal | Unnaturell            |
      | year    | 1969                  |
      | volume  | 42                    |
    And Test Inproceeding reference is created
      | author    | testing123 |
      | title     | Outproceedings |
      | booktitle | Art of memes   |
      | year      | 1989           |
    And List view is selected
    When Checkbox next to the book is selected
    When Checkbox next to the article is selected
    When Checkbox next to the inproceedings is selected
    Then Download button is pressed
    