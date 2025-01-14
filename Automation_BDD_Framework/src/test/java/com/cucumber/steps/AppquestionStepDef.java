package com.cucumber.steps;



import com.cucmber.lib.BasePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.CommonBean;

public class AppquestionStepDef extends BasePage
{

@When("user click on GO & Create button.")
public void user_click_on_go_create_button() throws InterruptedException {

    objCommonElements.clickCreatebutton();
    Thread.sleep(2000);

  objApplicationQuestionsPage.clickCreatebutton();
    Thread.sleep(2000);

}

	@When("user enter and select the {string} {string} in Create Questions")
	public void selectCreateQuestionsApp(String question, String questionType) {
		CommonBean.validationpoints+=2;
		objApplicationQuestionsPage.enterQuestionAndSelectType(CommonBean.data.get(question),CommonBean.data.get(questionType));

	}
@When("user enter and select the {string} {string} {string} in Create Questions")
public void selectCreateQuestionsApp2(String question, String questionType,String answers) {
		CommonBean.validationpoints+=2;
		objApplicationQuestionsPage.enterQuestionAndSelectType(CommonBean.data.get(question),CommonBean.data.get(questionType),CommonBean.data.get(answers));
}

	@When("select and enter the {string} {string}")
	public void select_and_enter_the(String string, String string2) {

	}

	@When("click on create button")
	public void click_on_create_button() throws InterruptedException
	{
		objApplicationQuestionsPage.clickCreatebutton();
		objCommonElements.clickokbutton();
		objCommonElements.clickLogoutbutton();
//		 CommonBean.policyLevelPassedCntr++;
		Thread.sleep(3000);


	}

	@When("user enter the {string}")
	public void user_enter_the(String Question)
	{
		objApplicationQuestionsPage.enterquestioninsearchbox(CommonBean.data.get(Question));
	}

		@Then("Verify the filter record in Question table {string} {string} {string} {string} {string}")
		public void Verify_the_filter_record_in_Question_table(String Question ,String Question_type, String System,String Disabled,String Action)
		{
	objApplicationQuestionsPage.questionTable(CommonBean.data.get(Question), CommonBean.data.get(Question_type),CommonBean.data.get(System), CommonBean.data.get(Disabled),CommonBean.data.get(Action));
		}






}
