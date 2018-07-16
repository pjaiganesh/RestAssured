package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;

public class GetRequest {
	@Test
	public void get() {
		BasicAuthScheme auth = new BasicAuthScheme();
		auth.setUserName("admin");
		auth.setPassword("Tuna@123");
		
		RestAssured.authentication = auth;
		Response response = 
				RestAssured.
				get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
	}

	
	
	
	
	
	
}
