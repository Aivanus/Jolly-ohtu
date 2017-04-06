
package JollyOhtu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
