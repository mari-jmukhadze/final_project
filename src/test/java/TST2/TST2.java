package TST2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TST2 {
    static WebDriver driver;

    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    public static WebDriver getDriver() {
        return driver;
    }
}
