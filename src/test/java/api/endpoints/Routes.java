package api.endpoints;

// Keeping all the URL's ( Base URL and end points ) being used in the framework.
public class Routes {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// User Model in Store
	
	public static String postUrl = baseUrl + "/user";
	public static String getUrl = baseUrl + "/user/{username}";
	public static String updateUrl = baseUrl + "/user/{username}";
	public static String deleteUrl = baseUrl + "/user/{username}";

}
