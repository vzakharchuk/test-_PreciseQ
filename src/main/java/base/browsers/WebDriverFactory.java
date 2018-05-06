package base.browsers;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package base.
 */

import base.enums.Browsers;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static base.enums.Browsers.*;
import static java.lang.System.setProperty;

/**
 * @author v.zakharchuk
 *
 * Returns ThreadLocal browser driver instanse
 */
public class WebDriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public final void setDriver(Browsers browsers) {

        String path = "src/main/resources/bin/linux/";
        setProperty("webdriver.chrome.driver", path + "/chrome/chromedriver");
        setProperty("webdriver.gecko.driver", path + "firefox/geckodriver");

        if(browsers.equals(CHROME)){
            webDriver.set(new ChromeDriver());
        }

        if(browsers.equals(FIREFOX)){
            webDriver.set(new FirefoxDriver());
        }
    }

    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public void closeSession(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
