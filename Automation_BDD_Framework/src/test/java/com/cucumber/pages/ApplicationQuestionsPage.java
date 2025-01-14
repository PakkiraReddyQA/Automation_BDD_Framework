package com.cucumber.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import common.CommonMethods;
import common.Wait;
import modules.CommonBean;

public class ApplicationQuestionsPage {
	WebDriver driver;
	Actions actions;
	CommonMethods objCommonMethods;

	@FindBy(how = How.XPATH, using="//section[contains(text(),'Select Type Here:')]//descendant::mat-select")
	private WebElement selectTypehereElement;
	@FindBy(how=How.NAME,using = "question")private WebElement questionElement;
	@FindBy(how = How.XPATH, using="//section[contains(text(),'Number of Answers:')]//descendant::mat-select")
	private WebElement noOfAnswersElement;
	@FindAll({
		@FindBy(how = How.XPATH, using="(//section[@class='example-section'])[4]//descendant::mat-form-field//input")
	})private List<WebElement> answersElements;

	@FindBy(how=How.XPATH,using = "//span[text()='Create']")private WebElement creatElement;

	@FindBy(how=How.XPATH,using = "(//span[text()='Create'])[2]")private WebElement submitElement;

	@FindAll({
		@FindBy(how = How.XPATH,using = "//tbody[@role='rowgroup']/child::tr")
	})
	List<WebElement> rows;

	@FindBy(how=How.XPATH,using = "//input[@formcontrolname='searchQuery']")private WebElement questionsearchElement;


	public ApplicationQuestionsPage(WebDriver driver)
	{
		this.driver=driver;
		actions=new Actions(driver);
		PageFactory.initElements(driver, this);
		objCommonMethods =new CommonMethods(driver);
	}

public void enterQuestionAndSelectType(String question,String QuestionType){
		questionElement.sendKeys(question);
		CommonBean.policyLevelPassedCntr++;
		objCommonMethods.matSelectdropdown(selectTypehereElement, QuestionType);
		CommonBean.policyLevelPassedCntr++;

}
/**
 * QuestionValue
 * Test1/Test2/Test3/Test4
 *
 * split value with /
 *
 *
 * */
public void enterQuestionAndSelectType(String question,String QuestionType,String questionValue){
	try {

		questionElement.sendKeys(question+objCommonMethods.generateRandomString("word", 5));
		objCommonMethods.matSelectdropdown(selectTypehereElement, QuestionType);
		Thread.sleep(1000);
		if(!QuestionType.toLowerCase().contains("date")) {
			if(!QuestionType.toLowerCase().contains("text")) {
				selectAnswers(questionValue);
			}
		}

	}

	catch (Exception e) {
		SoftAssert soft=new SoftAssert();
		soft.fail();
		e.printStackTrace();
	}

}

private void selectAnswers(String questionValue) {
  try {
	  CommonBean.validationpoints++;
		ArrayList<String> values =new ArrayList<>(Arrays.asList(questionValue.split("/"))) ;
//		String[] values=questionValue.split("/");
		objCommonMethods.matSelectdropdown(noOfAnswersElement, Integer.toString(values.size()));
		if(values.size()==answersElements.size()) {
			CommonBean.policyLevelPassedCntr++;
		}
		for(int i=0;i<answersElements.size();i++) {
			CommonBean.validationpoints++;
			answersElements.get(i).sendKeys(values.get(i));
			CommonBean.policyLevelPassedCntr++;

		}
  } catch (Exception e)
  {
	SoftAssert soft=new SoftAssert();
	soft.fail();
	e.printStackTrace();
  }

}
public void clickCreatebutton() throws InterruptedException
{

//	creatElement.click();
	 try {
		 Wait.elementToBeClickable(creatElement);
		 creatElement.click();
			CommonBean.policyLevelPassedCntr++;

	  } catch (ElementClickInterceptedException e) {


		  submitElement.click();
		  Thread.sleep(2000);
	  }

}

public void questionTable(String Question, String QuestionType, String System, String disabled, String action) {
	if(Question==null||Question=="null") {
		Question="";
	}
	if(QuestionType ==null||QuestionType =="null") {
		QuestionType="";
	}
	if(System==null||System=="null") {
		System="";
	}
	if(disabled==null||disabled=="null") {
		disabled="";
	}

	ArrayList<String> array= new ArrayList<>();
	Collections.addAll(array, Question,QuestionType,System,disabled,"");
	verifyRecord(array,rows, action);

}

private void verifyRecord(ArrayList<String>array,List<WebElement> rows, String action ) {
	  try {
		  CommonBean.validationpoints++;
		  boolean bool=false;
		  while (!bool) {
			  Thread.sleep(3000);
			  for(WebElement row:rows) {
				  int count=0;
				  List<WebElement> elements=row.findElements(By.xpath("child::td"));
				  for(int i=0;i<array.size();i++) {
					  String actual=null;
					   actual=elements.get(i).getText().trim();
					  String expected=array.get(i);
					  if(actual.contains(expected)) {
						  count++;
					  }
					   if(count==array.size()&&action.equalsIgnoreCase("Filter")) {
						   actions.scrollToElement(row);
//						   js.executeScript("arguments[0].scrollIntoView(true);", elements.get(i));
						   CommonBean.policyLevelPassedCntr++;
						   bool=true;
						   break;
					   }
					   if(count==array.size()&&action.equalsIgnoreCase("Edit")) {
						   actions.scrollToElement(row);
						   WebElement edit=null;
						   edit=row.findElement(By.xpath("child::td[5]/i-tabler[@name='edit']"));
						   objCommonMethods.JavascriptClick(edit);
//						   row.findElement(By.xpath("child::td[6]/button")).click();
						   CommonBean.policyLevelPassedCntr++;
						   bool=true;
						   break;
					   }
					   if(count==array.size()&&action.equalsIgnoreCase("Delete")) {
						   actions.scrollToElement(row);
						   WebElement edit=null;
						   edit=row.findElement(By.xpath("child::td[5]/i-tabler[@name='trash']"));
						   objCommonMethods.JavascriptClick(edit);

						   Thread.sleep(2000);
//						   row.findElement(By.xpath("child::td[6]/button")).click();
						   CommonBean.policyLevelPassedCntr++;
						   bool=true;
						   break;
					   }

				  }
			  }

			  if(bool) {

				 break;

			  }else {

			  }
		  }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

public void enterquestioninsearchbox(String Question)
{
	  CommonBean.validationpoints++;
	questionsearchElement.sendKeys(Question);

	   CommonBean.policyLevelPassedCntr++;

}





}
