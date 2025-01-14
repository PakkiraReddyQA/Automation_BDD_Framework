

Feature:Administrator - Application Questions.


 @Test:ApplicationQuestions001 @TestName:CreateQuestion @CreateQuestions
  Scenario Outline:  Verify the Create Questions in Application Questions
    Given Read the testdata "<TC_ID>" "<FileName>" "<Sheetname>"
    Given the user logs in with valid credentials "<role>"
    When the user navigates to the "Screen" screen
    When user click on GO & Create button.
    #And user enter and select the "Question" "Question_type" in Create Questions
    And user enter and select the "Question" "Question_type" "Answers" in Create Questions
    And click on create button

    

    Examples: 
      | TC_ID     	   | FileName                | Sheetname  					| role  					|
      | TC_ADMS_AQ_001 | SISQA.xlsx	 | ApplicationQuestions |administrator |
       

  @Test:ApplicationQuestions002 @TestName:ApplicationQuestionsFilter @ApplicationQuestionFilter
  Scenario Outline: Verify the Filter Criteria in Institutions
    Given Read the testdata "<TC_ID>" "<FileName>" "<Sheetname>"
    Given the user logs in with valid credentials "<role>"
    When the user navigates to the "Screen" screen
    When user enter the "Question"
    Then Click on GO button
    Then Verify the filter record in Question table "Question" "Question_type" "System" "Disabled" "Action"
    Examples: 
      | TC_ID     	   | FileName                | Sheetname  |			 role  					|
      | TC_ADMS_AQ_002 | SISQA.xlsx	 |  ApplicationQuestions| administrator |
      

 