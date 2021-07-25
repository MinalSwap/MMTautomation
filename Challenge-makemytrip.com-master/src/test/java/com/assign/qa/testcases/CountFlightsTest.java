package com.assign.qa.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assign.qa.base.TestBase;
import com.assign.qa.pages.FlightInfoPage;
import com.assign.qa.util.utilFunctions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CountFlightsTest extends TestBase {

	public static FlightInfoPage flights;
	
	@BeforeClass
	public void initTest() {
		flights = new FlightInfoPage();
	}
	
	
	
	@Test(priority=1)
	public void selectNonStopFilter() {
		flights.nonStopFilterClick();
	}
	
	@Test(priority=2)
	public void Departure612AM() {
		flights.Departure612AM();
	}
	
	@Test(priority=3)
	public void ViewPricesBtnClick() {
		flights.ViewPricesBtnClick();
	}
	
	
	
	
	
	
	
//	@Test(priority=1)
	public void flightsCountNoFilterTest() throws Exception {	
		test = extent.createTest("Validate flightsCounts with/without Filters");
		test.assignCategory("Regression Test");
		
		childTest = test.createNode("NoFilter");
		
		Map<String, Integer> counts = flights.departureCountNoFilter();
		
		childTest.info(MarkupHelper.createLabel("Total number of flights available without any filter", ExtentColor.BLUE));
		childTest.log(Status.INFO, "Departure : "+ counts.get("departure") + "\t Return : "+ counts.get("return"));
		
		System.out.println("Total number of flights available without any filter");
		System.out.println("Departure : "+ counts.get("departure") + "\n Return : "+ counts.get("return"));

	}
	
//	@Test(priority=2)
	public void flightsCountNonStopFilterTest() throws Exception {
		//test = extent.createTest("Validate flightsCounts with Nonstop Filter");
		childTest = test.createNode("Nonstop Filter");
		test.assignCategory("Regression Test");
		
		Map<String, Integer> counts = flights.flightsCountNonStopFilter();
		
		childTest.info(MarkupHelper.createLabel("Total number of flights available with NonStop filter", ExtentColor.BLUE));
		childTest.log(Status.INFO, "Departure : "+ counts.get("departure") + "\t Return : "+ counts.get("return"));
		
		System.out.println("Total number of flights available with NonStop filter");
		System.out.println("Departure : "+ counts.get("departure") + "\n Return : "+ counts.get("return"));
	}
	
//	@Test(priority=3)
	public void flightsCountOneStopFilterTest() throws Exception {
		//test = extent.createTest("Validate flightsCounts with Onestop Filter");
		childTest = test.createNode("Onestop Filter");
		test.assignCategory("Regression Test");
		
		Map<String, Integer> counts = flights.flightsCountOneStopFilter();
		
		childTest.info(MarkupHelper.createLabel("Total number of flights available with One Stop filter", ExtentColor.BLUE));
		childTest.log(Status.INFO, "Departure : "+ counts.get("departure") + "\t Return : "+ counts.get("return"));
		
		System.out.println("Total number of flights available with One Stop filter");
		System.out.println("Departure : "+ counts.get("departure") + "\n Return : "+ counts.get("return"));
		
		
	}
	
	

	
	
	
}
