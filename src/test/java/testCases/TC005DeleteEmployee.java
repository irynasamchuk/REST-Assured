package testCases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005DeleteEmployee extends TestBase {
    RequestSpecification httpRequest;
    Response response;

    @BeforeClass
    public void deleteEmployee() throws InterruptedException {
        logger.info("****Started TC005DeleteEmployee****");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        httpRequest = RestAssured.given();

        response = httpRequest.request(Method.GET, "/employees");

        // first get the JSON object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        //Capture ID
        String empId = jsonPathEvaluator.get("[0].id");
        response = httpRequest.request(Method.DELETE, "/delete/" + empId);
        Thread.sleep(5000);
    }

    @Test
    public void checkResponseBody(){
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("successfully! deleted Records"));

        logger.info("****Employee is deleted****");
    }

}
