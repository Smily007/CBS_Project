package com.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

	@Test
	public void loginTC() {
		try {
			getBrowserDriver("chrome");
			getUrl("http://dev.so.centralbooks.in/login");
			Login("snehalc@gmail.com", "Test@123");
			Thread.sleep(5000);
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
