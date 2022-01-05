package TST2;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
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

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;


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
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @Test
    public void searchBook() {
        By searchbox = By.xpath("//*[@id=\"searchBox\"]");
        driver.findElement(searchbox).sendKeys("O\'Reilly Media");

        List<WebElement> Books =  driver.findElements(books_div);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(books_div));
//        return driver.findElements(books_div);

        System.out.println(Books.size());

        //checking found elements
        open("https://demoqa.com/books");
        ElementsCollection allBooks = $$x("//div[@class='rt-td' and contains(text(),'Reilly Media')]");

        assert  allBooks.size() == Books.size();



    }




//    }




}
