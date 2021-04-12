package org.themoviedb.constants;
/**
* This class holds the URI, all the PATHS and API_KEY as constants
*
* @author  Divya S K
*/
public class Constants {
	
	/*
	 * Some of these values should go in to properties file in real time 
	 * The properties file will have values according to env like dev, QA, UAT and prod etc
	 */
	public static final String BASE_URI = "https://api.themoviedb.org";
	public static final String API_KEY = "61f744c5753269c8674e442587d7fd75";
	public static final String VERSION_NUMBER = "3";
	public static final String BASE_PATH = "/{version}/";
	public static final String POPULAR_MOVIE_PATH = "/movie/popular";
	public static final String LATEST_MOVIE_PATH = "/movie/latest";
	public static final String NOWPLAYING_MOVIE_PATH = "/movie/now_playing";
	public static final String CREATE_GUEST_SESSION_PATH = "/authentication/guest_session/new";
	public static final String MOVIE_RATING_PATH = "/movie/{movie_id}/rating";
	
	
	
	/*
	 * These are invalid constants 
	 */
	public static final String API_KEY_INVALID = "61f744c5753269c8674e442587d7fd78";
	public static final String POPULAR_MOVIE_PATH_INVALID = "/movie/popular1";
	public static final String LATEST_MOVIE_PATH_INVALID = "/movie/latest1";
	public static final String NOWPLAYING_MOVIE_PATH_INVALID = "/movie/now_playing1";
	public static final String MOVIE_RATING_PATH_INVALID = "/movie/{movie_id}/rating1";

}
