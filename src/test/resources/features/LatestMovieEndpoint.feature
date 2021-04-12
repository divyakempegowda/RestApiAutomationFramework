Feature: Latest movies endpoint test feature
  This is feature file tests valid and invalid scenarios of latest movies endpoint (method:- GET endpoint:- /movie/latest)

  Scenario: Get list of latest movies by valid api_key (without optional parameters)
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    When user makes get request to latest movie endpoint     
    Then user should get response with status code '200'
    And user validates 'latestMovie' responsebody with expected data

  Scenario: Get list of latest movies by valid api_key (with optional parameters)
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    And adds 'language' query param with value 'en-US'
    When user makes get request to latest movie endpoint
    Then user should get response with status code '200'
    And user validates 'latestMovie' responsebody with expected data

  Scenario: User makes GET request to latest movie endpoint with invalid api_key
    Given user setup baseuri to make a request
    And adds invalid api_key as query parameter
    When user makes get request to latest movie endpoint
    Then user should get response with status code '401'
    And response body should have followings
      | status_message | Invalid API key: You must be granted a valid key. |
      | success        |false|

  Scenario: User makes GET request to latest movie endpoint with in correct path
    Given user setup baseuri to make a request
    And adds api_key as query parameter
    When user makes get request to invalid latest movie endpoint
    Then user should get response with status code '404'
    And response body should have followings
      | status_message | The resource you requested could not be found. |
  