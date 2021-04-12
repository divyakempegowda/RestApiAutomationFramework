package org.themoviedb.stepdefinitions;
/**
* This class hold step definitions in particular to popular movie endpoint.
* Endoint:- /movie/popular
*
* @author  Divya S K
*/
import org.themoviedb.base.CustomRequestBuilder;
import org.themoviedb.constants.Constants;

import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PopularMovieStepDefinitions extends CustomRequestBuilder{
	

	@When("^user makes get request to popular movie endpoint$")
	public void makeGetRequestToPopularMovieEndpoint() {
	    Response response = getRequestSpecification().get(Constants.POPULAR_MOVIE_PATH);
	    saveResponse(response);
	}
	
	@When("^user makes get request to invalid popular movie endpoint$")
	public void makeGetRequestToInvalidPopularMovieEndpoint() {
	    Response response = getRequestSpecification().get(Constants.POPULAR_MOVIE_PATH_INVALID);
	    saveResponse(response);
	}
}
