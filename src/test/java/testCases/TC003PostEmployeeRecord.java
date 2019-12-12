package testCases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.RestUtils;

;import java.util.HashMap;
import java.util.Map;

public class TC003PostEmployeeRecord extends TestBase {
//    public RequestSpecification httpRequest;
//    public Response response;

    String empName = RestUtils.empName();
    String empSalary = RestUtils.empSal();
    String empAge = RestUtils.empAge();

    @BeforeClass
    public void createEmployee() throws InterruptedException {
        logger.info("****Started TC002GetSingleEmployee****");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();

        //JSONobject is a class that represents a simple JSON. We can Kay-Value pair using put method

        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("name", empName);
        jsonMap.put("salary", empSalary);
        jsonMap.put("age", empAge);
        JSONObject requestParams = new JSONObject(jsonMap);

        //Add a header starting the Request body is a JSON
        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toJSONString());

        response = httpRequest.request(Method.POST, "/create");

        Thread.sleep(5000);
    }

    @Test
    public void checkResponseBody(){
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        System.out.println(empName);
        System.out.println(empSalary);
        System.out.println(empAge);
        Assert.assertTrue(responseBody.contains(empName));
        Assert.assertTrue(responseBody.contains(empSalary));
        Assert.assertTrue(responseBody.contains(empAge));
    }

    @Test
    public void checkStatusCode(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @AfterClass
    public void tearnDown(){
        logger.info("**** Finished TC003PostEmployeeRecord****");

    }
}
