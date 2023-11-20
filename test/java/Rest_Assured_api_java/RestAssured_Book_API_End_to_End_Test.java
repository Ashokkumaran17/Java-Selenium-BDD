package Rest_Assured_api_java;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.Assert;

import java.util.List;

public class RestAssured_Book_API_End_to_End_Test {
    public static void main(String[] args){
        // pass the base URI
        RestAssured.baseURI ="https://rahulshettyacademy.com";
        //Enter all inputs
        String response = given().log().all().header("content-Type","application/json")
                .body(Payload_Data.addBook())
                //Enter the endpoints
                .when()
                //Post Method
                .post("/Library/Addbook.php")
                //validate the response and validate scope body is equal to APP
                .then().log().all().assertThat().statusCode(200).body("Msg",equalTo("successfully added"))
                .extract().response().asString();
        //output header validations
        System.out.println("display the Post Response :\n"+ response);
        //parse the json to extract the ID
        JsonPath js_Res = new JsonPath(response);
        String bookId =js_Res.getString("ID");
        //print the Book Id
        System.out.println("Book Id is :"+ bookId);

        //Get the book name
        String expected_book_name = "Learn Selenium Automation with Java";
        String getBook_Response= given().log().all().queryParam("ID", bookId)
                .when()
                //GET Method
                .get("/Library/GetBook.php")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Get Response Book ID is :\n"+ getBook_Response);
        //parse the json to extract the Book ID
        JsonPath getRes_book = new JsonPath(getBook_Response);
        String actual_book_name =getRes_book.getString("book_name");
        //print the Actual Address
        System.out.println("Actual Book Name is :"+ actual_book_name);

        //StringBuilder str_b = new StringBuilder(actual_book_name);
        //String results = str_b.toString();
        //System.out.println(results);

        //compare newly updated address and actual address
        //Assert.assertEquals(expected_book_name,actual_book_name);

        //Get the book Author name
        String getAuthor_Response= given().log().all().queryParam("AuthorName", "John doe")
                .when()
                //GET Method
                .get("/Library/GetBook.php")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Get Author Response is :\n"+ getAuthor_Response);
        //parse the json to extract the Author name
        JsonPath getRes_author = new JsonPath(getAuthor_Response);
        String actual_Author_name =getRes_author.getString("book_name");
        //print the Author name books
        System.out.println("Author Book Name  is :"+ actual_Author_name);

        // Delete the book
        String deleteAuthor_Response= given().log().all().body("{\n" +
                        "    \"ID\": \""+bookId+"\"\n" +
                        "}")
                .when()
                //GET Method
                .delete("/Library/DeleteBook.php")
                .then().assertThat().statusCode(200).body("msg",equalTo("book is successfully deleted")).extract().response().asString();
        System.out.println("Delete Book Response is :\n"+ deleteAuthor_Response);

    }

}
