package com.CBSpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement Email;
	
	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(id = "rememberMe")
	private WebElement RememberCB;
	
	@FindBy(linkText = "Forgot Password?")
	private WebElement Forgot;
	
	@FindBy(xpath  = "//button[normalize-space()='Log in']")
	private WebElement Login;

	@FindBy(xpath  = "//button[normalize-space()='Login with OTP']")
	private WebElement LoginOTP;
	
	
	public String enterMail(String EmailInput) {
		Email.clear();
		Email.sendKeys(EmailInput);
		return EmailInput;
	}
	
	public String enterPassword(String PasswordInput) {
		Password.clear();
		Password.sendKeys(PasswordInput);
		return PasswordInput;
	}
	
	public void clickLogin() {
		Login.click();
	}
}
