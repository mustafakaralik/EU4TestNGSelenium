package com.cybertek.tests.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
    /*
    * Test case
    * Open chrome browser
    * Login as A Driver
    * Verify that page subtitle is Quick Launchpad
    * Go to Activities -> Calender Events
    * verify that page subtitle is Calender Events
    * */
    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitle");

        dashboardPage.navigateToModule("Activities","Calender Events");

        CalendarEventsPage calendarEventsPage =new CalendarEventsPage();

        //calendarEventsPage.waitUntilLoaderScreenDisappear(); //doesnot help
        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calender Events","Verify subtitle Calender Events");






    }
}
