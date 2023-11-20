package Rest_Assured_api_java;

public class Example_Of_POJO {
    private String message;
    private String greet;
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getGreet(){
        return greet;
    }
    public void setGreet(String greet){
        this.greet = greet;
    }


}
/*
//output
{
  "message":"Hello",
  "greet":"Hi"
}
*/
//create the object

//Example_Of_POJO mg = new Example_Of_POJO();
//mg.setMessage("Hello");
//mg.setGreet("Hi");
//mg.getGreet();

//Rest Assured
//Example_Of_POJO msg_obj = new Example_Of_POJO();
//msg_obj.setMessage("My Messages");

//given().body(mg).
//when().post(msg_obj);




