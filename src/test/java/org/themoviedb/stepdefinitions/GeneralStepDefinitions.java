package org.themoviedb.stepdefinitions;
/**
* This class hold step definitions in general we use across the feature files
* Those which are specific will be in its own endpoint file
*
* @author  Divya S K
*/

import static org.themoviedb.constants.Constants.*;
import java.util.Iterator;
import java.util.Map;
import org.themoviedb.base.CustomRequestBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class GeneralStepDefinitions extends CustomRequestBuilder{
	@Given("^user setup baseuri to make a request$")
	public void createRequestObjectWithBaseURIAndPath() {
	    createRequestWithBaseUriAndPath();
	}
	
	
	@Given("^adds api_key as query parameter$")
	public void addApiKeyAsQueryParam() {
	    getRequestSpecification().queryParam("api_key", API_KEY);
	}
	
	@Given("^adds invalid api_key as query parameter$")
	public void addInvalidApiKeyAsQueryParam() {
	    getRequestSpecification().queryParam("api_key", API_KEY_INVALID);
	}
	
	@Then("^user should get response with status code '(\\d+)'$")
	public void validateStatusCode(Integer statusCode) {
		getLastRequestResponse().then().statusCode(statusCode);
	}
	
	@And("^the page value in respose body should be '(\\d+)'$")
	public void validatePageNumberInResponseBody(Integer expectedValue) {
		getLastRequestResponse().then().body("page", equalTo(expectedValue));
	}
	
	/*
	 * This is the method which compares body with expected schema where we verify whether field has correct datatype
	 * Everytime when new feature file adds this step then they must add a case here to support new schema if it not present
	 */
	@Then("^user validates '(.*?)' responsebody with expected data$")
	public void validateResponsebodyWithExpectedSchema(String endpointType) throws Exception {
		String schemaFileName;
		switch (endpointType.toLowerCase()) {
		case "popularmovie":
			schemaFileName = "json/popularSchema.json";
			break;
		case "latestmovie":
			schemaFileName = "json/latestSchema.json";
			break;
		case "nowplayingmovie":
			schemaFileName = "json/nowplayingSchema.json";
			break;
		default:
			schemaFileName = null;
			throw new Exception("Unable to match endpointType. Endpoint type "+endpointType+" doesn't have schema json file");
		}
		getLastRequestResponse().then().contentType(ContentType.JSON).body(matchesJsonSchemaInClasspath(schemaFileName));
	    
	}
	
	@Then("^response body should have followings$")
	public void validateDataInResponseBody(DataTable dataTable) {
	    Map<String,Object> expectedDataMap = dataTable.asMap(String.class, Object.class);
	    Iterator<Map.Entry<String, Object>> it = expectedDataMap.entrySet().iterator();
	    while(it.hasNext()) {
	    	Map.Entry<String, Object> en = it.next();
	    	if(en.getKey().equalsIgnoreCase("success")) {
	    		//TODO Dont know how to pass boolean from datatable. Never did that before hence make small trick to work
	    		boolean value = en.getValue().equals("false")?Boolean.FALSE : Boolean.TRUE;
	    		getLastRequestResponse().then().body(en.getKey(), equalTo(value));
	    	}else {
	    		getLastRequestResponse().then().body(en.getKey(), equalTo(en.getValue()));
	    	}
	    	
	    }
	}
	
	@And("^adds '(.*?)' query param with value '(.*?)'$")
	public void addsQueryParamWithValueToRequest(String paramName, Object paramValue) {
		getRequestSpecification().queryParam(paramName, paramValue);
	}
}
