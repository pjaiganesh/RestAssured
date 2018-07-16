package basics;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetJiraIssue{
	@Test
	public void post() {
		
		Response response = 
				RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("testleaf0177@gmail.com", "Leaf@1234")
				.get("https://testleafjune2018.atlassian.net/rest/api/2/issue/10024");
		System.out.println(response.prettyPrint());
		
		Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> cookie : cookies.entrySet()) {
			System.out.println(cookie.getKey());
			System.out.println(cookie.getValue());

		}
	
		String token = response.getCookie("atlassian.xsrf.token");
		
		System.out.println(token);
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
