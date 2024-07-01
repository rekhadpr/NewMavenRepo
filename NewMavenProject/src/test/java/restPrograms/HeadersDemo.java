package restPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class HeadersDemo {
	
	@Test (enabled=false)
	public void IteratingHeaders() 
	{ 
		RestAssured.baseURI = "https://reqres.in/api/users?page=2"; 
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.get(""); 
	 // Get all the headers and then iterate over allHeaders to print each header 
		Headers allHeaders = response.headers(); 
	 // Iterate over all the Headers 
		 for(Header header : allHeaders) { 
		   System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
		 } 
	}
	
	//single header
	
//	@Test
	public void GetuserHeaders() { 
	RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get(""); 
	// Access header with a given name. 
	String contentType = response.header("Content-Type"); 
	System.out.println("Content-Type value: " + contentType); 
	// Access header with a given name. 
	String serverType = response.header("Server"); 
	System.out.println("Server value: " + serverType); 
	// Access header with a given name. Header = Content-Encoding 
	String acceptLanguage = response.header("Content-Encoding"); 
	System.out.println("Content-Encoding: " + acceptLanguage); 
	  } 
	
	
	@Test
	public void ValidateBookHeaders() 
	{ 
	RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("");
	// Access header with a given name. Header = Content-Type 
	String contentType = response.header("Content-Type"); 
	Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */); 
	// Access header with a given name. Header = Server 
//	String serverType = response.header("Server"); 
//	Assert.assertEquals(serverType /* actual value */, "nginx/1.17.10 (Ubuntu)" /* expected value */);


}
}
