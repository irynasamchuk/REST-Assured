package utilities;

import org.apache.commons.lang3.RandomStringUtils;


public class RestUtils {
    public static String empName(){
        String generatedString = RandomStringUtils.random(2);
        return ("Kate" + generatedString);
    }

    public static String empSal(){
        return RandomStringUtils.random(4);
    }

    public static String empAge(){
        return RandomStringUtils.random(3);
    }
}
