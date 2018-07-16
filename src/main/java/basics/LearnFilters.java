package basics;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.filter.Filter;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

public class LearnFilters {
	
	
	
	@Test
	public void get() {
		
		SessionFilter filter = new SessionFilter();
	/*	CookieFilter cFilter = new CookieFilter();
		List<Filter> allFilters = new ArrayList<Filter>();
		allFilters.add(filter);
		allFilters.add(cFilter);*/
	
		//RestAssured.filters(filter);
		
		Response response = 
				RestAssured
				.given()
				.auth()
				.basic("admin", "Tuna@123")
				.filter(filter)
				.get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		
		System.out.println(filter.getSessionId());
		response = 
				RestAssured
				.given()
				.filter(filter)
				.get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.statusCode());
		
	}

	
	
	
	
	
	
}
