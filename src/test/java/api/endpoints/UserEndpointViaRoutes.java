package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpointViaRoutes {
	
	public static Response createUser(UserPayload payload) { // Creates all these payload methods public and static so can be accessed by any class.
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.postUrl);
		
		return res;
		
	}
	
	public static Response readUser(String username) {

		Response res = given()
			.pathParam("username", username)
			.accept(ContentType.JSON)
		
		.when()
			.get(Routes.getUrl);
		
		return res;
		
	}
	
	public static Response updateUser(UserPayload payload, String username) {

		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username)
		
		.when()
			.put(Routes.updateUrl);
		
		return res;
		
	}
	
	public static Response deleteUser(String username) {

		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("username", username)
		
		.when()
			.delete(Routes.deleteUrl);
		
		return res;
		
	}

}
