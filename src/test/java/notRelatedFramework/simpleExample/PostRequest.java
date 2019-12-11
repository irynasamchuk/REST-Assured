package notRelatedFramework.simpleExample;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequest {

    @Test
    public void registrationSuccessful()
    {
        //Specify base URl
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request Payload sending along with post request
        JSONObject requstParams = new JSONObject();
        requstParams.put("FirstName", "Ira123123");
        requstParams.put("LastName","Larson");
        requstParams.put("UserName","Jonny1234");
        requstParams.put("Password","Jonny1234");
        requstParams.put("Email", "mytestemail12@gmail.com");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requstParams.toJSONString()); //attach data to the request

        //response object(sent request)
        Response response = httpRequest.request(Method.POST, "/register");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " +responseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 201);

        //status line verification
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode,"OPERATION_SUCCESS");
    }
}
