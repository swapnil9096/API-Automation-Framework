package api.endpoints;

public class Routes {

	//Base url
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// User moduleUrl

	public static String userPostUrl = baseUrl + "/user";

	public static String userGetUrl = baseUrl + "/user/{username}";

	public static String userUpdateUrl = baseUrl + "/user/{username}";

	public static String userDeleteUrl = baseUrl + "/user/{username}";

	// Store module

	public static String storePostUrl = baseUrl + "/store/order";

	public static String storeGetUrl = baseUrl + "/store/order/{OrderId}";

	public static String storeGetInventoryUrl = baseUrl + "/store/inventory";

	public static String storeDeleteUrl = baseUrl + "/store/order/{OrderId}";

	// Pet module

	public static String petPostUrl = baseUrl + "/pet/{petId}";

	public static String petGetUrl = baseUrl + "/pet/{petId}";

	public static String petUpdateUrl = baseUrl + "/pet/{petId}";

	public static String petDeleteUrl = baseUrl + "/pet/{petId}";
	
	
	
	
	
	
	
	
}
