 package com.cucmber.lib;





import com.cucumber.pages.ApplicationQuestionsPage;
import com.cucumber.pages.CommonElements;
import com.cucumber.pages.InsistitutePage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SchoolYearPage;

import common.Wait;
import modules.BaseClass;


public class BasePage extends BaseClass{


	public static LoginPage objLoginpage=null;
	public static CommonElements objCommonElements=null;
	public static ApplicationQuestionsPage objApplicationQuestionsPage=null;
	public static InsistitutePage  objInsistitutePage=null;
	public static SchoolYearPage objSchoolYearPage=null;



	public static Wait wait;



	public static void PageObectInitialization() {
		
		 wait=new Wait(driver);
		objLoginpage = new LoginPage(driver);
		objCommonElements= new CommonElements(driver);
		objApplicationQuestionsPage=new ApplicationQuestionsPage(driver);
		objInsistitutePage=new InsistitutePage(driver);
		objSchoolYearPage=new SchoolYearPage(driver);
		
	}

	public static void destroyPageObjects() {
		wait=null;
		objLoginpage=null;
		objCommonElements=null;
		objApplicationQuestionsPage=null;
		objInsistitutePage=null;
		objSchoolYearPage=null;
	}
}
