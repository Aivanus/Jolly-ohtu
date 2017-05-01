Feature: as a user I want to be able to filter references

  Scenario: Books are filtered
    Given Book reference is successfully created with following fields:
      | author    | Jonh Jon            |
      | title     | Interesting Book 76 |
      | publisher | PaperPresser        |
      | year      | 1977                |
      | callId    | callID3LVBook       |
      | volume    | 11                  |
      | series    | 1                   |
      | address   | Bakerstreet 13      |
      | edition   | 52                  |
      | month     | 1                   |
      | note      | ListViewBookTest    |
    And Book reference is successfully created with following fields:
      | author    | author              |
      | title     | title               |
      | publisher | publisher           |
      | year      | 1977                |
      | callId    | callID4             |
      | volume    | 11                  |
      | series    | 1                   |
      | address   | address             |
      | edition   | 52                  |
      | month     | 1                   |
      | note      | note                |
    When List view is selected
    And Search parameter is entered with the following field:
      | search    | Jon   |
    And User presses button Search
    Then Row with id "callID4" is not be visible
    But Row with id "callID3LVBook" is visible

  Scenario: Articles are filtered
    Given Article reference is successfully created with following fields:
      | callId  | CallID3DELETEARTICLE |
      | author  | DarthnotVaderasfdasf |
      | title   | asfasf123saf         |
      | journal | Measuresasfd234      |
      | year    | 2014                 |
      | volume  | 87                   |
      | number  | 4                    |
      | pages   | 901                  |
      | month   | 1                    |
      | note    | DeleteArticleTest    |
    And Article reference is successfully created with following fields:
      | callId  | CallID4              |
      | author  | author               |
      | title   | title                |
      | journal | journal              |
      | year    | 2014                 |
      | volume  | 87                   |
      | number  | 4                    |
      | pages   | 901                  |
      | month   | 1                    |
      | note    | note                 |
    When List view is selected
    And Search parameter is entered with the following field:
      | search    | fasf   |
    And User presses button Search
    Then Row with id "CallID4" is not be visible
    But Row with id "CallID3DELETEARTICLE" is visible

  Scenario: Inproceedings can be filtered
    Given Inproceedings reference is successfully created with following fields:
      | callId       | callId2                               |
      | author       | Imreallttiredofmakingsadfasf          |
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
    And Inproceedings reference is successfully created with following fields:
      | callId       | callId4                               |
      | author       | author                                |
      | title        | title                                 |
      | booktitle    | booktitle                             |
      | year         | 444                                   |
      | editor       | editor                                |
      | volumenumber | 44                                    |
      | series       | 444                                   |
      | pages        | 444                                   |
      | address      | address                               |
      | month        | 4                                     |
      | organization | organization                          |
      | publisher    | publisher                             |
      | note         | note                                  |
    When List view is selected
    And Search parameter is entered with the following field:
      | search    | 573   |
    And User presses button Search
    Then Row with id "callID4" is not be visible
    But Row with id "callId2" is visible