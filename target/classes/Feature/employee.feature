Feature: user is adding new details
  Scenario: to POST the details
    When User is hitting the post API
    Then Response Code should be 201