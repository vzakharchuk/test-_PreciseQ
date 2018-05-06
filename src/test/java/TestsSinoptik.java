import base.BaseTestClass;
import base.enums.DayOfWeek;
import base.pages.SinoptikMainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static base.enums.DayOfWeek.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package PACKAGE_NAME.
 */
public class TestsSinoptik extends BaseTestClass {

    private SinoptikMainPage sinoptikMainPage;

    @DataProvider(name = "days")
    public Object[][] testGetDay(){
        return new Object[][] {
                {MONDAY}, {TUESDAY}, {WEDNESDAY},
                {THURSDAY}, {FRIDAY}, {SATURDAY}, {SUNDAY}
        };
    }

    @BeforeMethod()
    public void beforeMethod(){
        sinoptikMainPage = new SinoptikMainPage(driver)
                .openStartPage()
                .searchCity("Драгобрат")
                .clickSubmit();
    }

    @Test(dataProvider = "days")
    public void testIsAirPressureNormal(DayOfWeek dayOfWeek){
       sinoptikMainPage
                .selectDayOfWeek(dayOfWeek)
                .getAverageAirPressureData()
                .forEach(i-> assertTrue(i < 700 && i > 600));
    }

    @Test
    public void testIsTabOpenedCorrectly(){String currentDay = sinoptikMainPage
                .selectDayOfWeek(FRIDAY)
                .getDayNameDisplayed();
        assertEquals(FRIDAY.getName(), currentDay);
    }
}


