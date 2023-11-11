package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserTests {
    
	Faker faker;
	User userPayload;
	Response response;
	
	
	@BeforeClass
	public void setUp()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	
	@Test(priority=1)
	public void testPostUser()
	{
	    response = (Response) userEndPoints.createUser(userPayload);
		response.then().log().all();
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200,"Test case failed...!!");
		
	}
	
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		response = userEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		response.then().log().body().contentType(ContentType.JSON);
		Assert.assertEquals(response.getStatusCode(), 200 ,"Test case failed...!!");
	}
	
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		response = userEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body().statusCode(200);
		
		Assert.assertEquals(response.getStatusCode(), 200, "Test case failed...!!");
		
		Response responseAfterUpdate = userEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		responseAfterUpdate.then().log().body().statusCode(200);
		
		Assert.assertEquals(responseAfterUpdate.statusCode(), 200 , "Test case failed...!!");
	}
	
	@Test(priority=4)
	public void deleteUserByName()
	{
	 
		response = userEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().body().statusCode(200);
		
		Assert.assertEquals(response.statusCode(), 200,"Test case failed...!!");
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
}
