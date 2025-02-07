
@Anuj
Feature: To test the functionality of calculator
  @anuj
  Scenario Outline: To add two numbers
    Given The two numbers are "<num1>" and "<num2>"
    When I click on add
    Then The result is <result>

    Examples:
      | num1 | num2 | result |
      |  2   |  3   |   5    |
      |  3   |  5   |   8    |
  @anuj1
  Scenario Outline: To add two numbers
    Given The two numbers are "<num1>" and "<num2>"
    When I click on add
    Then The result is <result>

    Examples:
      | num1 | num2 | result |
      |  2   |  3   |   5    |
      |  3   |  5   |   8    |