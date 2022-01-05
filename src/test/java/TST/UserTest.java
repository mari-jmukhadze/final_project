package TST;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class UserTest {

        Response response = given().contentType(JSON)
                .body(user).post("https://bookstore.toolsqa.com/Account/v1/User");

    }

}
