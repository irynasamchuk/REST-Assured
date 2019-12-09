import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC004_GetRequestWithAllHeaders {

    @Test
    public void getAllHeaders(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        RequestSpecification httpsRequst = RestAssured.given();

        Response response = httpsRequst.request(Method.GET, "/Hyderabad");

        String responseBody = response.getBody().asString();
        System.out.println("Responce body is: " + responseBody);

        Headers allHeaders = response.getHeaders();  //capture all headers from responce

        for(Header header : allHeaders){
            System.out.println(header.getName()+ " - " +header.getValue());
        }
    }
}
