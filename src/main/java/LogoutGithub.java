import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutGithub {
    private WebDriver driver;
    public LogoutGithub(WebDriver driver){this.driver = driver;}

    By headerButton = By.xpath("//summary[@aria-label='View profile and more']");
    By signOutItemFromList = By.xpath("//button[contains(@class, 'dropdown-signout')]");
    By nameInDropdownList = By.xpath("//strong[@class='css-truncate-target']");

    public LogoutGithub headerButtonClick(){driver.findElement(headerButton).click();return this;}

    public LogoutGithub signOutItemFromListClick(){driver.findElement(signOutItemFromList).click();return this;}


    public LogoutGithub waitForPageTitle(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath(
                                "//div[@class='py-6 py-sm-8 jumbotron-codelines']")), "Built for developers"));
        return this;
    }
    public LogoutGithub waitForNameInDropdownList(String text){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(nameInDropdownList), text));
        return this;
    }

    public LogoutGithub logoutUserFromAccount(String wait) throws InterruptedException {
        headerButtonClick();
     //   waitForNameInDropdownList(wait);
        Thread.sleep(1000);
        signOutItemFromListClick();
        waitForPageTitle();
        return this;
    }




}
