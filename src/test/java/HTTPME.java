import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HTTPME {
	@Test
	public void putMethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res= RestAssured.given().body("{\r\n"
				+ "    \"id\": \"1\",\r\n"
				+ "    \"title\": \"foo\",\r\n"
				+ "    \"body\": \"bar\",\r\n"
				+ "    \"userId\": \"1\"\r\n"
				+ "  }").header("Content-type", "application/json; charset=UTF-8").
		put("/posts/1");
		System.out.println("response body "+res.getBody());
		System.out.println("status code "+res.statusCode());
		System.out.println("time "+res.time());
		Assert.assertEquals(res.statusCode(),200);
	}
	
	@Test
	public void patchmethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"title\": \"foo\"\r\n"
				+ "  }").header("Content-type","application/json; charset=UTF-8").
		patch("/posts/1");
		
		System.out.println("response string"+res.asPrettyString());
		System.out.println("response time"+res.time());
		
	}

}
