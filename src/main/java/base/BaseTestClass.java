package base;

import base.browsers.WebDriverFactory;
import base.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package base.
 */
public class BaseTestClass {

    private WebDriverFactory webDriverFactory = new WebDriverFactory();
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String value) {
        webDriverFactory.setDriver(Browsers.valueOf(value.toUpperCase()));
        this.driver = webDriverFactory.getWebDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        webDriverFactory.closeSession();
    }
}

