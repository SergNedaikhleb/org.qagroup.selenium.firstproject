import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CssDinerPlayWithWaits {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
    System.setProperty("webdriver.gecko.driver", "src\\main\\java\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
     //   options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.get("https://flukeout.github.io/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void letsPlay() throws InterruptedException {
        System.out.println("Now I'm gonna play the game: "+driver.getTitle());
        System.out.println("=================================================");

        // define some locators for this game
        WebElement currentGameTask = driver.findElement(By.className("order"));
        WebElement gameLevel = driver.findElement(By.className("level-text"));
        WebElement rowForAnswer = driver.findElement(By.xpath("//*[@class='input-strobe' and @type='text']"));
        WebElement enterButton = driver.findElement(By.xpath("//div[contains(@class,'enter-button') and contains(text(), 'enter')]"));

        // define an explicit waits
        WebDriverWait waitBeforeInputAnswer = (new WebDriverWait(driver, 8));
        WebDriverWait waitAfterInputAnswer = (new WebDriverWait(driver, 8));

        // let's play
        System.out.println("I am on "+gameLevel.getText());
        System.out.println("My task is "+currentGameTask.getText());
        waitBeforeInputAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate");
        Thread.sleep(1000);
        enterButton.click();
        waitAfterInputAnswer.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 2 of 32"));
        if (gameLevel.getText().equals("Level 2 of 32")) {
            System.out.println("OK, I winner");
        }else{
            System.out.println("I loose!!");
        }

        System.out.println("I am on "+gameLevel.getText());
        System.out.println("My task is: "+currentGameTask.getText());
        waitBeforeInputAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento");
        Thread.sleep(2000);
        enterButton.click();
        waitAfterInputAnswer.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 3 of 32"));
        if (gameLevel.getText().equals("Level 3 of 32")) {
            System.out.println("OK");
        }else {
            System.out.println("I loose");
        }

        System.out.println("I am on "+gameLevel.getText());
        System.out.println("My task is: "+currentGameTask.getText());
        waitBeforeInputAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("#fancy");
        Thread.sleep(2000);
        enterButton.click();
        waitAfterInputAnswer.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 4 of 32"));
        if (gameLevel.getText().equals("Level 4 of 32")) {
            System.out.println("OK");
        }else {
            System.out.println("I loose");
        }

        System.out.println("I am on "+gameLevel.getText());
        System.out.println("My task is: "+currentGameTask.getText());
        waitBeforeInputAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate apple");
        Thread.sleep(2000);
        enterButton.click();
        waitAfterInputAnswer.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 5 of 32"));
        if (gameLevel.getText().equals("Level 5 of 32")) {
            System.out.println("OK");
        }else {
            System.out.println("I loose");
        }

    }
}


