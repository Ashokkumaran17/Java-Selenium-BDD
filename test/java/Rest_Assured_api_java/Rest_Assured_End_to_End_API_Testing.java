package Rest_Assured_api_java;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.Assert;
//Rest Assured End to End API Testing
public class Rest_Assured_End_to_End_API_Testing {
    public static void main(String[] args){
        System.out.println("Welcome to Rest Assured API Testing");
        System.out.println("Rest Assured Post Method Results");
        //Given - All input details
        //When - Submit the API i.e Resource and http method
        //Then - Validate the Response
        //log().all() will capture all logs

        // pass the base URI
        RestAssured.baseURI ="https://rahulshettyacademy.com";
        //Post Method
        //Enter all inputs
        String response = given().log().all().queryParam("key","qaclick123").header("content-Type","application/json")
                .body(Payload_Data.AddPlace())
                //Enter the endpoints
                .when().post("/maps/api/place/add/json")
                //validate the response and validate scope body is equal to APP
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .extract().response().asString();
        //output header validations
        //.header("Server","Apache/2.4.52 (Ubuntu)");
        System.out.println("display the Post Response :\n"+ response);
        //parse the json to extract the place_id
        JsonPath js_result = new JsonPath(response);
        String placeId =js_result.getString("place_id");
        //print the place id
        System.out.println("Place Id is :"+ placeId);

        //PUT Method
        //update the place
        String new_address = "70 winter walk, USA";
        given().log().all().queryParam("key", "qaclick123").header("content-Type", "application/json")
                .body("{\n" +
                        //"\"place_id\":\"3ad63f435819f506a80550c308b38a9e\",\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+new_address+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").
                when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //GET Method
        //validate the newly updated  place
        String getPlaceResponse= given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id",placeId)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println("display the getPlace Response :\n"+ getPlaceResponse);
        //parse the json to extract the place_id
        JsonPath getPlaceRes_result = new JsonPath(getPlaceResponse);
        String actual_address =getPlaceRes_result.getString("address");
        //print the Actual Address
        System.out.println("Actual Address is :"+  actual_address);
        //compare newly updated address and actual address
        Assert.assertEquals(new_address,actual_address);

        //DELETE Method
        //delete the place
        String deletePlace_Response =given().log().all().queryParam("key", "qaclick123").body("{\n" +
                        "\n" +
                        "    \"place_id\":\""+placeId+"\"\n" +
                        "}\n").when().delete("/maps/api/place/delete/json")
                .then().assertThat().statusCode(200).extract().response().asString();

        System.out.println("display the delete Place Response :\n"+ deletePlace_Response);
        //parse the json to extract the place_id
        JsonPath deletePlaceRes_result = new JsonPath(deletePlace_Response);
        String actual_status =deletePlaceRes_result.getString("status");
        //print the Status
        System.out.println("Status is :"+  actual_status);
        //compare newly updated address and actual address
        Assert.assertEquals("OK",actual_status);

    }
}
