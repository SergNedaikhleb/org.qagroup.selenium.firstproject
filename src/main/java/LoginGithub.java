import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginGithub {
    private WebDriver driver;
    LoginGithub(WebDriver driver){this.driver = driver;}

    By signInButtonMainPage = By.xpath("//a[contains(@data-ga-click, 'clicked Sign in')]");
    By loginField = By.id("login_field");
    By passwordField = By.id("password");
    By signInButtonAuthForm = By.xpath("//input[@name='commit']");

    public LoginGithub signInButtonClick(){
        driver.findElement(signInButtonMainPage).click();
        return this;
    }

    public LoginGithub waitForPageTitle(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath(
                                "//div[@class='auth-form-header p-0']/h1")), "Sign in to GitHub"));
        return this;
    }

    public LoginGithub fillLoginField(String login){driver.findElement(loginField).sendKeys(login);return this;}

    public LoginGithub fillPasswordField(String passw){driver.findElement(passwordField).sendKeys(passw);return this;}

    public LoginGithub clickSignInButtonOnAuthForm(){
        driver.findElement(signInButtonAuthForm).click();
        return this;
    }

    public LoginGithub loginUserIntoAccount(String user, String password){
        signInButtonClick();
        waitForPageTitle();
        fillLoginField(user);
        fillPasswordField(password);
        clickSignInButtonOnAuthForm();
        return this;
    }

}
