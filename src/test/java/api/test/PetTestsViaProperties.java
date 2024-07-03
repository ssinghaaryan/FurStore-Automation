package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndpoint;
import api.payload.PetPayload;
import io.restassured.response.Response;

public class PetTestsViaProperties {
	
	Faker faker;
	PetPayload payload;
	
	@BeforeClass
	void setup() {
		
		faker = new Faker();
		payload = new PetPayload();
		
		payload.setPetId(13344);
		payload.setPetName("Zena");
		payload.setStatus("available");
		
	}
	
	@Test(priority = 1)
	void addPetToStore() {
		
		Response res = PetEndpoint.addPet(payload);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 2) 
	void getPetById() {
		
		Response res = PetEndpoint.getPet(this.payload.getPetId());
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}

}
