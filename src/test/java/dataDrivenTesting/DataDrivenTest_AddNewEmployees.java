package dataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest_AddNewEmployees {

    @Test(dataProvider = "empDataProvider")
    public void postNewEmployees(String eName, String eSalary, String eAge)
    {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        // create request object
        RequestSpecification httpRequest = RestAssured.given();

        //Here we created data whitch we can send along with the post request
        JSONObject requestParams  = new JSONObject();
        requestParams.put("name", eName);
        requestParams.put("salary", eSalary);
        requestParams.put("age", eAge);

        // Add a header starting the request body is a JSON
        httpRequest.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        // POST Request
        Response response = httpRequest.request(Method.POST, "/create");

        //capture response body to perform validations
        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);

        Assert.assertEquals(responseBody.contains(eName), true);
        Assert.assertEquals(responseBody.contains(eSalary), true);
        Assert.assertEquals(responseBody.contains(eAge), true);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @DataProvider(name = "empDataProvider")
    Object[][] getEmployeeData()
    {
        String employeeData [][] = {{"Smitt011", "12000", "23"}, {"Smitt021", "12000", "23"}, {"Smitt031", "12000", "23"}};
        return  (employeeData);
    }

}
