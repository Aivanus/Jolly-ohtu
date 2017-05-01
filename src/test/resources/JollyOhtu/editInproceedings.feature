Feature: As a user I want to be able to edit inproceedings references

  Scenario: User can edit an inproceedings reference
    Given Inproceedings reference is successfully created with following fields:
      | callId       | callId2DeleteINPROCEEDINGS            |
      | author       | author          |
      | title        | Piratceedingsthesasfasfasfe           |
      | booktitle    | BookasgofasfdYsfasfasfsadfarr         |
      | year         | 1773                                  |
      | editor       | SigmundtsdfasdfasfdhethirdBluebeard   |
      | volumenumber | 22                                    |
      | series       | 133                                   |
      | pages        | 573                                   |
      | address      | Torsadfasdfastugara                   |
      | month        | 1                                     |
      | organization | Piasfsadfasdfratesofthepacific        |
      | publisher    | Dasdfasfdvy Jones incorporatedwithyou |
      | note         | DeleteInproceedingsTest               |
    When List view is selected
    And Edit button is pressed
    And User enters edited information as following:
      | title | edited title |
    And Update button is pressed
    Then Message "Reference was updated successfully!" is presented
    But Title has been changed to "edited title"
