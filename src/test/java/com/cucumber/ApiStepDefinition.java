package com.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static java.lang.Integer.parseInt;


public class ApiStepDefinition {
     private Response response;
    private Map<String,Object> requestBody;

    private String baseUrl;

    @Given("I add the pet store endpoint")
    public void iSetThePetStoreEndpoint() {
      baseUrl = "https://petstore.swagger.io/v2/user";
    }

    @When("I add a user with following details")
    // Datatable is used to store the data in a form of the table
    public void iCreateAUserWithFollowingDetails(DataTable dataTable) {
        requestBody = new HashMap<>();
        Map<String,String> data = dataTable.asMap(String.class,String.class);

        requestBody.put("id", parseInt(data.get("id")));
        requestBody.put("username",data.get("username"));
        requestBody.put("firstname",data.get("firstname"));
        requestBody.put("lastname",data.get("lastname"));
        requestBody.put("eamil",data.get("email"));
        requestBody.put("password",data.get("password"));
        requestBody.put("phone",data.get("phone"));
        requestBody.put("userStatus", parseInt(data.get("userStatus")));

         response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(baseUrl);


    }

    @Then("I should receive status code {int}")
    public void iShouldYesStatusCode(int status) {
    response.then()

            .statusCode(status);

        System.out.println("Response body :\n"+response.asPrettyString());
    }


    }

