package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream(getGlobalValue("logFileName")));
		   RequestSpecification req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
		    		.addQueryParam("key","qaclick123")
		    		.addFilter(RequestLoggingFilter.logRequestTo(log))
		    		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		    		.setContentType(ContentType.JSON).build();
		   return req;
	}
	
	public static String getGlobalValue(String key) throws IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\framework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		  String resp = response.asString();
		    JsonPath jp = new JsonPath(resp);
		    return jp.getString(key);
	}
}