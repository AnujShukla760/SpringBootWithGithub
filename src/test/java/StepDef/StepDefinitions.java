package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

        private int num1;
        private int num2;
        private int result;
        private  Calculator calculator;  // assuming there's a StepDef.Calculator class to handle the addition

    private Response response;
        @When("I click on add")
        public void i_Click_On_Add() {
            result = calculator.add(num1, num2);  // Perform the addition
        }

        @Then("The result is {int}")
        public void the_Result_Is(int expectedResult) {
            assertEquals(expectedResult, result);  // Check if the result matches the expected value
        }


    @Given("The two numbers are {string} and {string}")
    public void theTwoNumbersAreAnd(String arg0, String arg1) {
        this.num1 = Integer.parseInt(arg0);
        this.num2 = Integer.parseInt(arg1);
        calculator = new Calculator();
        System.out.println(arg0);
        System.out.println(arg1);

    }
    }








