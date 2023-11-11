package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.storeEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;
	Store userPayload;
	Response response;
	
	@BeforeClass
	public void SetUp()
	{
		faker = new Faker();
		userPayload = new Store();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setPetId(faker.idNumber().hashCode());
		userPayload.setQuantity(faker.idNumber().hashCode());
		userPayload.setShipDate(faker.date().toString());
		userPayload.setStatus("Placed");
		userPayload.setComplete(true);
	}
	
	
	@Test(priority=1)
	public void testPlaceOrder()
	{
	    response = storeEndPoints.placeOrder(userPayload);	
		response.then().log().status();
		response.then().log().body().statusCode(500);
		
		Assert.assertEquals(response.statusCode(), 500 ,"Test case failed...!!");
		
	}
	
	@Test(priority=2)
	public void testGetPlaceOrder()
	{
		response = storeEndPoints.getPlacedOrder(this.userPayload.getId());
		response.then().log().all();
		response.then().log().body().statusCode(404);
		
		Assert.assertEquals(response.statusCode(), 404, "Test case failed...!!");
	}
	
	@Test(priority=3)
	public void testGetInventoryOrder()
	{
		response = storeEndPoints.getInventoryOrder();
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200, "Test case failed...!!");
	
	}
	
	
	@Test(priority=4)
	public void testDeleteOrder()
	{
		response = storeEndPoints.deleteOrder(this.userPayload.getId());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 404, "Test case failed...!!");
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
