package restPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class GetuserDetailsstatusline {

	@Test
	public void GetuserDetails()
	{  
	    // Specify the base URL to the RESTful web service 
	    RestAssured.baseURI = "https://reqres.in/api"; 
	    // Get the RequestSpecification of the request to be sent to the server 
	    RequestSpecification httpRequest = RestAssured.given(); 
	    Response response = httpRequest.get("/users?page=2"); 

	    // Get the status line from the Response in a variable called statusLine
	    String statusLine = response.getStatusLine();
	    Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");

	}
	
}
