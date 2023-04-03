import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HttpMethods {
	@Test
	public void getMethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response res=RestAssured.given()
				   .header("Content-Type","application/json; charset=UTF-8")
		           .when()
		           .get("posts/1");
		System.out.println("responce body "+res.getBody().asString());
		System.out.println("status code "+res.statusCode());
		Assert.assertEquals(200, res.statusCode());
	}
	@Test
	public void postmethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"title\": \"foo\",\r\n"
				+ "    \"body\": \"bar\",\r\n"
				+ "    \"userId\": \"1\"\r\n"
				+ "  }")
				     .header("Content-type", "application/json; charset=UTF-8").when().
				     post("posts");
		System.out.println("responce body "+res.getBody().asString());
		System.out.println("status code "+res.statusCode());
		System.out.println("res time "+res.time());
		
		Assert.assertEquals(201, res.statusCode());
		Headers he=res.getHeaders();
		for (Header header : he) {
			System.out.println((header.getName()+" "+header.getValue()));
			
		}
	}
	@Test
	public void putMethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response resp=RestAssured.given().body("{\r\n"
				+ "    \"id\": \"1\",\r\n"
				+ "    \"title\": \"foo\",\r\n"
				+ "    \"body\": \"Testing Api\",\r\n"
				+ "    \"userId\": \"1\"\r\n"
				+ "  }").header("Content-type", "application/json; charset=UTF-8").when()
		          .put("/posts/1");
		System.out.println("response body "+resp.getBody().asPrettyString());
		System.out.println("response time "+resp.time());
		System.out.println("status code "+resp.statusCode());
	}
	@Test
	public void deleteMethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res=RestAssured.when().delete("/posts/1");
		System.out.println("response body "+res.body().asPrettyString());
		System.out.println("responce stustus code "+res.statusCode());
	}

}
