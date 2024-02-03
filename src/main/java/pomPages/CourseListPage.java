package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CourseListPage {
	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	 private WebElement pageHeader;

	 @FindBy(xpath = "//a[text()=' New']")
	 private WebElement newButton;

	 private String deletePath = "//td[text()='%s']/ancestor::tr/descendant::button[text()=' Delete']";

	 @FindBy(name = "delete")
	 private WebElement deleteButton;

	 @FindBy(xpath = "//h4[text()=' Success!']")
	 private WebElement successMessage;

	 // Initialization
	 public CourseListPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	 }
	 
	 //utilization
	 public String getPageHeader() {
		 return pageHeader.getText();
	}
	 public void clickNewButton() {
		 newButton.click();
	 }
	 public void deleteCourse(WebDriverUtility web, String courseName) {
		 web.convertPathToWebElement(deletePath, courseName).click();
		 deleteButton.click();
	 }
	 public String getSuccessManage() {
		 return successMessage.getText();
	 }
	 
	 
}

