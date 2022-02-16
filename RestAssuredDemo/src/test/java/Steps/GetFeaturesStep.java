package Steps;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFeaturesStep {
	@Given("I have valid access token and valid URL")
	public void i_have_valid_access_token_and_valid_URL() {
	    
	}


@Then("I should receive status code as {int}")
public void i_should_receive_status_code_as(Integer int1) {
		try{
			Response resp=given().
					when()
					 .get("https://reqres.in/api/users?page=2");
			 int statusCode=resp.getStatusCode();
			assertEquals(statusCode,200);
			System.out.println(resp.getStatusCode());
			System.out.println(resp.asString());
			//int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
				 
	}
	@Then("for {string} the value of {string} should be correct")
	public void for_the_value_of_should_be_correct(String string, String string2) {
		Response resp=given().
				when()
				.get("https://reqres.in/api/users?id=10");
		
		System.out.println(resp.asString());
		String firstname=resp.jsonPath().getString("data.first_name");
		String id=resp.jsonPath().getString("data.id");
		System.out.println("The first name is: " +firstname);
		System.out.println("The id is: " +id);
		Assert.assertEquals("Byron",firstname);
		Assert.assertEquals("10", id);
		
	    
	}
	
	
}
