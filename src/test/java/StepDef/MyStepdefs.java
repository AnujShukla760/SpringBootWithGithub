package StepDef;

import com.example.Employee.Model.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import org.junit.Before;

public class MyStepdefs {
    private RequestSpecification requestSpecification;
    private Response response;
    private ObjectMapper objectMapper=new ObjectMapper();
    @Before
    public void setTup(){
        requestSpecification = RestAssured.given().contentType("application/json");

    }
    @Given("create the request body")
    public void createTheRequestBody() throws JsonProcessingException {
        Employee employee=new Employee();
        employee.setName("Anuj");
        employee.setEmailId("shuklaanuj312@gmail.com");
        String requestBody= objectMapper.writeValueAsString(employee);

        requestSpecification=RestAssured.given().contentType("application/json").body(requestBody);
    }
    @When("the client sends a POST request")
    public void theClientSendsAPOSTRequest() {
        response= requestSpecification.post("http://localhost:8080/emp/create");

    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int arg0) {
int actualResponseCode= response.getStatusCode();
        Assert.assertEquals(arg0, actualResponseCode);


    }
}
