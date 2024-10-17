package factory;

import exceptions.BrowserNotFoundException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import settings.ChromeSettings;

public class WebDriverFactory {

    private String browserName = System.getProperty("browser");

    public WebDriver getDriver() {
        switch (browserName) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().setting());
            }
        }
            throw new BrowserNotFoundException(browserName);
        }


    }

