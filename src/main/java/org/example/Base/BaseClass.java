package org.example.Base;

import org.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.File;


public class BaseClass {
     public WebDriver driver;

   @BeforeClass
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");// Read from config

        if (browser.equalsIgnoreCase("chrome")) {
            String projectPath = System.getProperty("user.dir");
            String driverPath = projectPath + File.separator + "drivers" + File.separator + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            System.out.println("Setting up WebDriver...");
            String projectPath = System.getProperty("user.dir");
            String driverPath = projectPath + File.separator + "drivers" + File.separator + "msedgedriver.exe";
            System.setProperty("webdriver.edge.driver", driverPath);
            driver =  new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));  // Get URL from config
    }

   @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
