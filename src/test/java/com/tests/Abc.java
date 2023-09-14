package com.tests;

import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CBSpages.CustomerPages;

import utilities.UpdateExcel;

public class Abc extends BaseClass {
	
	@Test(enabled = true, priority = 1)
	public void enquiryTest1() {
		try {
			//ass = new SoftAssert();
			//excel = new UpdateExcel();
			getBrowserDriver("chrome");
			//getUrl("http://dev.so.centralbooks.in/login");
			getUrl("http://localhost:4200/login");
			Login("snehalc@gmail.com", "Test@123");
			Thread.sleep(3000);
			CustomerPages CP = new CustomerPages(driver);
			CP.createEnquiry();
			Thread.sleep(1000);
			CP.uploadfile();
			Thread.sleep(2000);
			CP.academicDD();
			Thread.sleep(1000);
			CP.selectYear("2024-2025");
			Thread.sleep(1000);
			CP.enterText("Testing Raise enquiry");
			CP.saveproceed();
			Thread.sleep(1000);
			CP.toastMessage();
			System.out.println("1");
			CP.addItem();
			Thread.sleep(1000);
			System.out.println("2");
			CP.itemDDList(0);
			Thread.sleep(1000);
			System.out.println("3");
			CP.itemInput("a");
			System.out.println("4");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			CP.selectItem(1);
			Thread.sleep(3000);
			CP.saveHalf();
			 driver.quit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
	}
	}
}
