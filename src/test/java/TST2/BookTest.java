package TST2;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.parsing.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;


public class BookTest extends TST2.base {
    @BeforeTest
    public void setup(){

        base Driver = new base();
        Driver.initialize();
        driver = getDriver();
        driver.get("https://demoqa.com/books");
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RestAssured.defaultParser = Parser.JSON;
    }

    By books_div = By.className("mr-2");

    @Test
    public void searchBook() {


        By searchbox = By.xpath("//*[@id=\"searchBox\"]");
        driver.findElement(searchbox).sendKeys("O'Reilly Media");


        List<WebElement> Books =  driver.findElements(books_div);

        System.out.println(Books.size());

        //checking found elements

        Response resp = RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books");

        BookList list = resp.jsonPath().getObject("", BookList.class);

        List<Book> booksList = list.books.stream().filter(x->x.publisher.equals("O'Reilly Media")).collect(Collectors.toList());

        Assert.assertEquals(booksList.size(),Books.size());




    }


//    }




}
