package basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestAuth extends BaseRequest{
	@Test
	public void get() {
		Response response = 
				spec
				.param("priority", "5")
				.param("number", "INC0000012")
				.get("https://dev38348.service-now.com/api/now/table/incident");
		System.out.println(response.prettyPrint());

		JsonPath jsonPath = response.jsonPath();
		List<String> list = jsonPath.getList("result.number");
		int size = list.size();
		System.out.println(size);

		String number = list.get(0);
		System.out.println(number);







	}







}
