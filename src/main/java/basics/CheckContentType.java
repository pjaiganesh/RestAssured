package basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CheckContentType {
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
				.log()
				.all()
				.contentType(ContentType.XML)
				.accept(ContentType.XML)
				.params(parametersMap)
				.get("https://dev38348.service-now.com/api/now/table/change_request");
		
		/*System.out.println(response.prettyPrint());
		System.out.println(response.getContentType());
		
		XmlPath xmlPath = response.xmlPath();
		List<Object> list = xmlPath.getList("response.result.sys_id");
		System.out.println(list.get(0));
		
		*/
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.getTime());
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
}
