import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_ExtractValuesOfEachNodeJsonResoince {

    @Test
    public void getWeatherDetails(){
        //Specify base URl
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        // Response object
        Response response = httpRequest.request(Method.GET, "/Kiev");

        JsonPath jsonPath = response.jsonPath(); //allow to save json into variable

        String city = jsonPath.get("City");

        System.out.println(city);
        System.out.println((String) jsonPath.get("Temperature"));
        System.out.println((String) jsonPath.get("WeatherDescription"));

        Assert.assertEquals(city, "Kiev");
    }
}
