Feature: Popular movies endpoint test feature
  This is feature file tests valid and invalid scenarios of popular movies endpoint (method:- GET endpoint:- /movie/popular)

  Scenario: Get list of popular movies by valid api_key (without optional parameters)
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    When user makes get request to popular movie endpoint
    Then user should get response with status code '200'
    And the page value in respose body should be '1'
    And user validates 'popularMovie' responsebody with expected data

  Scenario: Get list of popular movies by valid api_key (with optional parameters)
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    And adds 'language' query param with value 'es-ES'
    And adds 'page' query param with value '1'
    And adds 'region' query param with value 'ES'
    When user makes get request to popular movie endpoint
    Then user should get response with status code '200'
    And the page value in respose body should be '1'
    And user validates 'popularMovie' responsebody with expected data

  Scenario: User makes GET request to popular movie endpoint with invalid api_key
    Given user setup baseuri to make a request
    And adds invalid api_key as query parameter
    When user makes get request to popular movie endpoint
    Then user should get response with status code '401'
    And response body should have followings
      | status_message | Invalid API key: You must be granted a valid key. |
      | success        |false|

  Scenario: User makes GET request to popular movie endpoint with in correct path
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    When user makes get request to invalid popular movie endpoint
    Then user should get response with status code '404'
    And response body should have followings
      | status_message | The resource you requested could not be found. |
