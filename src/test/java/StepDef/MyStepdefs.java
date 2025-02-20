package StepDef;

import com.example.Employee.Model.Employee;
import io.cucumber.datatable.DataTable;
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
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Map;

public class MyStepdefs {
    private RequestSpecification requestSpecification;
    private Response response;
    private ObjectMapper objectMapper=new ObjectMapper();
//    @Before
//    public void setTup(){
//        requestSpecification = RestAssured.given().contentType("application/json");
// ********************* (ISKO TB USE KRO JB HMNE KOI CHEEZ CUCUMBER SE PEHLE RUN KRNI H )*************************
//    }
    @Given("create the request body")
    public void createTheRequestBody() throws JsonProcessingException {
        Employee employee=new Employee();
        employee.setName("Anuj");
        employee.setEmailId("shuklaanuj312@gmail.com");
        String requestBody= objectMapper.writeValueAsString(employee);

        requestSpecification=RestAssured.given().contentType("application/json").body(requestBody);
        //******************** (yha hm ye skip kr skte h agr hm @Before use krege to)****************
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

    @Given("User wants to get the data")
    public void userWantsToGetTheData() {
        requestSpecification=RestAssured.given().contentType("application/json");

    }

    @When("the client sends a GET request")
    public void theClientSendsAGETRequest() {
        response= requestSpecification.get("http://localhost:8080/emp/get");

    }

    @Then("the response status should be OK with Code {int}")
    public void theResponseStatusShouldBeOKWithCode(int arg0) {
        int actualGetResponseCode= response.getStatusCode();
        Assert.assertEquals(arg0,actualGetResponseCode);
    }
 ///  @@@@@@@@@@@@@@@@ Here we are using the DataTable concept to input data at the runtime and to take the use of BASE URL @@@@@@@@@@@@@@@@@@@@@@
//@Value("${base.Url}")
String baseUrl="http://localhost:8080";

    @Given("create the request body with datable")
    public void createTheRequestBodyWithDatable(DataTable dataTable) throws JsonProcessingException {
        Map<String,String> data =dataTable.asMap(String.class, String.class);
        String name =data.get("name");
        String email=data.get("email");
        Employee employee=new Employee();
        employee.setName(name);
        employee.setEmailId(email);
        String requestBody = objectMapper.writeValueAsString(employee);
        requestSpecification = RestAssured.given().contentType("application/json").body(requestBody);
    }

    @When("the client sends a POST request to server")

    public void theClientSendsAPOSTRequestToServer() throws IOException {
      //  UtilityClass.readFile();
      String url=  UtilityClass.getProperty("url");
        response=requestSpecification.post(url+"/emp/create");


    }

    @Then("the response status should be shown as {int}")
    public void theResponseStatusShouldBeShownAs(int arg0) {
        int actualPostResponseCode= response.getStatusCode();
        Assert.assertEquals(actualPostResponseCode,arg0);
    }

    @Given("User wants to get the data from server")
    public void userWantsToGetTheDataFromServer() {
        requestSpecification=RestAssured.given().contentType("application/json");
    }

    @When("the client sends a GET request to server")
    public void theClientSendsAGETRequestToServer() {
       response=requestSpecification.get(baseUrl+"/emp/get");

    }

    @Then("the response status should be OK with shown Code {int}")
    public void theResponseStatusShouldBeOKWithShownCode(int arg0) {

    }
}
