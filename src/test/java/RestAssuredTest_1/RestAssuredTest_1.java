package RestAssuredTest_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RestAssuredTest_1 {
  @Test (priority = 1)
  public void GetWeatherDetails_Valid() 
  {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("/Hyderabad");
	  System.out.println("Response Body is ==>" +response.asString());
	  int statusCode = response.getStatusCode();
	  System.out.println("Status Code ==> "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	
  }
  
  @Test (priority = 2)
  public void GetWeatherDetails_InValid()
  {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("/snehal");
	  System.out.println("Response Body is ==>" +response.asString());
	  int statusCode = response.getStatusCode();
	  System.out.println("Status Code ==> "+statusCode);
	  Assert.assertEquals(statusCode, 400);
	  
  }	  

  @BeforeTest
  public void beforeTest()
  {
  }

  @AfterTest
  public void afterTest() 
  {
  }

}
