Feature: Validating Place API's

Scenario: Verify place is added successfully using AddPlaceAPI
	Given Add Place Payload
	When user calls "AddPlaceAPI" with "Post" http request
	Then The API call success with api status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And I verify place_id created match to the name "Forntline Houst" using "GetPlaceAPI"
	
Scenario: Verify place is updated successfully using AddPlaceAPI
	Given Add Place Payload
	When user calls "AddPlaceAPI" with "Post" http request
	Then The API call success with api status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And I verify place_id created match to the name "Forntline Houst" using "GetPlaceAPI"
	
Scenario: Verify place is deleted successfully using AddPlaceAPI
	Given Add Place Payload
	When user calls "AddPlaceAPI" with "Post" http request
	Then The API call success with api status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And I verify place_id created match to the name "Forntline Houst" using "GetPlaceAPI"
	
Scenario: Verify place is get successfully using AddPlaceAPI
	Given Add Place Payload
	When user calls "AddPlaceAPI" with "Post" http request
	Then The API call success with api status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And I verify place_id created match to the name "Forntline Houst" using "GetPlaceAPI"