package basics;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class UseCookies {
	@Test
	public void get() {
		
	/*	BasicAuthScheme auth = new BasicAuthScheme();
		auth.setUserName("admin");
		auth.setPassword("Tuna@123");
		
		RestAssured.authentication = auth;*/
		Response response = 
				RestAssured
				.given()
				.auth()
				.basic("admin", "Tuna@123")
				.get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		
		String cookie = response.getCookie("JSESSIONID");
		System.out.println(cookie);
		System.out.println("***********************************");
		
		
		Cookie session = new Cookie
				.Builder("JSESSIONID",cookie)
				.build();
		
		response = 
				RestAssured
				.given()
				.cookie(session)
				.when()
				.get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		System.out.println("***********************************");

		
	}

	
	
	
	
	
	
}
