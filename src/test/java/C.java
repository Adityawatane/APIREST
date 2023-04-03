import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class C {
	@Test
	public void test01() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().get();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}
	@Test
	public void test02() {
		RestAssured.baseURI="https://reqres.in/api/users";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").header("Content-Type","application/json").post();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}
	@Test
	public void test03() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").header("Content-Type","application/json").put();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}
	@Test
	public void test04() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").header("Content-Type","application/json").patch();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}
	
	

}
