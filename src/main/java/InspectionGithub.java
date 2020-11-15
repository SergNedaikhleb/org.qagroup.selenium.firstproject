import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InspectionGithub {
    private WebDriver driver;
    InspectionGithub(WebDriver driver){this.driver = driver;}

    By accountNameField = By.xpath("//span[@itemprop='additionalName']");

    public InspectionGithub checkTheAccountNameIs(String item){
        Assert.assertEquals(driver.findElement(accountNameField).getText(), item);
        return this;
    }
}
