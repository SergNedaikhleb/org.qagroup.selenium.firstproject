import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPageSearch {
    private WebDriver driver;
    public MainPageSearch(WebDriver driver){this.driver = driver;}

    By searchField = By.xpath("//input[@name='search' and @placeholder='Я ищу...']");
    By searchButton = By.xpath("//button[text()=' Найти ']");
    By firstItem = By.xpath("//span[@class='goods-tile__title']");
    By pageHeader = By.xpath("//div[@class='central-wrapper']//div[@class='layout']");

    public MainPageSearch searchFieldInput(String search){
        driver.findElement(searchField).sendKeys(search);
        return this;
    }

    public MainPageSearch searchButtonClick(){
        driver.findElement(searchButton).click();
        return this;
    }

    public MainPageSearch waitForPageTitle(String title){
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath(
                                "//h1[@class='catalog-heading']")), title));
        return this;
    }

    public MainPageSearch checkTheFirstItemIs(String item){
        Assert.assertTrue(driver.findElement(firstItem).getText().contains(item));
        return this;
    }

    public MainPageSearch checkTheAbsenceOfItems(){
        Assert.assertFalse(driver.findElement(firstItem).isSelected());
        return this;
    }

    public MainPageSearch checkFindItemsText(String text){
        Assert.assertEquals(driver.findElement(pageHeader).getText().contains(text), text);
        return this;
    }



}
