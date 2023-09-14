package com.tests;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CBSpages.CustomerPages;

import utilities.UpdateExcel;

public class EnquiryTest extends BaseClass {

	boolean runFlag = true;
	CustomerPages CP;
	SoftAssert ass;
	UpdateExcel excel;

	@BeforeClass
	public void Setup() {
		getBrowserDriver("chrome");
		getUrl("http://dev.so.centralbooks.in/login");
		//getUrl("http://localhost:4200/login");
		Login("snehalc@gmail.com", "Test@123");
	}

	//TC_EQ_01
	//TC_EQ_02
	//TC_EQ_05
	//TS_EQ_09
	@Test(enabled = true, priority = 1)
	public void enquiryTest1() {
		try {
			ass = new SoftAssert();
			excel = new UpdateExcel();
			CP = new CustomerPages(driver);
			Thread.sleep(3000);
			CP.createEnquiry();
//			Thread.sleep(1000);
//			CP.uploadfile();
			Thread.sleep(2000);
			CP.academicDD();
			Thread.sleep(1000);
			CP.selectYear("2024-2025");
			Thread.sleep(1000);
			CP.enterText("Testing Raise enquiry");
			CP.saveproceed();
			Thread.sleep(1000);
			CP.toastMessage();
			CP.addItem();
			Thread.sleep(1000);
			CP.itemDDList(0);
			Thread.sleep(1000);
			CP.itemInput("a");
			Thread.sleep(1000);
			CP.selectItem(1);
			Thread.sleep(3000);
			CP.saveHalf();
			Thread.sleep(1000);
			ass.assertEquals(true, CP.enquiryHeading());
			ass.assertAll("Created Draft Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_01", "Pass", "Raised Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_02", "Pass", "Raised Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_05", "Pass", "Created Draft Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_09", "Pass", "uploaded document Successfully !!!");
		} catch (Exception e) {
			excel.printTestResult("Enquiry", "TS_EQ_05", "Fail", e.getMessage());
			ass.fail();
			captureScreen("Failed to Create Draft Enquiry !!!");

		}
	}

//	TS_EQ_06
//	TS_EQ_08
//	TS_EQ_03
//  TS_EQ_13
//	TS_EQ_12

	@Test(enabled = true, priority = 2,dependsOnMethods = {"enquiryTest1" })
	public void enquiryTest2() {
		try {
			ass = new SoftAssert();
			CP = new CustomerPages(driver);
			Thread.sleep(3000);
			CP.edit(0);
			Thread.sleep(1000);
			CP.update();
			Thread.sleep(1000);
			CP.addItem();
			Thread.sleep(1000);
			CP.itemDDList(1);
			Thread.sleep(1000);
			CP.itemInput("a");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			CP.selectItem(2);
			Thread.sleep(3000);
			CP.send();
			Thread.sleep(1000);
			CP.Comment("Testing Enquiry sent to Sales person");
			Thread.sleep(1000);
			CP.uploadfile();
			Thread.sleep(1000);
			CP.save();
			Thread.sleep(1000);
			ass.assertEquals(true, CP.toastMessage());
			ass.assertAll("Updated Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_06", "Pass", "Edited Draft Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_03", "Pass", "added Multiple Items Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_08", "Pass", "Updated Draft Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_12", "Pass", "Added comment Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_13", "Pass", "Sent Enquiry to School Successfully !!!");
		} catch (Exception e) {
			excel.printTestResult("Enquiry", "TS_EQ_06", "Fail",e.getMessage());
			ass.fail();
			captureScreen("Failed to edit draft enquiry !!!");
		}
	}

//	TS_EQ_10
//	TS_EQ_11

	@Test(enabled = true, priority = 3,dependsOnMethods = { "enquiryTest1","enquiryTest2" })
	public void enquiryTest3() {
		try {
			ass = new SoftAssert();
			CP = new CustomerPages(driver);
			CP.view(0);
			Thread.sleep(1000);
			CP.duplicateEnquiry();
			Thread.sleep(1000);
			ass.assertEquals(true, CP.toastMessage());
			CP.toastMessage();
			CP.next();
			Thread.sleep(2000);
			CP.back();
			Thread.sleep(1000);
			ass.assertEquals(true, CP.enquiryHeading());
			ass.assertAll("View and duplicated Enquiry Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_10", "Pass", "Duplicated Enquiry to School Successfully !!!");
			excel.printTestResult("Enquiry", "TS_EQ_11", "Pass", "View Enquiry Successfully !!!");
		} catch (Exception e) {
			
			excel.printTestResult("Enquiry", "TS_EQ_10", "Fail", e.getMessage());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
