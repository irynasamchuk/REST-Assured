package testCases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001GetAllEmployees extends TestBase {
    @BeforeClass
    public void getAllEmployees() throws InterruptedException {
        logger.info("****Started TC001GetAllEmployees****");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/employees");

        Thread.sleep(3);
    }

    @Test
    public void checkResponseBody(){
        logger.info("****Checking Response Body****");

        String responseBody = response.getBody().asString();
        logger.info("Response Body==>" + responseBody);

        Assert.assertTrue(responseBody != null);
    }

    @Test
    public void checkStatusCode(){
        logger.info("****Checking Status Code****");

        int statusCode = response.getStatusCode();
        logger.info("Status Code is ==>" +statusCode);

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void checkResponseTime(){
        logger.info("****Checking Response Time****");

        long responseTime = response.getTime();
        logger.info("Response Time is ==>" +responseTime);

        if(responseTime > 2000)
            logger.warn("Response Time is greater than 2000");

        Assert.assertTrue(responseTime < 2000);
    }

    @Test
    public void checkStatusLine(){
        logger.info("****Checking Status Line****");

        String statusLine = response.getStatusLine();
        logger.info("Status Line is ==>" +statusLine);

        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void checkContentType(){
        logger.info("****Checking Content Type****");

        String contentType = response.header("Content-Type");
        logger.info("Content Type is ==>" + contentType);

        Assert.assertEquals(contentType, "text/html; charset=UTF-8");
    }

    @Test
    public void checkServerType(){
        logger.info("****Checking Server Type****");

        String serverType = response.header("Server");
        logger.info("Server is ==>" + serverType);

        Assert.assertEquals(serverType, "nginx/1.16.0");
    }

    @Test
    public void checkContentEncoding(){
        logger.info("****Checking Content Encoding****");

        String contentEncoding = response.header("Content-Encoding");
        logger.info("Content Encoding is ==>" + contentEncoding);

        Assert.assertEquals(contentEncoding, "gzip");
    }

    @Test
    public void checkContentLength(){
        logger.info("****Checking Content Length****");

        String contentLength = response.header("Content-Length");
        logger.info("Content Length is ==>" + contentLength);

        // if(Integer.parseInt(contentLength) < 100)
        if((contentLength.length()) < 100)
            logger.warn("Content Length is less than 100");

        Assert.assertTrue((contentLength.length()) > 100);
    }

    @Test
    public void checkCookies() {
        logger.info("****Checking Cookies****");

        String cookies = response.getCookie("PHPSESSID");
        logger.info("Cookies is ==>" + cookies);
    }

    @AfterClass
    public void tearnDown(){
        logger.info("****Finished TC001GetAllEmployees****");
    }
}
