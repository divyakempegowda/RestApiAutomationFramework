package org.themoviedb.base;
/**
* This class is to hold request and response objects
* This will be used in creating request spec and it holds last response made using request spec
*
* @author  Divya S K
*/
import static org.themoviedb.constants.Constants.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.themoviedb.constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomRequestBuilder {
	
	private static RequestSpecification requestSpecification;
	private static Response response;
	private static String guestSessionId;

	public static RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}
	
	public static Response getLastRequestResponse() {
		return response;
	}

	public static void saveResponse(Response response) {
		CustomRequestBuilder.response = response;
	}

	public static void createRequestWithBaseUriAndPath() {
		requestSpecification = RestAssured.given().baseUri(BASE_URI).basePath(BASE_PATH).pathParam("version", VERSION_NUMBER).log().all();
	}
	
	/*
	 * As we are not testing guest session end point hence we are directly generating guest session to rate movies.
	 * If guestSessionId is already generated then we use the one generated otherwise we generate one. 
	 */
	public static String getGuestSessionId() {
		if(guestSessionId == null) {
			Response response = RestAssured.given().baseUri(BASE_URI).basePath(BASE_PATH).pathParam("version", VERSION_NUMBER).log().all()
					.queryParam("api_key", API_KEY).get(Constants.CREATE_GUEST_SESSION_PATH);
					response.then().statusCode(200).and()
					.body("success", equalTo(true), "guest_session_id", not(nullValue()));
					Map<String,Object> respBody = response.getBody().as(Map.class);
				 guestSessionId = (String) respBody.get("guest_session_id");
		}
		return guestSessionId;
	}
}
