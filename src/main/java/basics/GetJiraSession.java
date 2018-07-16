package basics;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.internal.filter.FormAuthFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetJiraSession{
	@Test
	public void post() {
		
		FormAuthFilter filter = new FormAuthFilter();
		
		Response response = 
				RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("testleaf0177@gmail.com", "Leaf@1234")
				.filter(filter)
				.get("https://testleafjune2018.atlassian.net/rest/api/2/issue/10024");
		System.out.println(response.prettyPrint());
		
		System.out.println(filter);
		
		response = 
				RestAssured
				.given()
				.filter(filter)
				.get("https://testleafjune2018.atlassian.net/rest/api/2/issue/10024");
		
		System.out.println(response.statusCode());
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
