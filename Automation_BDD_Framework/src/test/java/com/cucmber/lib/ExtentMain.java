package com.cucmber.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import managers.ExtentReport;
import managers.RepoterClass;


public class ExtentMain {

	public static void main(String[] args) {
		
		ExtentReport extentReport=new RepoterClass();
		WebDriver driver = new ChromeDriver();

		driver.get("https://lms-sis-demo.sapphirus.in/");

		extentReport.setCreateTestPass("URL lauched", driver);

		extentReport.flushReport();



	}

}
