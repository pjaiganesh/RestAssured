package basics;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;

public class ExpectStatus {
	@Test
	public void get() {
		BasicAuthScheme auth = new BasicAuthScheme();
		auth.setUserName("admin");
		auth.setPassword("Tuna@123");
		
		RestAssured.authentication = auth;
		Response response = 
				RestAssured
				.given()
				.expect()
				.statusCode(200)
				.and()
				//.time(Matcher.matches, TimeUnit.MILLISECONDS)
				
				.when()
				.get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		
		long time = response.getTime();
		if(time < 4000) {
			
		}
	}

	
	
	
	
	
	
}
