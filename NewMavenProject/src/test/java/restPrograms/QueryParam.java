package restPrograms;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParam {

	@Test
	public void queryParameter() {
		//Defining the base URI
		RestAssured.baseURI= "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		//Passing the resource details
		Response res = httpRequest.queryParam("page","2").get("users");
		//Retrieving the response body using getBody() method
		ResponseBody body = res.body();
		//Converting the response body to string object
		String rbdy = body.asString();
		//Creating object of JsonPath and passing the string response body as parameter
		JsonPath jpath = new JsonPath(rbdy);
		//Storing publisher name in a string variable
		String name = jpath.getString("data[3].first_name");
		System.out.println("The name is - "+name);
	}
}
