package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import io.restassured.response.Response;

public class petEndPoints {
	
	public static Response addPet(int petId)
	{
		return given()
				.pathParam("petId", petId)
				.when()
				.post(Routes.petPostUrl);
				
	}

	public static Response readPet(int petId)
	{
		return given().pathParam("petId", petId)
				.when()
				.get(Routes.petGetUrl);
	}
	
	
	public static Response updatePet(int petId, Pet payload)
	{
		return given().pathParam("petId",petId)
				.body(payload)
				.when()
				.put(Routes.petUpdateUrl);
	}
	
	
	public static Response deletePet(int petId)
	{
		return given().pathParam("petId", petId)
				.when()
				.delete(Routes.petDeleteUrl);
	}
	
	
	
	
	
	
	
}
