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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ThirdTest {
    private String baseUrl = System.getProperty("base.url");

    private WebDriver driver;

    @BeforeAll
    public static void webDriverInstall() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void webDriverStart() {
        driver = new WebDriverFactory().getDriver();
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
    }

    @AfterEach
    public void webDriverStop() {
        if (driver != null)
            driver.quit();
    }



    @Test
    public void interNameEmail() {
        driver.get(baseUrl);
        WebElement textName = driver.findElement(By.id("name"));
        textName.sendKeys("фыв");

        WebElement textEmail = driver.findElement(By.name("email"));
        textEmail.sendKeys("asdf@sdfg.rt");

        WebElement button = driver.findElement(By.cssSelector("#sampleForm > button"));
        button.click();

        WebElement messageBox = driver.findElement(By.cssSelector("#messageBox"));
        assertThat(messageBox.getText())
                .as("Message should be {Форма отправлена с именем: фыв и email: asdf@sdfg.rt}",messageBox)
                .isEqualTo(messageBox);
        Assertions.assertEquals("Форма отправлена с именем: фыв и email: asdf@sdfg.rt",messageBox.getAttribute("value"));


    }

}
