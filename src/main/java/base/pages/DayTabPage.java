package base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 06.05.18 in the package base.pages.
 */
public class DayTabPage extends SinoptikMainPage {

    private By dayTab = By.xpath("descendant::div[@id = 'bd1']/*[@class = 'day-link']");

    public DayTabPage(WebDriver driver) {
        super(driver);
    }

}
