package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoint {
	
	// 1st way of loading routes.properties file and accessing the URL's.
	public static Properties getUrl() {
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir") + "/src/test/resources/routes.properties");
		
		try {
			FileInputStream fis = new FileInputStream(configPropFile);
			configProp.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return configProp;
	}

	// 2nd way of loading routes.properties file and accessing the URL's.
//	static ResourceBundle getUrl2() {
//		
//	ResourceBundle routes = ResourceBundle.getBundle("routes"); // Loads the routes.properties file.
//	return routes;
//	
//	}
	
	public static Response createUser(UserPayload payload) { // Creating all these payload methods public and static so can be accessed by any class.
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(getUrl().getProperty("postUrl"));
//			.post(Routes.postUrl);
		
		return res;
		
	}
	
	public static Response readUser(String username) {

		Response res = given()
			.pathParam("username", username)
			.accept(ContentType.JSON)
		
		.when()
			.get(getUrl().getProperty("getUrl"));
//			.get(Routes.getUrl);
		
		return res;
		
	}
	
	public static Response updateUser(UserPayload payload, String username) {

		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username)
		
		.when()
			.put(getUrl().getProperty("updateUrl"));
//			.put(Routes.updateUrl);
		
		return res;
		
	}
	
	public static Response deleteUser(String username) {

		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("username", username)
		
		.when()
			.delete(getUrl().getProperty("deleteUrl"));
//			.delete(Routes.deleteUrl);
		
		return res;
		
	}

}
