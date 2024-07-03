package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import api.payload.PetPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndpoint {
	
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
	
	public static Response addPet(PetPayload payload) {
		
		Response res = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(getUrl().getProperty("petPostUrl"));
		
		return res;
		
	}
	
	public static Response getPet(int id) {
		
		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("id", id)
		
		.when()
			.get(getUrl().getProperty("petGetUrl"));
			
		return res;
		
	}
	
}
