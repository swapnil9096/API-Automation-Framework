package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class storeEndPoints {
	
	
	public static Response placeOrder(Store payload)
	{
		return given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.storePostUrl);
		
	}
	
	public static Response getPlacedOrder(int orderId)
	{
		 return given().pathParam("OrderId", orderId)
		.when().get(Routes.storeGetUrl);
		
	}
	
	
	public static Response getInventoryOrder()
	{
		return given()
		.when()
		.get(Routes.storeGetInventoryUrl);
	}
	
	public static Response deleteOrder(int orderId)
	{
		return given().pathParam("OrderId", orderId)
				.when()
				.delete(Routes.storeDeleteUrl);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
