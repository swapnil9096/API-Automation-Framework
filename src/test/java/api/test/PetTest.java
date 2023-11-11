package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.petEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class PetTest {
	
	
	Pet userPayload;
	Response response;
	
	@BeforeClass
	public void setUp()
	{
		
		userPayload = new Pet();
		
		userPayload.setCode(2);
		userPayload.setType("animal");
		userPayload.setMessage("Placed");
		
	}

	
	@Test(priority=1)
	public void testAddPet()
	{
		response = petEndPoints.addPet(this.userPayload.getCode());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),404,"Test case failed...!!");
	}
	
	@Test(priority=2)
	public void testReadPet()
	{
		response  = petEndPoints.readPet(this.userPayload.getCode());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 404,"Test casee failed...!!");
	}
	
	@Test(priority=3)
	public void testUpdatePet()
	{
		response = petEndPoints.updatePet(this.userPayload.getCode(),userPayload);
		
		response.then().log().all();
		
		response.then().statusCode(405);
		
		Assert.assertEquals(response.getStatusCode(), 405,"Test case failed...!!");
	}
	
	@Test(priority=4)
	public void testDeletePet()
	{
		response = petEndPoints.deletePet(this.userPayload.getCode());
		response.then().log().all();
		
		response.then().statusCode(404);
		
		Assert.assertEquals(response.getStatusCode(), 404,"Test case failed...!!");
	}
	
}
