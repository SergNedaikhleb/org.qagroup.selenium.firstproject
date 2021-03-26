import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TryToFindElements {
    private WebDriver driver;

    @BeforeTest
    public  void setUp() {
        // let us disable any notification for protect out test execution from unexpected blockers
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
   //     options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
   //     options.addArguments("--headless");
        driver = new ChromeDriver(options);
        // go to website
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        // implicit wait ???
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
        @AfterTest
    public void tearDown(){driver.quit();}


    @Test(description = "get page elements and check, match, extract")
    public void findElements() {

        String mainPageSource = driver.getPageSource();
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));


        // 1. check the certain text exists on the page
        Assert.assertTrue(mainPageSource.contains("Доставка по всей Украине"));

        // 2. check equality of expected and actual element (text)
    //    Assert.assertEquals(driver.findElement(By.xpath("//span[@class='menu-toggler__text']")).getText(), "Каталог товаров");

        // 3. check location of element and is it matches with expectations

       // System.out.println(driver.findElement(By.xpath("//a[@class='menu-categories__link']/span")).getLocation());
  //      Assert.assertEquals(driver.findElement(By.xpath("//a[@class='menu-categories__link']/span")).getLocation().toString(), "(198, 144)");

        // 4. check is element enabled on the page
        Assert.assertTrue(searchField.isEnabled());

        Assert.assertFalse(!(searchField.isEnabled()));

        // 5. check attribute value
        Assert.assertEquals(searchField.getAttribute("placeholder"), "Я ищу...");
        Assert.assertNotEquals(searchField.getAttribute("placeholder"), "Я  не уверен что ищу...");

        // 6. Check the quantity of elements on the page
        Assert.assertEquals(driver.findElements(By.xpath("//a[@class='menu-categories__link']/span")).size(), 16);

    }

}
