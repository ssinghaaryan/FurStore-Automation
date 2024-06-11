package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpointViaProperties;
import api.payload.StorePayload;
import io.restassured.response.Response;

public class StoreTestsViaProperties {
	
	Faker faker;
	StorePayload payload;
	
	@BeforeClass
	void setup() {
		
		faker = new Faker();
		payload = new StorePayload();
		
		payload.setId(faker.number().randomDigitNotZero());
		payload.setPetId(faker.idNumber().hashCode());
		payload.setQuantity(faker.number().randomDigitNotZero());
		payload.setStatus("placed");
		payload.setComplete(true);
		
	}
	
	@Test(priority = 1)
	void getStoreInventory() {
		
		Response res = StoreEndpointViaProperties.getStore();
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 2) 
	void placeOrder() {
		
		Response res = StoreEndpointViaProperties.placeOrder(payload);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 3)
	void getOrderById() {
		
		Response res = StoreEndpointViaProperties.getOrderById(this.payload.getId());
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 4)
	void deleteOrderById() {
		
		Response res = StoreEndpointViaProperties.deleteOrderById(this.payload.getId());
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	
	
}
