
Feature: Employee API Basic Test

  Scenario: Check if Employee API is running
    Given create the request body
    When the client sends a POST request
    Then the response status should be 201

  Scenario: Check if Employee API is running
    Given User wants to get the data
    When the client sends a GET request
    Then the response status should be OK with Code 200

  @DataTable
  Scenario: Check if Employee API is running
    Given create the request body with datable
     |name | email |
     |Anuj |shukla@123 |
     |Rishi|Shukla@231 |
    When the client sends a POST request to server
    Then the response status should be shown as 201

  Scenario: Check if Employee API is running
    Given User wants to get the data from server
    When the client sends a GET request to server
    Then the response status should be OK with shown Code 200
