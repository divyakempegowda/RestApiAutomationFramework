package org.themoviedb.stepdefinitions;
/**
* This class hold step definitions in particular to movies palying now endpoint.
* Endoint:- /movie/now_playing
*
* @author  Divya S K
*/
import org.themoviedb.base.CustomRequestBuilder;
import org.themoviedb.constants.Constants;

import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class NowPlayingMovieStepDefinitions extends CustomRequestBuilder{

	@When("^user makes get request to nowPlaying movie endpoint$")
	public void makeGetRequestToNowPlayingMovieEndpoint() {
	    Response response = getRequestSpecification().get(Constants.NOWPLAYING_MOVIE_PATH);
	    saveResponse(response);
	}
	
	@When("^user makes get request to invalid nowPlaying movie endpoint$")
	public void makeGetRequestToInvalidNowPlayingMovieEndpoint() {
	    Response response = getRequestSpecification().get(Constants.NOWPLAYING_MOVIE_PATH_INVALID);
	    saveResponse(response);
	}
}
