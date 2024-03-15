package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

public class AddCourseTest extends BaseClass {
	@Test
	public void addCourseTest() {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertTrue(courselist.getPageHeader().contains("Course List"));
		courselist.clickNewButton();
		soft.assertEquals(addCourse.getPageHeader(),"Add New Course");
		
		Map<String,String> map = excel.readFromExcel("Add  Course");
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web, map.get("Category"));
		addCourse.setPrice(map.get("Price"));
		addCourse.uploadPhotocourse(map.get("Photo"));
		addCourse.setDescription(map.get("Description"), web);
		addCourse.clickSave();
		
		soft.assertEquals(courselist.getSuccessManage(), "Success!");
		courselist.deleteCourse(web,map.get("Name"));
		soft.assertEquals(courselist.getSuccessManage(), "Success!");
		
		if(courselist.getSuccessManage().equals("Success!"))
			excel.updateTestStatus("Add Course", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Course", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
		
	}
	

}
