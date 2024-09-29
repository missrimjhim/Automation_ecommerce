import org.example.Base.BaseClass;
import org.example.Pages.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class TestClass extends BaseClass {
    Homepage homepage;
    //click on ALL and close
    @Test
    public void TC_1() throws InterruptedException {
        homepage = new Homepage(driver);
        //homepage.clickOnAllmenu();
        homepage.clickOnBestSellers();
        //homepage.clickOnFresh();
    }
}
