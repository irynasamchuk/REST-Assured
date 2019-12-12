package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class TestBase {
    public static RequestSpecification httpRequest;
    public static Response response;
    public String empID = "1";

    public Logger logger;

    @BeforeClass
    public void setup(){
        logger = Logger.getLogger("EmployeesRestAPI"); //added Logger
        PropertyConfigurator.configure("C:\\Users\\Iryna_Samchuk\\JavaProjects\\RestAssuredTest\\log4j.properties"); //added logger
        logger.setLevel(Level.DEBUG);
    }
}
