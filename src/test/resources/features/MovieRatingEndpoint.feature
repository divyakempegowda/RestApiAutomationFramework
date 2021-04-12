Feature: Rating movies endpoint test feature
  This is feature file tests valid and invalid scenarios of movie rating endpoint (method:- POST endpoint:- /movie/{movie_id}/rating)

  Scenario: Rates movie with valid api_key and guest session id
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    And adds ContentType to header
    And adds movie_id '399566' to path parameter
    And adds guest_session_id as query parameter
    And adds rating value as '8.5' to request body
    When user makes post request to movie rating endpoint
    Then user should get response with status code '201'
    And response body should have followings
      | status_message | Success. |
      | success        |true|

  Scenario: Post ratings to movies with invalid api_key
    Given user setup baseuri to make a request
    And adds invalid api_key as query parameter
    And adds ContentType to header
    And adds movie_id '399566' to path parameter
    And adds guest_session_id as query parameter
    And adds rating value as '5.5' to request body
    When user makes post request to movie rating endpoint
    Then user should get response with status code '401'
    And response body should have followings
      | status_message | Invalid API key: You must be granted a valid key. |
      | success        |false|
      
      
   Scenario: Post ratings to movies with in correct path
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    And adds ContentType to header
    And adds movie_id '399566' to path parameter
    And adds guest_session_id as query parameter
    And adds rating value as '5.5' to request body
    When user makes post request to invalid movie rating endpoint
    Then user should get response with status code '404'
    And response body should have followings
      | status_message | The resource you requested could not be found. |
      
      
      
