package Rest_Assured_api_java;
import Rest_Assured_api_java.Payload_Data.*;

import io.restassured.path.json.JsonPath;

public class Complex_Json_Handle {
    public static void main(String[] args){
        JsonPath jp_data = new JsonPath(Payload_Data.coursePrices());
        //Get the Purchase amount
        int purchase_amt= jp_data.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount is :"+purchase_amt);
        //get the Academy name
        String website_name= jp_data.getString("dashboard.website");
        System.out.println("WebSite name is :"+website_name);

        //Get the first course title
        String course_title_0= jp_data.getString("courses[0].title");
        System.out.println("First Course title is :"+course_title_0);

        //Get the second course title
        String course_title_1= jp_data.getString("courses[1].title");
        System.out.println("Second Course title is :"+course_title_1);

        //Get the third course title
        String course_title_2= jp_data.getString("courses[2].title");
        System.out.println("Third Course title is :"+course_title_2);
        //display the size of the course
        int course_size= jp_data.getInt("courses.size()");
        System.out.println("Course Size is :"+course_size);
        //display the name of the course
        System.out.println("The course title is : ");
        for (int i=0;i<course_size;i++){
            System.out.println(jp_data.getString("courses["+i+"].title"));

        }
        //print total copy of the course
        int total_copy=0;
        for (int i=0;i<course_size;i++){
            total_copy+= jp_data.getInt("courses["+i+"].copies");

        }
        System.out.println("Total course copy is :"+total_copy);
        //print total course price
        int total_price=0;
        for (int i=0;i<course_size;i++){
            total_price+= jp_data.getInt("courses["+i+"].price");

        }
        System.out.println("Total course price is :"+total_price);
        //display the no of copies sold by RPA course
        System.out.println("Display no of copies sold by RPA course :");
        for (int i=0;i<course_size;i++){
            String course_title= jp_data.getString("courses["+i+"].title");
            if(course_title.equalsIgnoreCase("Cypress")){
                System.out.println("copy is : "+jp_data.getInt("courses["+i+"].copies"));
                System.out.println("price is :"+jp_data.getInt("courses["+i+"].price"));
                break;

            }

        }
        //compare total course amount and total purchase amount is equal or not?
        //Get the Purchase amount
        int purchase_amt_1= jp_data.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount is :"+purchase_amt_1);
        //get the total course amount
        int total_course_price_amt =0;
        for (int i=0;i<course_size;i++) {
            total_course_price_amt+= jp_data.getInt("courses["+i+"].price");
        }
        System.out.println("total course Amount is :"+total_course_price_amt);
        if(purchase_amt_1==total_course_price_amt){
            System.out.println("total course price amount equals to purchase amount");
        }
        System.out.println("total course price amount is not equals to purchase amount!!!");




    }

}
