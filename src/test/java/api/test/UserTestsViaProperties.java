package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
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
//		payload.setId(2314521);
//		payload.setUsername(faker.name().username());
		payload.setUsername("sampleusername");
		payload.setFirstname(faker.name().firstName());
//		payload.setFirstname("Sample Name");
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(4, 8));
		payload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1) 
	void testPostUser() {
		
		Response res = UserEndpoint.createUser(payload);
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 2)
	void testGetUser() {
		
		Response res = UserEndpoint.readUser(this.payload.getUsername());
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	void testUpdateUser() {
		
		// Updating user details via payload
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndpoint.updateUser(payload, this.payload.getUsername());
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
		// Validating updated details
		Response resPostUpdation = UserEndpoint.readUser(this.payload.getUsername());
		
		Assert.assertEquals(resPostUpdation.statusCode(), 200);
		
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		
		Response res = UserEndpoint.deleteUser(this.payload.getUsername());
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
}
