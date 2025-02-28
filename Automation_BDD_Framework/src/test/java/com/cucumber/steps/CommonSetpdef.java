package com.cucumber.steps;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucmber.lib.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import modules.BaseClass;
import modules.CommonBean;
import modules.ExcelManager;
import modules.ExcelWrite;
import modules.PageRead;
public class CommonSetpdef extends BasePage{
	ExcelWrite objexcelWrite=new ExcelWrite();
	static PageRead objpageRead = new PageRead();

	@And("Click on Yes in the confirmation pop-up")
	public void clickOnYESPopUp() {
		objCommonElements.clickOnConfirmationbutton("Yes");
	}
	@And("Click On OK")
	public void clickOnOK() {
		objCommonElements.clickOnConfirmationbutton("Ok");
	}
	@And("Click on No in the confirmation pop-up")
	public void clickOnNoPopUp() {
		objCommonElements.clickOnConfirmationbutton("No");
	}

	@Given("Read the testdata {string} {string} {string}")
	public void readData(String tc_id,String filename, String sheetname) {
		CommonBean.validationpoints=0;
		CommonBean.policyLevelPassedCntr=0;
		CommonBean.policyLevelFailedCntr=0;
		ExcelManager reader = new ExcelManager(filename);
		CommonBean.data=reader.dataRead(sheetname, tc_id);

	}
	@Given("the user logs in with valid credentials {string}")
	public void the_user_logs_in_with_valid_credentials(String Role) throws Throwable {
		CommonBean.validationpoints+=2;

		if(Role.equalsIgnoreCase("administrator"))
		{
	objLoginpage.loginResponsive("pakkirareddy.yy", "Welcome1!");
	Thread.sleep(3000);
		}
		else if(Role.equalsIgnoreCase("Teacher")) {
			objLoginpage.loginResponsive("teacher.red001", "Welcome1!");
		} else if(Role.equalsIgnoreCase("student")) {
			objLoginpage.loginResponsive("student.red01", "Welcome1!");
		} else if(Role.equalsIgnoreCase("Advisor")) {
			objLoginpage.loginResponsive("advisor.red01", "Welcome1!");
		} else if(Role.equalsIgnoreCase("AdvisorAdmin")) {
			objLoginpage.loginResponsive("advisor.red01", "Welcome1!");
		} else if(Role.equalsIgnoreCase("Parent"))
		{
			objLoginpage.loginResponsive("advisor.red01", "Welcome1!");
		}
		 else if(Role.equalsIgnoreCase("InstAdmin"))
			{
				objLoginpage.loginResponsive("institute.admin01", "Welcome1!");
			}

	}



	@Then("Click on GO button")
	public void click_on_GO_button() throws Throwable {
	 CommonBean.validationpoints++;
	 objCommonElements.clickGobutton();
	}



	@Given("Write in Excelfile")
	public void write_in_excelfile() {
		try {
			System.out.println(CommonBean.Appname);
			System.out.println("***************Creating excel method********************");
			ExcelWrite.createNewResultSheet(CommonBean.Appname);
			System.out.println("***************Excel Created sucessfully********************");

		}catch (Exception e) {


		}
	}

	@Given("Store all results UI {string}")
	public void storeUIresult(String TestCaseName) {
		try {


		}catch (Exception e) {

		}
	}

	@AfterStep
    public static void tearDown(Scenario scenario) {
		System.out.println();
        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getLine().toString());
        }

    }

	@After
    public static void storeResult() {
		try {
			try {
				CommonBean.testcasecountUI++;
				if(CommonBean.data.get("TestCaseName")==null||CommonBean.data.get("TestCaseName")=="") {
					System.out.println("Not to write this testcase in excel sheet");
				}
				else {
					System.out.println(CommonBean.validationpoints);
					System.out.println(CommonBean.policyLevelPassedCntr);
				}
				CommonBean.scenarioName=CommonBean.data.get("TestCaseName").toString();
				String TCname=CommonBean.data.get("TestCaseName").toString();
				objpageRead.storeAllExpectedResultCombinedUI();
				System.out.println("collection"+CommonBean.collection);

			}catch (Exception e) {

			}
		}catch (Exception e) {

		}
	}

}
