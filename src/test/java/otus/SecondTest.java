package otus;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SecondTest {

    private String baseUrl = System.getProperty("base.url");

    private WebDriver driver;

    @BeforeAll
    public static void webDriverInstall() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void webDriverStart() {
        driver = new WebDriverFactory().getDriver();
        //driver.manage().window().minimize();
        //System.out.println(driver.manage().window().getSize());
    }

    @AfterEach
    public void webDriverStop() {
        if (driver != null)
            driver.quit();
    }

    @Test
   public void windowTest() {
        driver.manage().window().minimize();
        System.out.println(driver.manage().window().getSize());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }

    @Test
    public void clickModalWindow() {
        driver.get(baseUrl);
        WebElement modalBtn = driver.findElement(By.id("openModalBtn"));
        modalBtn.click();



       WebElement modalWindow = driver.findElement(By.cssSelector("#myModal > div > h2"));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       assertThat(modalWindow.getText())
               .as("Это модальное окно",modalWindow)
               .isEqualTo(modalWindow);

    }











}


