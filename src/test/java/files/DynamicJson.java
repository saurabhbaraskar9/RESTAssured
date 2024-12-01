package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJson {

    // Test method to add a book to the library using DataProvider
	
    // Test method to add a book to the library using DataProvider
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) throws IOException {

        // Set base URI for API calls
        RestAssured.baseURI = "http://216.10.245.166";

        // Prepare the request body (assuming payload.Addbook builds the JSON)
        String payload = payLoad.Addbook(isbn, aisle);

        // Send a POST request to add the book
        Response resp = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response();

        // Extract the JSON response using ReusableMethods.rawToJson (assuming it converts to a JsonPath object)
        JsonPath js = ReusableMethods.rawToJson(resp);

        // Extract the ID from the response
        String id = js.get("ID");

        // Print the extracted ID
        System.out.println(id);

        // TODO: Implement logic for deleting the book (deleteBook method?)
    }

    // DataProvider to provide test data for book addition
    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{{"ojfawaatya", "19aa3635"}, {"zcwet11ee", "4qq2z2253"}, {"pokmffvfet", "54z43399"}};
    }

  
    
	 @Test(dataProvider = "bookIds")
	    public void deleteBook(String id) {
    	
    	
    	System.out.println("-----------Delete Started----------------");
    	// Set base URI for API calls
        RestAssured.baseURI = "http://216.10.245.166";

        // Prepare the request body (assuming payload.Addbook builds the JSON)
        String payload2 = payLoad.deleteBook(id);

        // Send a POST request to delete the book
        Response resp = given().log().all()
                .header("Content-Type", "application/json")
                .body(payload2)
                .when().log().all()
                .post("/Library/DeleteBook.php")
                .then().assertThat().statusCode(200)
                .extract().response();
               

        // Extract the JSON response using ReusableMethods.rawToJson (assuming it converts to a JsonPath object)
        JsonPath js = ReusableMethods.rawToJson(resp);

        // Extract the message from the response
        String msg = js.get("MSG");

        // Print the extracted ID
        System.out.println(msg);
    }
	 
	 // DataProvider to provide IDs
	    @DataProvider(name = "bookIds")
	    public Object[][] provideBookIds() {
	        return new Object[][] { {"ojfwaatya9aa3635"},  {"zcwet11ee4qq2253"},  {"pokmfffet5443399"}};
	    }
    
    
}