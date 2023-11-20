package Rest_Assured_api_java;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;

import pojo.Api;

import pojo.GetCourse;



public class RestAssurred_OAuth_Test {
    public static void main(String[] args){
        // pass the base URI
        String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
        //example of index code index[1] 4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M
        String partial_code=url.split("code=")[1];

        String code=partial_code.split("&scope")[0];

        System.out.println(code);

        String response =
                given().urlEncodingEnabled(false)
                        //
                        .queryParams("code",code)
                        //pass the client ID on query params
                        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                        //pass the client Secret on query params
                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                        //pass the Grant Type on query params
                        .queryParams("grant_type", "authorization_code")
                        //pass the State on query params
                        .queryParams("state", "verifyfjdss")
                        //pass the Session state on query params
                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

                        // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                        .when().log().all()
                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

        // System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);
        String getRes = given().contentType("application/json").
                queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .asString();
        System.out.println(getRes);

    }
}
