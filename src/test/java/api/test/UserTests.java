package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint2;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTests {
	
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
		
		Response res = UserEndpoint2.createUser(payload);
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 2)
	void testGetUser() {
		
		Response res = UserEndpoint2.readUser(this.payload.getUsername());
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	void testUpdateUser() {
		
		// Updating user details via payload
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndpoint2.updateUser(payload, this.payload.getUsername());
		res.then().log().body();
		
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
		// Validating updated details
		Response resPostUpdation = UserEndpoint2.readUser(this.payload.getUsername());
		
		AssertJUnit.assertEquals(resPostUpdation.statusCode(), 200);
		
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		
		Response res = UserEndpoint2.deleteUser(this.payload.getUsername());
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
