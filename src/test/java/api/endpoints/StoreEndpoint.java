package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import api.payload.StorePayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoint {
	
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
	
	public static Response getStore() {
		
		Response res = given()
			.accept(ContentType.JSON)
//			.body(payload)
		
		.when()
			.get(getUrl().getProperty("shopGetInventoryUrl"));
		
		return res;
		
	}
	
	public static Response placeOrder(StorePayload payload) {
		
		Response res = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(getUrl().getProperty("shopPostUrl"));
		
		return res;
		
	}
	
	public static Response getOrderById(int orderId) {
		
		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("orderId", orderId)
			
		.when()
			.get(getUrl().getProperty("shopOrderUrl"));
		
		return res;
		
	}
	
	public static Response deleteOrderById(int orderId) {
		
		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("orderId", orderId)
		
		.when()
			.delete(getUrl().getProperty("shopDeleteUrl"));
		
		return res;
		
	}
	
}
