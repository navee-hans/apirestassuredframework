package stepDefinations;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class StepDefinations extends Utils {
	
	RequestSpecification req;
	ResponseSpecification resSpec;
	Response response;
	String place_id;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload")
	public void add_place_payload() throws IOException 
	{	    	    
	    req = given().spec(requestSpecification())
	    		.body(data.addPlacePayLoad());
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String method) {
		APIResources resourceAPI = APIResources.valueOf(resource);
	    
		resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("Post"))
			response = req.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("DLETE"))
			response = req.when().delete(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response = req.when().get(resourceAPI.getResource());		
	}
	
	@Then("The API call success with api status code {int}")
	public void the_api_call_success_with_api_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String actualStatusValue, String expectedstatusValue) {
	    assertEquals(getJsonPath(response, actualStatusValue),expectedstatusValue);
	}
	
	@Then("I verify place_id created match to the name {string} using {string}")
	public void in_response_body_is_test(String expectedName, String httpMethod) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String placeid = getJsonPath(response, "place_id");  
		req = given().spec(requestSpecification())
		    		.queryParam("place_id", placeid);
		  user_calls_with_post_http_request(httpMethod, "GET");
		  String actualName = getJsonPath(response, "name");
		  assertEquals(actualName, expectedName);
	}
}
