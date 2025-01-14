package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.CommonMethods;
import common.Wait;
import modules.CommonBean;

public class CommonElements {
	WebDriver driver;
	CommonMethods objCommonMethods;
	@FindBy(how = How.XPATH,using = "//span[text()='Go'] | //*[text()='GO']//parent::button")private WebElement goElement;
	@FindAll({
				@FindBy (how = How.XPATH,using = "//div[contains(@class,'focus-indicator')]//parent::*")
		     }) private List<WebElement> menu;

//	@FindAll({
//		@FindBy (how = How.XPATH,using = "//ul[@class='oxd-main-menu']")
//     }) private List<WebElement> menu;

	@FindBy(how = How.XPATH,using = "//button[text()='Yes']")private WebElement yesElement;
	@FindBy(how = How.XPATH,using = "(//button[text()='No'])[2]")private WebElement noElement;
	@FindBy(how = How.XPATH,using = "//button[text()='Ok']")private WebElement okElement;
	@FindBy(how=How.XPATH,using = "")private WebElement cancelElement;

	@FindBy(how=How.XPATH,using = "//span[text()='Create']") private WebElement CreateElement;
	@FindBy(how=How.XPATH,using = "(//span[text()='Create'])[2]") private WebElement CreateElement2;

	@FindBy(how=How.XPATH,using = "(//button[@aria-label='Notifications'])[2]") private WebElement LogoutButton1;
	@FindBy(how=How.XPATH,using = "(//div[normalize-space()='Logout'])[7]") private WebElement LogoutButton2;

	public CommonElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		objCommonMethods=new CommonMethods(driver);
	}

	public void clickOnMenuItem(String screen) {
	 try {
			Thread.sleep(3000);
			CommonBean.validationpoints++;
			for(WebElement element:menu) {
				String actualScreen=element.findElement(By.xpath("/li/child::a/span")).getText().trim();
				if(actualScreen.equalsIgnoreCase(screen)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
//					js.executeScript("arguments[0].scrollIntoView(true);", element);
					Wait.elementToBeClickable(element);
					element.click();
					CommonBean.policyLevelPassedCntr++;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnMenuItem1(String screen) {
		 try {
				Thread.sleep(3000);
				CommonBean.validationpoints++;
				WebElement element = driver.findElement(By.xpath("//span[text()='"+screen+"']"));
				Wait.elementToBeClickable(element);
				element.click();
			}
		 catch (Exception e) {
				e.printStackTrace();
			}

		}







	public void clickOnConfirmationbutton(String buttonname) {
		if(buttonname.equalsIgnoreCase("yes")) {
			Wait.elementToBeClickable(yesElement);
			yesElement.click();
		}
		if(buttonname.equalsIgnoreCase("no")) {
			Wait.elementToBeClickable(noElement);
			noElement.click();
		}
		if(buttonname.equalsIgnoreCase("ok")) {
			Wait.elementToBeClickable(okElement);
			okElement.click();
		}
	}

	public void clickGobutton() {
		Wait.elementToBeClickable(goElement);
		goElement.click();
		CommonBean.policyLevelPassedCntr++;
	}

	public void clickLogoutbutton() {
		Wait.elementToBeClickable(LogoutButton1);
		LogoutButton1.click();
		CommonBean.policyLevelPassedCntr++;

		Wait.elementToBeClickable(LogoutButton2);
		LogoutButton2.click();
		CommonBean.policyLevelPassedCntr++;
	}





	public void clickCreatebutton() {
//		objCommonMethods.JavascriptClick(CreateElement);
//		objCommonMethods.JavascriptScrollIntoView(CreateElement);
		Wait.elementToBeClickable(CreateElement);
		CreateElement.click();
		CommonBean.policyLevelPassedCntr++;
	}
	public void clickCreatebutton2() {
//		objCommonMethods.JavascriptClick(CreateElement);
//		objCommonMethods.JavascriptScrollIntoView(CreateElement);
		Wait.elementToBeClickable(CreateElement2);
		CreateElement2.click();
		CommonBean.policyLevelPassedCntr++;
	}
	
	
	public void clickokbutton() {
		Wait.elementToBeClickable(CreateElement);
		okElement.click();
		CommonBean.policyLevelPassedCntr++;
	}


	/**
	 * This method will featch the Dash board Text from Left side of Every login based on the given Input
	 * @param dashboardtext
	 * @return
	 */

	public String dashboardText(String dashboardtext)
	{
		 CommonBean.policyLevelPassedCntr++;
	 String dashboardText = driver.findElement(By.xpath(" //h4[normalize-space()='"+dashboardtext+"']")).getText();

	 return dashboardText;

	}



}
