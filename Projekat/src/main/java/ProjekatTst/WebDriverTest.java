package ProjekatTst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Scanner;

public class WebDriverTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Scanner sc = new Scanner(System.in);
        String url = "https://s.bootsnipp.com/iframe/WaXlr";
        driver.navigate().to(url);

    }
}
