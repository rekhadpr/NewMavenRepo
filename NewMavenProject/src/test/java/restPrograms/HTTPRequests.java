package restPrograms;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class HTTPRequests {
int id;
//	@Test(priority=1)
	void getUsers()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200).body("page",equalTo(2))
			.log().all();
		
	}
	
	@Test(priority=2)
	void createUser()
	{
		//HashMap data=new HashMap();
		
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("name", "rekha");
		data.put("job", "tester");
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//then()
		//	.statusCode(201)
		//	.log().all();
		System.out.println("value of id is:"+id);
	}
	

	@Test(priority=3,dependsOnMethods = "createUser")	
	void updateUser()
	{
		//HashMap data=new HashMap();
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("name", "Neeta");
		data.put("job", "Senior tester");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(200)
			.log().all();
		System.out.println("the id is:"+id);
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
	
}
