import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class B {
	@Test
	public void createUser() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking"
				;
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").header("Content-Type","application/json").when().post();
		
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}
	@Test
	public void updateUser() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking/:id";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").header("Content-Type","application/json").header("Accept","application/json")
				.header("Cookie","token=abc123").when().put();
		
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}
	@Test
	public void patchuser() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking/:id";
		Response res=RestAssured.given().body("{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\"\r\n"
				+ "}").header("Content-Type","application/json").header("Accept","application/json")
				.header("Cookie","token=abc123").when().patch();
		System.out.println("status code "+res.statusCode());
		System.out.println("string is "+res.asPrettyString());
	}

}
