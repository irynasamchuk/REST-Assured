package testCases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002GetSingleEmployee extends TestBase {
    public RequestSpecification httpRequest;
    public Response response;

    @BeforeClass
    public void getEmployee() throws InterruptedException {
        logger.info("****Started TC002GetSingleEmployee****");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/employee/" +empID);

        Thread.sleep(3000);
    }

    @Test
    public void checkResponseBody(){
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains((empID)));
    }

    @Test
    public void ResponseTime(){
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime < 6000);
    }

    @Test
    public void checkStatusLine(){
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @AfterClass
    public void tearnDown(){
        logger.info("****Finished TC002GetSingleEmployee****");

    }

}
