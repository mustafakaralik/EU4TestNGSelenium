package com.cybertek.tests.day15_review;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cybertek.pages.CalendarEventsInfoPage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Vytrack_HW extends TestBase {

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    public static void beforeTest() {
        new LoginPage().loginAsStoreManager();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");
    }

    @Test
    /*
    Test case #1
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that page subtitle "Options" is displayed
     */
    public void testCase1() {
        beforeTest();

        String pagesSubTitleText = calendarEventsPage.pageSubtitle.getText();

        Assert.assertEquals(pagesSubTitleText, "Options", "Verify that page subtitle 'Options' is displayed");
        Assert.assertTrue(calendarEventsPage.pageSubtitle.isDisplayed());
    }

    @Test
    /*
    Test case #2
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that page number is equals to "1"
    */
    public void testCase2() {
        beforeTest();
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"), "1", " Verify that page number is equals to '1'");
    }

    @Test
    /*
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that view per page number is equals to "25"
     */

    public void test3() {
        extentLogger=report.createTest("Veirfy taht view per page number is equal to 25");
        beforeTest();
        Assert.assertEquals(calendarEventsPage.perPageNumber.getText(), "25", "Verify that view per page number is equals to '25'");
    }

    @Test
    /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in the table) is equals to number of records
    */
    public void test4() throws InterruptedException {
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");
        beforeTest();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitForClickablility(calendarEventsPage.pageNumber, 5);
        //calendarEventsPage.pageNumber.sendKeys(calendarEventsPage.getTotalPagesAsString()+Keys.ENTER);

        Thread.sleep(2000);
        extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
        int actualRow = ( (calendarEventsPage.getTotalPage()-1) * (calendarEventsPage.perPageNumberAsInt()) + calendarEventsPage.lastPageRowSizeAsInt());
        int expectedRod = calendarEventsPage.getTotalRecord();

        System.out.println("actualRow = " + actualRow);
        System.out.println("expectedRod = " + expectedRod);
        Thread.sleep(3000);
        System.out.println("last page row number :"+  calendarEventsPage.lastPageRowSizeAsInt());

        Assert.assertEquals(actualRow,expectedRod,"Actual row should be same as the expected row");

        extentLogger.pass("PASS : Verify that number of calendar events (rows in the table) is equals to number of records test");

        Thread.sleep(2000);

    }
//****************************Önder SOLUTION**************************************/*
// public void testCase4() throws InterruptedException {
//    extentLogger = report.createTest("Verify Number of Records");
//    extentLogger.info("Load Login Preconditions");
//    extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
//    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//    calendarEventsPage.waitUntilLoaderScreenDisappear();
//    Thread.sleep(1000);
//    extentLogger.info("Get the total of Records");
//    int TotalRecords = calendarEventsPage.getTotalRecords();
//    Thread.sleep(1000);
//    BrowserUtils.waitForClickablility(calendarEventsPage.viewPerPageSelect,15);
//    // Change view per page to desired value, can be anything 10-100
//    calendarEventsPage.viewPerPageSelect.click();
//    Thread.sleep(1000);
//    Driver.get().findElement(By.xpath(calendarEventsPage.getView(100))).click();
//    Thread.sleep(1000);
//    extentLogger.info("Get the total number of Rows");
//    int numberOfRows = 0;
//    for (int i = 1; i <= calendarEventsPage.getTotalPage(); i++) {
//         numberOfRows+=calendarEventsPage.getTotalRowNumber();
//         calendarEventsPage.nextClick.click();
//         Thread.sleep(5000);
//         calendarEventsPage.waitUntilLoaderScreenDisappear();
//        }
//    extentLogger.info("Verify Total number of Rows is equal to Total number of records");
//    Assert.assertEquals(TotalRecords,numberOfRows);
//    extentLogger.pass("Total number of Rows is equal to Total number of records, Test PASSED");
//}*/
    @Test
    /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Click on the top checkbox to select all
        5. Verify that all calendar events were selected
    */

    public void test5() throws InterruptedException {
        beforeTest();
        calendarEventsPage.selectAll.click();
        Thread.sleep(3000);
        for(WebElement allCheckBox : calendarEventsPage.allCheckBoxes){
            Assert.assertTrue(allCheckBox.isSelected(),"verify checkboxall is selected");
        }



    }

    @Test
    /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Select “Testers meeting”
        5. Verify that following data is displayed:
    */

    public void test6() throws InterruptedException { //yarı otomatik
        beforeTest();
        Thread.sleep(3000);
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.titleClick.click();
        BrowserUtils.waitForClickablility(calendarEventsPage.titleClick,5);
        calendarEventsPage.titleClick.click();
        Thread.sleep(2000);
        calendarEventsPage.BeforeAfterPage.click();
        Thread.sleep(2000);
        calendarEventsPage.testersMeet.click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.getMeetingTime("Testers meeting",9,30).click();

        Assert.assertTrue(calendarEventsPage.verifyText.isDisplayed(),"verify testers meeting is diplayed");
        //System.out.println(calendarEventsPage.verifyText.getText());
            String Expected= "Nov 27, 2020, 9:30 AM";
        //Assert.assertEquals(calendarEventsPage.getMeetingTime("Testers meeting",9,30),"Expected");

    }
 /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Select “Testers meeting”
        5. Verify that following data is displayed:
    */



     @Test // line by line look for 'Testers meeting' -> OK -> RUN
/*
1. Go to "https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to "Activities -> Calendar Events"
4. Select "Testers meeting"
5. Verify that following data is displayed:
 */
            public void test10() throws InterruptedException {  // line by line look for 'Testers meeting' -> OK -> RUN
                beforeTest();
                CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
                calendarEventsPage.waitUntilLoaderScreenDisappear();
                Thread.sleep(2000);
                String expectedTitle = "Testers meeting";
                String expectedStart = "9:30";
                boolean flag = true;
                outer:while (flag) {
                    for (int i = 1; i < calendarEventsPage.getTotalPage(); i++) {
                        Thread.sleep(1000);
                        calendarEventsPage.waitUntilLoaderScreenDisappear();
                        for (int j = 1; j <= calendarEventsPage.perPageNumberAsInt(); j++) {
                            String elementTitle = "//tbody/tr[" + j + "]/td[2]";
                            String actualTitle = driver.findElement(By.xpath(elementTitle)).getText();
                            String elementStart =  "//tbody/tr[" + j + "]/td[4]";
                            String actualStart = driver.findElement(By.xpath(elementStart)).getText();
                            if (actualTitle.equals(expectedTitle) && actualStart.contains(expectedStart)) {
                                driver.findElement(By.xpath(elementTitle)).click();
                                flag=false;
                                break outer;
                            }
                        }
                        driver.findElement(By.cssSelector(".fa-chevron-right.hide-text")).click();
                    }
                }
                Assert.assertEquals(new CalendarEventsInfoPage().infoCalendarEvents("Start"),"Jan 8, 2020, 2:30 AM.");
            }
        }
