package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
		
	public static Response createUser(User payload)
	{
		return  given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.userPostUrl);
		
	}
	
	public static Response readUser(String userName)
	{
		return given()
		.pathParam("username", userName)
		.when()
		.get(Routes.userGetUrl);
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		return given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.put(Routes.userUpdateUrl);
		
	}
	
	public static Response deleteUser(String userName)
	{
		return  given()
		.pathParam("username", userName)
		.when()
		.delete(Routes.userDeleteUrl);
		
	}
	
	
	
	
	
	
	
	
	
}
