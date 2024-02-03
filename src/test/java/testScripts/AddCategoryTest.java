	package testScripts;

	import java.util.Map;

	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

	public class AddCategoryTest extends BaseClass {
	 @Test
	 public void addCategoryTest() {
	  SoftAssert soft = new SoftAssert();		   
	  
	  home.clickCoursesTab();
	  home.clickCategoryLink();
	  soft.assertTrue(category.getPageHeader().contains("Category"));
	  category.clickNewButton();
	  soft.assertEquals(addCategory.getPageHeader(), "Add New Category");

	  Map<String, String> map = excel.readFromExcel("Add Category");
	  addCategory.setName(map.get("Name"));
	  addCategory.clickSave();
	  soft.assertEquals(category.getSuccessManage(), "Success!");
	  category.deleteCourse(web,map.get("Name"));
	  soft.assertEquals(category.getSuccessManage(),"Success!");
	  if(category.getSuccessManage().equals("Success!"))
		  excel.updateTestStatus("Add Category", "Pass",IConstantPath.EXCEL_PATH);
	  else
		  excel.updateTestStatus("Add Category", "Fail",IConstantPath.EXCEL_PATH);
	  soft.assertAll();
	 
	 }
	}


