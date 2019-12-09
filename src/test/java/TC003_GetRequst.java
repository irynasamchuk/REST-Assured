import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GetRequst {

    @Test
    public void googleMapTest()
    {
        //Specify base URl
        RestAssured.baseURI = "http://maps.googleapis.com/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        // Response object
        Response response = httpRequest.request(Method.GET, "/Hyderabad");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " +responseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("status live: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
