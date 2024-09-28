package org.example.Base;

import org.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
    protected WebDriver driver;

   @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");  // Read from config
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\91861\\Documents\\coding-practice\\NewProductPage\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));  // Get URL from config
    }

   @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
