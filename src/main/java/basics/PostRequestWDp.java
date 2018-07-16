package basics;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequestWDp {
	@Test(dataProvider = "data")
	public void get(String fileName) {
		
		File jsonFile = new File("./"+fileName);
		BasicAuthScheme auth = new BasicAuthScheme();
		auth.setUserName("admin");
		auth.setPassword("Tuna@123");
		
		RestAssured.authentication = auth;
		Response response = 
				RestAssured
				.given()
				.queryParam("sysparm_fields", "sys_id, number, short_description")
				.contentType(ContentType.JSON)
				.body(jsonFile)
				.post("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());
		
		JsonPath jsonPath = response.jsonPath();
		Object sysId = jsonPath.get("result.sys_id");
		System.out.println(sysId);
	}
	
	@DataProvider(name = "data")
	public Object[][] getData() {
		Object[][] data = new Object[3][1];
		data[0][0] = "post.json";
		data[1][0] = "post2.json";
		data[2][0] = "post3.json";
		return data;
	}
	
	
	
	
	
	
	
	
	
	
}
