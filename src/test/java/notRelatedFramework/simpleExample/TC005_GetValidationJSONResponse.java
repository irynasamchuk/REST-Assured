package notRelatedFramework.simpleExample;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GetValidationJSONResponse {

    @Test
    public void getWeatherDetails()
    {
        //Specify base URl
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        // Response object
        Response response = httpRequest.request(Method.GET, "/Kiev");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " +responseBody);

        Assert.assertEquals(responseBody.contains("Kiev"), true);
    }
}
