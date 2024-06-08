package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoint2;
import api.payload.UserPayload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	/* -> Using the same postUser request method from UserTests class but in this case,
	 	  the data will be used from the excel using Data Provider instead of Faker class as in UserTests. */
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String username, String fname, String lname, String email, String pwd, String ph) {
		
		UserPayload payload = new UserPayload();
		
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(username);
		payload.setFirstname(fname);
		payload.setLastname(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		Response res = UserEndpoint2.createUser(payload);
		
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}

	@Test(priority = 2, dataProvider = "Usernames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByUsername(String username) {
		
		Response res = UserEndpoint2.deleteUser(username);
	
		AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}
	
}
