package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;

public class DeleteRequest extends BaseRequest{
	
	//String sys_id ="a5ace9a10f931300b02748dce1050ec3";
	
	@Test(dependsOnMethods = "basics.PostRequest.post")
	public void delete() {
		
		Response response = 
				spec
				.delete("https://dev38348.service-now.com/api/now/table/incident/"+sys_id);
		response.prettyPrint();
		System.out.println(response.statusCode());
		
	}

	
	
	
	
	
	
}
