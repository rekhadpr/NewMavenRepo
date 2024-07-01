package restPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
public class CheckMessageBody {

	//Read JSON Response Body using Rest Assured
	
//	@Test(priority = 1)
	public void userMessageBody()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users?page=2");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		System.out.println("Response Body is: " + body.asString());
	}

	
	//Validate Response Body contains some String
	@Test(priority = 2)
	public void checkuserMessageBody()
	{
		
		
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users?page=2");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Byron") , true , "Response body does not contains Byron");
	//	sftassert.assertEquals(bodyAsString.contains("Cyron") , true , "Response body does not contains Byron");
		SoftAssert sftassert=new SoftAssert();
		String statusLine = response.getStatusLine();
	//    Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
	    sftassert.assertEquals(statusLine, "HTTP/1.1 201 OK", "Correct status code returned");
	    System.out.println("status line is: "+statusLine);
	    sftassert.assertAll();
		
		
	}
	//check string presence ignoring case
	@Test(priority = 3)
	public void WeatherMessageBody()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users?page=2");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();

		// convert the body into lower case and then do a comparison to ignore casing.
		Assert.assertEquals(bodyAsString.toLowerCase().contains("cyron") , true , "check if Byron present");
	}

	//go to particular node like first name and also print all values of first name
	
//	@Test
	public void VerifyNameInJsonResponse()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users?page=2");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		
		String name=jsonPathEvaluator.get("data[3].first_name");
		
		List<String> names = jsonPathEvaluator.get("data.first_name");
	
		 
		System.out.println("Name received from Response " + name);
		// Let us print the city variable to see what we got
		System.out.println("Name received from Response " + names);

		// Validate the response
	Assert.assertEquals(name, "Byron");
		
		Assert.assertEquals(names.contains("Byron") , true , "Response body does not contains Byron");
		
		}
	
	//Sample Code to read all the nodes from Weather API Response
//	@Test
	
	public void DisplayAllNodesInWeatherAPI()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users?page=2");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Let us print the page variable to see what we got
		System.out.println("Page received from Response " + jsonPathEvaluator.get("page"));

		// Print the id node
		System.out.println("id received from Response " + jsonPathEvaluator.get("data.id"));

		// Print the email node
		System.out.println("email received from Response " + jsonPathEvaluator.get("data.email"));

		// Print first name description
		System.out.println("first name received from Response " + jsonPathEvaluator.get("data.first_name"));

		// Print last name Speed
		System.out.println("Last name received from Response " + jsonPathEvaluator.get("data.last_name"));

		// Print total
		System.out.println("Total from Response " + jsonPathEvaluator.get("total"));
	}
	
}
