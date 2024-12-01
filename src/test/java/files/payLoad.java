package files;

public class payLoad {
	
	public static String Addbook(String isbn,String aisle) {
		
		String payload = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		
		return payload;
	}
	
	public static String deleteBook(String id) {
		String payload2 = "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+id+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
		
		return payload2;
	}

}
