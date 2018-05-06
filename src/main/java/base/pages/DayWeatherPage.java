package base.pages;

import base.enums.DayOfWeek;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 06.05.18 in the package base.pages.
 */
public class DayWeatherPage extends SinoptikMainPage {


    private final DayOfWeek dayOfWeek;
    private final By infoDayWeek = By.className("infoDayweek");
    private final String airPressureXpath = "//div[@id = 'bdIDc']//tr[@class = 'gray'][1]/td";


    public DayWeatherPage(WebDriver driver, DayOfWeek dayOfWeek) {
        super(driver);
        this.dayOfWeek = dayOfWeek;

    }

    public String getDayNameDisplayed(){
        return wait.until(presenceOfElementLocated(infoDayWeek))
                             .getText();
    }

    public List<Integer> getAverageAirPressureData(){
        String actualPath = airPressureXpath.replace("ID", dayOfWeek.getId().toString());
        return driver.findElements(By.xpath(actualPath))
                .stream()
                .map(i-> i.getAttribute("innerHTML"))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
