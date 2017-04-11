
package JollyOhtu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SpringBootApplication
public class Tester {
    public static void main(String[] args) {      
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan\\Documents\\GitHub\\Jolly-ohtu\\chromedriver.exe");
        
        
        WebDriver driver = new ChromeDriver();


        driver.get("http://www.google.com/");
        
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
        }
        
        driver.quit();
    }
}
