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
    But Row with id "callID3DELBOOK" is not be visible

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
    But Row with id "CallID3DELETEARTICLE" is not be visible

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
    But Row with id "callId2DeleteINPROCEEDINGS" is not be visible

  Scenario: User can delete multiple book references
    Given Book reference is successfully created with following fields:
      | author    | DeleteThis1asfd          |
      | title     | InterestingBook76234asdf |
      | publisher | PaperPresser23asdf       |
      | year      | 1977                     |
      | callId    | callID3DELBOOKasdf       |
      | volume    | 11                       |
      | series    | 1                        |
      | address   | Bakerstreet13asdfsadf    |
      | edition   | 52                       |
      | month     | 1                        |
      | note      | DeleteOneBookTestasdf    |
    And Book reference is successfully created with following fields:
      | author    | DeleteThis1fgj           |
      | title     | InterestingBook7623fghj4 |
      | publisher | PaperPresser23fhj        |
      | year      | 1977                     |
      | callId    | callID3DELBOOKfgj        |
      | volume    | 11                       |
      | series    | 1                        |
      | address   | Bakerstreet13asdfghjk    |
      | edition   | 52                       |
      | month     | 1                        |
      | note      | DeleteOneBookTesthgjk    |
    And Book reference is successfully created with following fields:
      | author    | DeleteThis1iuop          |
      | title     | InterestingBook76234uiop |
      | publisher | PaperPresser23iuop       |
      | year      | 1977                     |
      | callId    | callID3DELBOOKiuop       |
      | volume    | 11                       |
      | series    | 1                        |
      | address   | Bakerstreet13asdfuiop    |
      | edition   | 52                       |
      | month     | 1                        |
      | note      | DeleteOneBookTestuipo    |
    When List view is selected
    And User presses button Select All for books
    And User presses button Delete Selected for books
    Then Message "3 book references were deleted succesfully." is presented
    But Row with id "callID3DELBOOKasdf" is not be visible
    But Row with id "callID3DELBOOKfgj" is not be visible
    But Row with id "callID3DELBOOKiuop" is not be visible

  Scenario: User can delete multiple article references
    Given Article reference is successfully created with following fields:
      | callId  | CallID3DELETEARTICLEsadf |
      | author  | DarthnotVaderasfdasasdff |
      | title   | asfasf123sasdfaf         |
      | journal | Measuresasfd2asdf34      |
      | year    | 2014                     |
      | volume  | 87                       |
      | number  | 4                        |
      | pages   | 901                      |
      | month   | 1                        |
      | note    | DeletdfeArticleTest      |
    And Article reference is successfully created with following fields:
      | callId  | CallID3DELETEARfdhjhgTICLE |
      | author  | DarthnotVaderfgjghjasfdasf |
      | title   | asfasf123sjkghjkaf         |
      | journal | Measuresasghjkghjkfd234    |
      | year    | 2014                       |
      | volume  | 87                         |
      | number  | 4                          |
      | pages   | 901                        |
      | month   | 1                          |
      | note    | DeleteArticlghjkghjkeTest  |
    And Article reference is successfully created with following fields:
      | callId  | CallID3DELETEAvbnmvbmnRTICLE |
      | author  | DarthnotVaderabmvbmsfdasf    |
      | title   | asfasf123vbnmvbnmsaf         |
      | journal | Measuresanmvbnmsfd234        |
      | year    | 2014                         |
      | volume  | 87                           |
      | number  | 4                            |
      | pages   | 901                          |
      | month   | 1                            |
      | note    | DeletvbnmvbmeArticleTest     |
    When List view is selected
    And User presses button Select All for articles
    And User presses button Delete Selected for articles
    Then Message "3 article references were deleted succesfully." is presented
    But Row with id "CallID3DELETEARTICLEsadf" is not be visible
    But Row with id "CallID3DELETEARfdhjhgTICLE" is not be visible
    But Row with id "CallID3DELETEAvbnmvbmnRTICLE" is not be visible

  Scenario: User can delete mutliple inproceedings references
    Given Inproceedings reference is successfully created with following fields:
      | callId    | callId2DeleteINPROCEEDINGSsadfsdf  |
      | author    | Imreallttiredofmakingsadfasfdhghjf |
      | title     | Piratceedingsthesasfasfasfgjghjfe  |
      | booktitle | BookasgofasfdYsfasfasfsafgjjdfarr  |
      | year      | 1773                               |
    And Inproceedings reference is successfully created with following fields:
      | callId    | callId2DeleteINPROCEEDInbvmbnvmNGS    |
      | author    | Imreallttiredofmakingsvbnmadfasf      |
      | title     | Piratceedingsthesasfvmvnbmasfasfe     |
      | booktitle | BookasgofasfdYsfasfvbnmvbnmasfsadfarr |
      | year      | 1773                                  |
    And Inproceedings reference is successfully created with following fields:
      | callId    | callId2DeleteIzxcvzxcvNPROCEEDINGS    |
      | author    | Imreallttiredofzxcvzxcvmakingsadfasf  |
      | title     | Piratceedingszxcvzxcvthesasfasfasfe   |
      | booktitle | BookasgofaszxcvzxvcfdYsfasfasfsadfarr |
      | year      | 1773                                  |
    When List view is selected
    And User presses button Select All for inproceedings
    And User presses button Delete Selected for inrpoceedings
    Then Message "3 inproceeding references were deleted succesfully." is presented
    But Row with id "callId2DeleteINPROCEEDINGSsadfsdf" is not be visible
    But Row with id "callId2DeleteINPROCEEDInbvmbnvmNGS" is not be visible
    But Row with id "callId2DeleteIzxcvzxcvNPROCEEDINGS" is not be visible
