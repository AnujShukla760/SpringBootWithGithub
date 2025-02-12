@employee
Feature: Employee API Basic Test

  Scenario: Check if Employee API is running
    Given create the request body
    When the client sends a POST request
    Then the response status should be 201