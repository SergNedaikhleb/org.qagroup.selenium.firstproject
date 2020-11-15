import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GithubTestAndPreprodEnvironments {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://github.com/sergeyNedaikhleb");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginInto(){
    LoginGithub login = new LoginGithub(driver);
    login.loginUserIntoAccount("sergey.nedaikhleb@i.ua","preprodEnvironment");
    }

    @Test(priority = 2)
    public void inspectMainPage(){
        InspectionGithub inspect = new InspectionGithub(driver);
        inspect.checkTheAccountNameIs("sergeynedaikhleb");
    }

    @Test(priority = 3)
    public void logoutFromGithub() throws InterruptedException {
        LogoutGithub logout = new LogoutGithub(driver);
        logout.logoutUserFromAccount("sergeynedaikhleb");
    }
}
