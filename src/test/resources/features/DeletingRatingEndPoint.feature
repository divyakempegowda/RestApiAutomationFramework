Feature: Rating movies endpoint test feature
  This is feature file tests valid and invalid scenarios of Rating movies endpoint (method:- DELETE endpoint:- /movie/{movie_id}/rating)

  Scenario: Delete ratings to movies by valid api_key (with optional parameters)
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    And adds guest_session_id as query parameter
    And adds movie_id '399566' to path parameter
    When user makes delete request to rating movie endpoint
    Then user should get response with status code '200'
    And response body should have followings
      | status_message | The item/record was deleted successfully. |
      | success        | true                                      |
