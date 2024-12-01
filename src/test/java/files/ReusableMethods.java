package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	
	public static JsonPath rawToJson(Response resp)
	{
		JsonPath js1 =new JsonPath(resp.asString());
		return js1;
	}

	}


