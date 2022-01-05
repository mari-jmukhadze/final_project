package TST;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class UserTest {

    @org.testng.annotations.Test
    public void addUser() {
        User User1 = new User();
        User1.Username = "Mari";
        User1.Password  ="123Mari123";

        String body =  '{' + "userName\"" + User1.Username + "\"," + "password\"" + User1.Password + '"' + '}';


        Response response = given().contentType(JSON)
                .body(body).post("https://bookstore.toolsqa.com/Account/v1/User");
        response.print();

    }


}
