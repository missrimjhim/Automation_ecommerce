
import org.example.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class AmazonTest extends BaseClass {



//    @BeforeTest(enabled = false)
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91861\\Documents\\coding-practice\\Automation_ecommerce\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @Test
    public void testAmazonSearch() {
        try {
            if (driver == null) {  // Check if driver is initialized
                System.out.println("Driver is null! Test cannot proceed.");
                return;
            }
            // 1. Open amazon.in
            //driver.get("https://www.amazon.in");

            // 2. Search for 'lg soundbar'
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("lg soundbar");
            searchBox.submit();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 3. Retrieve all product names and their prices
            List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

            // 4. Store product names and prices in a HashMap
            Map<String, Integer> productPriceMap = new HashMap<>();

            for (int i = 0; i < productNames.size(); i++) {
                String name = productNames.get(i).getText();
                String priceText = "0";

                if (i < productPrices.size()) {
                    priceText = productPrices.get(i).getText().replace(",", "").trim();
                }

                try {
                    int price = Integer.parseInt(priceText);
                    productPriceMap.put(name, price);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid price for: " + name);
                }
            }

            // 5. Sort products by price
            List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<>(productPriceMap.entrySet());
            sortedProducts.sort(Map.Entry.comparingByValue());

            // Print sorted products
            for (Map.Entry<String, Integer> entry : sortedProducts) {
                System.out.println(entry.getValue() + " - " + entry.getKey());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterTest(enabled = false)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}

