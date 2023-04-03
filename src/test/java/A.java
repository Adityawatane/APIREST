import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class A {
	
	@Test(priority=1)
	public void getUser() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().when().get();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
		System.out.println("time taken "+res.getTime());
	}
	
	@Test(priority=2)
	public void createUser() {
		RestAssured.baseURI="https://reqres.in/api/users";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}\r\n"
				+ "").header("Content-Type","application/json").when().post();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
		System.out.println("time taken "+res.getTime());
	}
	
	@Test(priority=3)
	public void updateUser() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").header("Content-Type","application/json").when().put();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
		System.out.println("time taken "+res.getTime());
	}
	
	@Test(priority=4)
	public void deleteUser() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response res=RestAssured.given().when().delete();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
		System.out.println("time taken "+res.getTime());
	}

}
