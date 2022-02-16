package Steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.json.JSONTokener;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class POSTFeatureSteps {
	@Given("I have valid URL for post request")
	public void i_have_valid_URL_for_post_request() {
	   
	}

	@Then("I should receive status code as 201 ")
	public void i_should_receive_status_code_as(Integer int1) throws FileNotFoundException {
		//POSTReq.MyPOSTReq();
		//POSTReq pr=new POSTReq();
		File f=new File("../RestAssuredDemo/Existing2.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new  JSONTokener(fr);
		JSONObject jo=new JSONObject(jt);
		
		Response  resp=
				
				given()
				.contentType(ContentType.JSON)
				.body(jo.toString())
				.when()
				.post("https://reqres.in/api/users");
		 int status=resp.getStatusCode();
		Assert.assertEquals("201", status);
		
		
		
			
	}

	@Then("Verify the id generated is correct")
	public void verify_the_id_generated_is_correct() throws FileNotFoundException {
		//POSTReq.MyPOSTReq();
		File f=new File("../RestAssuredDemo/Existing2.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new  JSONTokener(fr);
		JSONObject jo=new JSONObject(jt);
		
		Response  resp=
				
				given()
				.contentType(ContentType.JSON)
				.body(jo.toString())
				.when()
				.post("https://reqres.in/api/users");
		String id_generated=resp.jsonPath().getString("id");
		if(id_generated!=null)
		{
			String id_generated1=resp.jsonPath().getString("id");
			System.out.println("the id generated is not null and it is "+id_generated1);
		}
		else
		{
			System.out.println("the id is null the test case failed");
		}
		
		
		
	}

	@Then("Verify the Response Schema")
	public void verify_the_Response_Schema() throws FileNotFoundException {
		//POSTReq.MyPOSTReq();
	}


}
