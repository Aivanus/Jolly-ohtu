package JollyOhtu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan\\Documents\\GitHub\\Jolly-ohtu\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.get("http://localhost:8080");
//        
//        try {
//            Thread.sleep(4 * 1000);
//        } catch (Exception e) {
//        }
    }
}
