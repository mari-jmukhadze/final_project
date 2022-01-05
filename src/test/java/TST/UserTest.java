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

    public SelenideElement userfield = $("#userName");
    public SelenideElement passfield = $("#password"),
            loginbtn = $("#login"),error=$("#name");

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private String userName,password;
    Response response;
    JsonPath path;

    public void adduser(String name,String password){
        this.userName = name;
        this.password = password;

        Map<String,String> user = new HashMap<String, String>();
        user.put("userName",userName);
        user.put("password",password);

        Response response = given().contentType(JSON)
                .body(user).post("https://bookstore.toolsqa.com/Account/v1/User");

    }

}
