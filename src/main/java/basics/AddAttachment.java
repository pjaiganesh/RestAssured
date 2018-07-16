package basics;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddAttachment{
	@Test
	public void post() {
		
		File uploadFile = new File("./Path.png");
		Response response = 
				RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("testleaf0177@gmail.com", "Leaf@1234")
				.header(new Header("X-Atlassian-Token", "no-check"))
				.multiPart(uploadFile)
				.post("https://testleafjune2018.atlassian.net/rest/api/2/issue/10024/attachments");
		System.out.println(response.prettyPrint());
		
		
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
