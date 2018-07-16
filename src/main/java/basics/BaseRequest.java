package basics;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	public static RequestSpecification spec;
	public static String sys_id;
	
	public static Cookie sessionId;
	
	@BeforeSuite
	public void init() {
		 spec = RestAssured
		.given()
		.auth()
		.basic("admin", "Tuna@123");
	}
}
