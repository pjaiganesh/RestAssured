package basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequests {
	@Test
	public void get() {
		BasicAuthScheme auth = new BasicAuthScheme();
		auth.setUserName("admin");
		auth.setPassword("Tuna@123");
		
		Map<String, String> parametersMap = 
				new HashMap<String, String>();
		parametersMap.put("type", "normal");
		parametersMap.put("sys_created_by", "admin");
		
		RestAssured.authentication = auth;
		Response response = 
				RestAssured
				.given()
				.params(parametersMap)
				.get("https://dev38348.service-now.com/api/now/table/change_request");
		
		JsonPath jsonPath = response.jsonPath();
		List<Object> list = jsonPath.getList("result");
		System.out.println(list.size());
		System.out.println(list.get(0));
		//System.out.println();
		
		// sys_created_by
		
		// type
		
		
		
		
		//System.out.println(response.prettyPrint());
	}

	
	
	
	
	
	
}
