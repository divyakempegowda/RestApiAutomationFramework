package org.themoviedb.stepdefinitions;
/**
* This class hold step definitions in particular to movie rating endpoint.
* Endoint:- /movie/{movie_id}/rating
*
* @author  Divya S K
*/
import org.json.JSONObject;
import org.themoviedb.base.CustomRequestBuilder;
import static org.themoviedb.constants.Constants.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class MovieRatingStepDefinitions extends CustomRequestBuilder {

	@And("^adds movie_id '(\\d+)' to path parameter$")
	public void addMovieIdToPathParameter(int movieId) {
		getRequestSpecification().pathParam("movie_id", movieId);
	}

	@And("^adds ContentType to header$")
	public void addContentTypeToHeader() {
		getRequestSpecification().header("Content-Type","application/json");
	}

	@And("^adds guest_session_id as query parameter$")
	public void addGuestSessionIdAsQueryParam() {
		getRequestSpecification().queryParam("guest_session_id", getGuestSessionId());
	}

	@And("^adds rating value as '(\\d+.\\d+)' to request body$")
	public void addRatingToRequestBody(Double rating) {
		JSONObject requestBody = new JSONObject();
		requestBody.put("value", rating);
		getRequestSpecification().body(requestBody.toString());

	}

	@When("^user makes post request to rating movie endpoint$")
	public void postRequestToMovieRatingEndpoint() {
		Response response = getRequestSpecification().post(MOVIE_RATING_PATH);
		saveResponse(response);
		
	}
	
	@When("^user makes post request to rating invalid movie endpoint$")
	public void postRequestToInvalidMovieRatingEndpoint() {
		Response response = getRequestSpecification().post(MOVIE_RATING_PATH_INVALID);
		saveResponse(response);
	}
	
	@When("^user makes delete request to rating movie endpoint$")
	public void deleteRequestToMovieRatingEndpoint() {
		Response response = getRequestSpecification().delete(MOVIE_RATING_PATH);
		saveResponse(response);
	}

}
