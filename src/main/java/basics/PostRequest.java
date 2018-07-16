package basics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest extends BaseRequest{
	@Test(/*dataProvider = "data"*/)
	public void post() {
		
		/*List<Header> allHeaders = new ArrayList<Header>();
		allHeaders.add(new Header("",""));
		Headers headers = new Headers(allHeaders);*/
		
		File uploadFile = new File("./data.png");
		Response response = 
				spec
				.queryParam("sysparm_fields", "sys_id, number, short_description")
				//.contentType(ContentType.M)
				.post("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		
		JsonPath jsonPath = response.jsonPath();
		sys_id = jsonPath.get("result.sys_id");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
