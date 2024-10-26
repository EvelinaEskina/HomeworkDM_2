package otus;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FirstTest {

    private String baseUrl = System.getProperty("base.url");

    private WebDriver driver;

    @BeforeAll
    public static void webDriverInstall() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void webDriverStart() {
        driver = new WebDriverFactory().getDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);

    }

    @AfterEach
    public void webDriverStop() {
        if (driver != null)
            driver.close();
        }


    @Test
    public void enterText() {
        driver.get(baseUrl);
       WebElement textBox = driver.findElement(By.id("textInput"));
       textBox.sendKeys("OTUS");
       Assertions.assertEquals("OTUS",textBox.getAttribute("value"));
    }


}
