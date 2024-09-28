import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
@Test
public class AmazonSearchTest {

    public static void main(String[] args) {
        // Set path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91861\\Documents\\coding-practice\\NewProductPage\\drivers\\chromedriver.exe");

        // Initializing  WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open amazon.in
            driver.get("www.amazon.in");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // 2. Search for 'lg soundbar' in search box
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("lg soundbar");
            searchBox.submit();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // 3. Retrieve all product names and their associated prices on the 1st search result page
            List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

            // 4.Storing the product names and prices in a hashmap
            Map<String, Integer> productPriceMap = new HashMap<>();

            // 5.Loop through product names and associate prices
            for (int i = 0; i < productNames.size(); i++) {
                String name = productNames.get(i).getText();
                String priceText;
                if (i < productPrices.size()) {
                    priceText = productPrices.get(i).getText().replace(",", "");
                } else {
                    // 6. Where price is not present, considering it as zero
                    priceText = "0";
                }
                int price = Integer.parseInt(priceText);
                productPriceMap.put(name, price);
            }

            // 5. Sort products by price
            List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<>(productPriceMap.entrySet());
            sortedProducts.sort(Map.Entry.comparingByValue());

            // Print sorted products one by one
            for (Map.Entry<String, Integer> entry : sortedProducts) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
