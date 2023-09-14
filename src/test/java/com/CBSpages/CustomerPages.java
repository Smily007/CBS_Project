package com.CBSpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tests.BaseClass;

public class CustomerPages extends BasePage {

	public CustomerPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "0")
	private WebElement Dashboard;

	@FindBy(id = "1")
	private WebElement CreateEnquiry;

	public void createEnquiry() {
		CreateEnquiry.click();
	}

	// Enquiry Dashboard

	@FindBy(xpath = "(//div[@class='d-flex align-items-center']/p)[1]")
	private WebElement EnquiryHeading;

	@FindBy(xpath = "//div[@class='card-body border-bottom']")
	private List<WebElement> EnquiryList;

	@FindBy(xpath = "//div/div/div/div[@class='white-text br-10 fs-9 fw-700 px-2 py-1']")
	private List<WebElement> StatusList;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Edit']")
	private List<WebElement> EditButtonList;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Delete']")
	private List<WebElement> DeleteButtonList;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='View']")
	private List<WebElement> ViewButtonList;

	@FindBy(xpath = "//h4[@class=\"fs-10 text-decoration-underline link-text pointer\"]")
	private List<WebElement> EnquiryIDList;

	@FindBy(xpath = "//h4[@class=\"fs-13 fw-700\"]")
	private List<WebElement> DateList;

	public boolean enquiryHeading() {
		return EnquiryHeading.getText().trim().equals("Enquiry");
	}

	public void edit(int i) {
		EditButtonList.get(i).click();
	}

	public void delete(int i) {
		DeleteButtonList.get(i).click();
	}

	public void view(int i) {
		ViewButtonList.get(i).click();
	}

	// create enquiry

	@FindBy(xpath = "//input[@id='formFile']")
	private WebElement Uploadpage1;

	@FindBy(xpath = "//button[normalize-space()='Duplicate Enquiry']")
	private WebElement DuplicateEnquiry;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[1]")
	private WebElement AcademicDDArrow;

	@FindBy(xpath = "//span[@class=\"ng-option-label\"]")
	private List<WebElement> YearList;

	@FindBy(xpath = "//div[@class='angular-editor-textarea']")
	private WebElement TextBox;

	@FindBy(xpath = "//button[normalize-space()='Save and Proceed']")
	private WebElement SaveProceed;

	@FindBy(xpath = "//button[contains(text(),' Update ')]")
	private WebElement Update;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement Next;

	@FindBy(xpath = "//button[normalize-space()='Back']")
	private WebElement Back;

	@FindBy(id = "toast-container")
	private WebElement ToastMassage;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement Add;
	
	@FindBy(xpath = "//div[@role='combobox']")
	private  List<WebElement> ItemDDList;

	@FindBy(xpath = "//input[@id='inputValidation']")
	private WebElement ItemTextInput;

	@FindBy(xpath = "//div[@class=\"scrollable-content\"]/div")
	private List<WebElement> ItemList;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement SaveHalf;

	@FindBy(xpath = "//button[normalize-space()='Send Enquiry']")
	private WebElement SendEnquiry;

	@FindBy(id = "message")
	private WebElement comment;

	@FindBy(id = "formFile")
	private WebElement Uploadpage2;

	@FindBy(xpath = "//button[@class='mb-1 me-2 btn btn-primary fw-bold py-2 px-3 fs-15']")
	private WebElement Save;

	public void uploadfile()  {
		try {
		Uploadpage1.sendKeys("C:\\Users\\Admin\\Downloads\\dummy.pdf");
		Thread.sleep(1000);
		System.out.println("File Uploaded Successfully");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void duplicateEnquiry() {
		DuplicateEnquiry.click();
	}

	public void academicDD() {
		AcademicDDArrow.click();
	}

	public String selectYear(String Year) {
		String yeartext = null;
		for (WebElement year : YearList) {
			yeartext = year.getText();
			if (yeartext.equals(Year)) {
				year.click();
			}
		}
		return yeartext;
	}

	public String enterText(String text) {
		TextBox.sendKeys(text);
		return text;
	}

	public void saveproceed() {
		SaveProceed.click();
	}

	public void update() {
		Update.click();
	}

	public boolean toastMessage() {
		if (ToastMassage.isDisplayed()) {
			ToastMassage.click();
		}
		return ToastMassage.isDisplayed();
	}

	public void next() {
		Next.click();
	}

	public void back() {
		Back.click();
	}

	public void addItem() {
		Add.click();
	}
	
	public void itemDDList(int i) {
		ItemDDList.get(i).click();	}

	public void itemInput(String text) {
		ItemTextInput.sendKeys(text);
	}

	public void selectItem(int i) {
		ItemList.get(i).click();
	}

	public void saveHalf() {
		SaveHalf.click();
	}

	public void Comment(String text) {
		comment.sendKeys(text);
	}

	public void send() {
		SendEnquiry.click();
	}

	public void save() {
		Save.click();
	}

}
