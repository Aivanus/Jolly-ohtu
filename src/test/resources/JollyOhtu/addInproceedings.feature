Feature: As a user I want to be able to add inproceedings references

  Background: 
    Given Add inproceedings view is selected

  Scenario: User can create an inproceedings reference with valid mandatory fields
    When Valid mandatory inproceedings information is entered:
      | author    | Jack Proceeder |
      | title     | Outproceedings |
      | booktitle | Art of memes   |
      | year      | 1989           |
    And User presses button Add
    Then Message "Reference was saved successfully!" is presented

  Scenario: User can create an inproceedings reference with valid mandatory and optional fields
    When Valid mandatory inproceedings information is entered:
      | author    | Ray Yarrr     |
      | title     | Piratceedings |
      | booktitle | Book of Yarr  |
      | year      | 1777          |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId       | callId8        |
      | editor       | S. Bluebeard   |
      | volumenumber | 2              |
      | series       | 13             |
      | pages        | 57             |
      | address      | Tortuga        |
      | month        | 1              |
      | organization | Pirates        |
      | publisher    | Davy Jones inc |
      | note         | Yarrrr!        |
    And User presses button Add
    Then Message "Reference was saved successfully!" is presented

  Scenario: User cannot create an inproceedings reference if some of mandatory fields is empty
    When Mandatory inproceedings information with only author and title is entered:
      | author | Not an inproceedings  |
      | title  | Running out of ideas! |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create an inproceedings reference if all of the mandatory fields are empty
    When No mandatory inproceedings information is entered:
      | author |  |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create an inproceedings reference with empty mandatory fields and valid optional fields
    When No mandatory inproceedings information is entered:
      | author |  |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId       | callId2        |
      | editor       | S. Bluebeard   |
      | volumenumber | 2              |
      | series       | 13             |
      | pages        | 57             |
      | address      | Tortuga        |
      | month        | 1              |
      | organization | Pirates        |
      | publisher    | Davy Jones inc |
      | note         | Yarrrr!        |
    And User presses button Add
    Then Message "You must fill in the fields marked by *" is presented

  Scenario: User cannot create an inproceedings reference with invalid month
    When Valid mandatory inproceedings information is entered:
      | author    | Ray Yarrr2     |
      | title     | Piratceedings2 |
      | booktitle | Book of Yarr 2 |
      | year      | 1778           |
    And Optional fields are chosen
    And Invalid optional field information is entered:
      | callId       | callId3      |
      | editor       | S. Bluebeard |
      | volumenumber | 2            |
      | series       | 13           |
      | pages        | 57           |
      | address      | Tortuga      |
      | month        | 21           |
      | organization | Pirates      |
    And User presses button Add
    Then Message "Invalid input. Check your input." is presented

  Scenario: User cannot create an inproceedings reference if reference already exists
    When Valid mandatory inproceedings information is entered:
      | author    | Ray test       |
      | title     | Piratest       |
      | booktitle | Book of Yarr 4 |
      | year      | 1779           |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId       | callId4        |
      | editor       | S. Bluebeard   |
      | volumenumber | 2              |
      | series       | 13             |
      | pages        | 57             |
      | address      | Tortuga        |
      | month        | 1              |
      | organization | Pirates        |
      | publisher    | Davy Jones inc |
      | note         | Yarrrr!        |
    And User presses button Add
    And Message "Reference was saved successfully!" is presented
    When Valid mandatory inproceedings information is entered:
      | author    | Ray test       |
      | title     | Piratest       |
      | booktitle | Book of Yarr 4 |
      | year      | 1779           |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId       | callId5        |
      | editor       | S. Bluebeard   |
      | volumenumber | 2              |
      | series       | 13             |
      | pages        | 57             |
      | address      | Tortuga        |
      | month        | 1              |
      | organization | Pirates        |
      | publisher    | Davy Jones inc |
      | note         | Yarrrr!        |
    And User presses button Add
    Then Message "The inproceedings reference already exists with the ID: callId4." is presented

    Scenario: User can create an inproceedings reference with an empty callId
    When Valid mandatory inproceedings information is entered:
      | author    | Ray test       |
      | title     | Piratest       |
      | booktitle | Book of Yarr 4 |
      | year      | 1779           |
    And Valid mandatory inproceedings information is entered:
      | author    | roi tost     |
      | title     | testi        |
      | year      | 2137         |
      | publisher | testi        |
    And User presses button Add
    Then Message "Reference was saved successfully!" is presented

  Scenario: User can't create an inproceedings reference with an existing callId
    When Valid mandatory inproceedings information is entered:
      | author       | author yep i am                |
      | title        | Piratceedingsthese             |
      | booktitle    | BookasgofasfdYarr              |
      | year         | 1777                           |
    And User presses button Add
    And Message "Reference was saved successfully!" is presented
    And Valid mandatory inproceedings information is entered:
      | author    | Ray test       |
      | title     | Piratest       |
      | booktitle | Book of Yarr 4 |
      | year      | 1779           |
    And Optional fields are chosen
    And Valid optional field information is entered:
      | callId | ayia77  |
    And User presses button Add
    Then Message "That Id already exists, choose another one." is presented
