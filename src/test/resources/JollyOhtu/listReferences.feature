Feature: As a user I want to be able to list all the references

  Scenario: List view exists
    Given List view is selected
    Then List view is shown

  Scenario: Book reference is visible after successful reference creation
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
    When List view is selected
    Then Book reference row should be visible with following fields:
      | callID3LVBook       |
      | Jonh Jon            |
      | Interesting Book 76 |
      | PaperPresser        |
      | 1977                |

  Scenario: Book reference is not visible after unsuccessful reference creation
    Given Book reference with author "ListViewBookTestNotSuccessful" is not created
    When List view is selected
    Then Row with author "ListViewBookTestNotSuccessful" should not be visible

  Scenario: Article reference is visible after successful reference creation
    Given Article reference is successfully created with following fields:
      | callId  | CallID3LVARTICLE    |
      | author  | DarthnotVader       |
      | title   | asfasf              |
      | journal | Measures            |
      | year    | 2013                |
      | volume  | 872                 |
      | number  | 43                  |
      | pages   | 9001                |
      | month   | 1                   |
      | note    | ListViewArticleTest |
    When List view is selected
    Then Article reference row should be visible with following fields:
      | CallID3LVARTICLE    |
      | DarthnotVader       |
      | asfasf              |
      | Measures            |
      | ListViewArticleTest |

  Scenario: Article reference is not visible after unsuccessful reference creation
    Given Article reference with author "ListViewArticleTestNotSuccessfull" is not created
    When List view is selected
    Then Row with author "ListViewArticleTestNotSuccessfull" should not be visible

  Scenario: Inproceedings reference is visible after successful reference creation
    Given Inproceedings reference is successfully created with following fields:
      | callId       | callId2LVINPROCEEDINGS         |
      | author       | Imreallttiredofmaking          |
      | title        | Piratceedingsthese             |
      | booktitle    | BookasgofasfdYarr              |
      | year         | 1777                           |
      | editor       | SigmundthethirdBluebeard       |
      | volumenumber | 2                              |
      | series       | 13                             |
      | pages        | 57                             |
      | address      | Tortugara                      |
      | month        | 1                              |
      | organization | Piratesofthepacific            |
      | publisher    | Davy Jones incorporatedwithyou |
      | note         | ListViewInproceedingsTest      |
    When List view is selected
    Then Inproceedings reference row should be visible with following fields:
      | callId2LVINPROCEEDINGS         |
      | Imreallttiredofmaking          |
      | Piratceedingsthese             |
      | BookasgofasfdYarr              |
      | SigmundthethirdBluebeard       |
      | Tortugara                      |
      | Piratesofthepacific            |
      | Davy Jones incorporatedwithyou |
      | ListViewInproceedingsTest      |

  Scenario: Inproceedings reference is not visible after unsuccessful reference creation
    Given Inproceedings reference with author "ListViewInproceedingsTestNotSuccessful" is not created
    When List view is selected
    Then Row with author "ListViewInproceedingsTestNotSuccessful" should not be visible
