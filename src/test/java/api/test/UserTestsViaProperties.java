package api.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpointViaProperties;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTestsViaProperties {
	
	Faker faker;
	UserPayload payload;
	
	@BeforeClass
	void setup() {
		
		faker = new Faker();
		payload = new UserPayload();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(4, 8));
		payload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1) 
	void testPutUser() {
		
		Response res = UserEndpointViaProperties.createUser(payload);
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 2)
	void testGetUser() {
		
		Response res = UserEndpointViaProperties.readUser(this.payload.getUsername());
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	void testUpdateUser() {
		
		// Updating user details via payload
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndpointViaProperties.updateUser(payload, this.payload.getUsername());
		res.then().log().body();
		
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
		// Validating updated details
		Response resPostUpdation = UserEndpointViaProperties.readUser(this.payload.getUsername());
		
		AssertJUnit.assertEquals(resPostUpdation.statusCode(), 200);
		
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		
		Response res = UserEndpointViaProperties.deleteUser(this.payload.getUsername());
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
