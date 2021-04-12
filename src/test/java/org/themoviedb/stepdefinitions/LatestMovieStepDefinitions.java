package org.themoviedb.stepdefinitions;
/**
* This class hold step definitions in particular to latest movies endpoint endoint:- /movie/latest
*
* @author  Divya S K
*/
import org.themoviedb.base.CustomRequestBuilder;
import org.themoviedb.constants.Constants;

import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class LatestMovieStepDefinitions extends CustomRequestBuilder {
	
	@When("^user makes get request to latest movie endpoint$")
	public void makeGetRequestToPopularMovieEndpoint() {
	    Response response = getRequestSpecification().get(Constants.LATEST_MOVIE_PATH);
	    saveResponse(response);
	}
	
	@When("^user makes get request to invalid latest movie endpoint$")
	public void makeGetRequestToInvalidPopularMovieEndpoint() {
	    Response response = getRequestSpecification().get(Constants.LATEST_MOVIE_PATH_INVALID);
	    saveResponse(response);
	}

}
