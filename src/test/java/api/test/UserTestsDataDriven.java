package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoint;
import api.payload.UserPayload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestsDataDriven {
	
	/* -> Using the same postUser request method from UserTests class but in this case,
	 	  the data will be used from the excel using Data Provider instead of Faker class as in UserTests. */
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void postUser(String userId, String username, String fname, String lname, String email, String pwd, String ph) {
		
		UserPayload payload = new UserPayload();
		
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(username);
		payload.setFirstname(fname);
		payload.setLastname(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		System.out.println("-------- Creating User ---------");
		
		Response res = UserEndpoint.createUser(payload);
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 2, dataProvider = "Usernames", dataProviderClass = DataProviders.class)
	public void getUser(String username) {
		
		System.out.println("-------- Fethcing User Info --------");
		
		Response res = UserEndpoint.readUser(username);
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	@Test(priority = 3, dataProvider = "updatedData", dataProviderClass = DataProviders.class)
	public void updateUser(String userId, String username, String fname, String lname, String email, String pwd, String ph) {
		
		UserPayload payload = new UserPayload();
		
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(username);
		payload.setFirstname(fname);
		payload.setLastname(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		System.out.println("-------- Updating User --------");
		
		Response res = UserEndpoint.updateUser(payload, username);
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
		Response resPostUpdation = UserEndpoint.readUser(username);
		resPostUpdation.then().log().body();
		
		Assert.assertEquals(resPostUpdation.statusCode(), 200);
		
	}

	@Test(priority = 4, dataProvider = "Usernames", dataProviderClass = DataProviders.class)
	public void deleteUser(String username) {
		
		System.out.println("-------- Deleting User --------");
		
		Response res = UserEndpoint.deleteUser(username);
		res.then().log().body();
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
}
