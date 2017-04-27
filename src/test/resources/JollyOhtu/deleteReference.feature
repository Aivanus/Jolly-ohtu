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
    And Checkbox next to the book is selected
    And User presses button Delete Selected for books
    Then Message "One book reference was deleted succesfully." is presented

  Scenario: User can delete an article reference
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
    When List view is selected
    And Checkbox next to the article is selected
    And User presses button Delete Selected for articles
    Then Message "One article reference was deleted succesfully." is presented

  Scenario: User can delete an inproceedings reference
    Given Inproceedings reference is successfully created with following fields:
      | callId       | callId2DeleteINPROCEEDINGS            |
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
    When List view is selected
    And Checkbox next to the inproceedings is selected
    And User presses button Delete Selected for inrpoceedings
    Then Message "One inproceeding reference was deleted succesfully." is presented
