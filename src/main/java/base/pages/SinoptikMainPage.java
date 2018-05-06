package base.pages;

import base.enums.DayOfWeek;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package base.
 */
public class SinoptikMainPage {

    WebDriver driver;
    WebDriverWait wait;
    private final static String BASE_URL = "https://sinoptik.ua/";

    private final By searchField = By.id("search_city");
    private final By submit = By.className("search_city-submit");

    public SinoptikMainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public SinoptikMainPage openStartPage(){
        driver.get(BASE_URL);
        return this;
    }

    public SinoptikMainPage clickSubmit(){
        driver.findElement(submit).click();
        return this;
    }

    public SinoptikMainPage searchCity(String value){
        driver.findElement(searchField).sendKeys(value);
        return this;
    }

    public DayWeatherPage selectDayOfWeek(DayOfWeek dayOfWeek)  {
        new WebDriverWait(driver, 5)
                .until(elementToBeClickable(
                        By.xpath("//*[text() = '"+ dayOfWeek.getName()+ "']")))
                .click();
        return new DayWeatherPage(driver, dayOfWeek);
    }
}
