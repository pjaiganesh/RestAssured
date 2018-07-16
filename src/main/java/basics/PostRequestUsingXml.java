package basics;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequestUsingXml extends BaseRequest{
	@Test(/*dataProvider = "data"*/)
	public void post() {
		
		File xmlFile = new File("./data.xml");
		Response response = 
				spec
				.queryParam("sysparm_fields", "sys_id, number, short_description")
				.contentType(ContentType.XML)
				.body(xmlFile)
					.post("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		
		JsonPath jsonPath = response.jsonPath();
		sys_id = jsonPath.get("result.sys_id");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
