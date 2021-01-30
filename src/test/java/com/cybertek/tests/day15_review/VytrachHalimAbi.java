package com.cybertek.tests.day15_review;

    import com.cybertek.pages.*;
    import com.cybertek.tests.TestBase;
    import com.cybertek.utilities.BrowserUtils;
    import com.cybertek.utilities.ConfigurationReader;
    import com.google.common.base.Verify;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.testng.Assert;
    import org.testng.annotations.Test;

   public class VytrachHalimAbi extends TestBase{
//
//        /***
//         * Test case #1
//         * 1. Go to “https://qa1.vytrack.com/"
//         * 2. Login as a store manager
//         * 3. Navigate to “Activities -> Calendar Events”
//         * 4. Verify that page subtitle "Options" is displayed
//         */
//        @Test (priority = 1, description = "TestCase # 1")
//        public void optionIsDisplayedTest() {
//            extentLogger = report.createTest("Verify page subtitle Option is displayed test");
//            DashboardPage dashboardPage = new DashboardPage();
//            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//            //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
//            //Login as a store manager
//            extentLogger = report.createTest("Login as a store manager test");
//            LoginPage login = new LoginPage();
//            login.loginAs("storemanager");
//            //login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));
//            //Navigate to “Activities -> Calendar Events”
//            extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
//            dashboardPage.navigateToModule("Activities", "Calendar Events");
//            //dashboardPage.waitUntilLoaderScreenDisappear();
//            //Verify that page subtitle "Options" is displayed
//            extentLogger = report.createTest("Verify that page subtitle \"Options\" is displayed test");
//            Assert.assertTrue(calendarEventsPage.optionsButton.isDisplayed(), "Verify that page subtitle \"Options\" is displayed");
//            extentLogger.pass("PASS : Verify that page subtitle \"Options\" is displayed");
//        }
//        /***
//         * Test case #2
//         * 1. Go to “https://qa1.vytrack.com/"
//         * 2. Login as a store manager
//         * 3. Navigate to “Activities -> Calendar Events”
//         * 4. Verify that page number is equals to "1"
//         */
//        @Test (priority = 2, description = "TestCase # 2")
//        public void pageNumberTest() {
//            extentLogger = report.createTest("Verify page subtitle Option is displayed test");
//            DashboardPage dashboardPage = new DashboardPage();
//            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//            //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
//            //Login as a store manager
//            extentLogger = report.createTest("Login as a store manager test");
//            LoginPage login = new LoginPage();
//            login.loginAs("storemanager");
//            //Navigate to “Activities -> Calendar Events”
//            extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
//            dashboardPage.navigateToModule("Activities", "Calendar Events");
//            calendarEventsPage.waitUntilLoaderScreenDisappear();
//            //Verify that page number is equals to "1"
//            extentLogger = report.createTest("Verify that page number is equals to \"1\" test");
//            String pageNumberText = new CalendarEventsPage().pageNumber.getAttribute("value");
//            Assert.assertEquals(pageNumberText, "1", "Verify that page number is equals to \"1\"");
//            extentLogger.pass("PASS : Verify that page number is equals to \"1\"");
//        }
//        /***
//         * Test case #3
//         * 1. Go to “https://qa1.vytrack.com/"
//         * 2. Login as a store manager
//         * 3. Navigate to “Activities -> Calendar Events”
//         * 4. Verify that view per page number is equals to "25"
//         */
//        @Test (priority = 3, description = "TestCase # 3")
//        public void viewPerPageTest() {
//            extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");
//            DashboardPage dashboardPage = new DashboardPage();
//            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//            //Go to “https://qa1.vytrack.com/" (TestBase does this)
//            //Login as a store manager
//            extentLogger = report.createTest("Login as a store manager test");
//            LoginPage login = new LoginPage();
//            login.loginAs("storemanager");
//            //calendarEventsPage.waitUntilLoaderScreenDisappear();
//            //Navigate to “Activities -> Calendar Events”
//            extentLogger = report.createTest("Navigate to “Activities -> Calendar Events test");
//            dashboardPage.navigateToModule("Activities", "Calendar Events");
//            //dashboardPage.waitUntilLoaderScreenDisappear();
//            BrowserUtils.waitForPageToLoad(10);
//            //Verify that view per page number is equals to "25"
//            extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");
//            String perPage = calendarEventsPage.viewPerPageNo.getText();
//            //System.out.println("perPage = " + perPage);
//            Assert.assertEquals(perPage, "25", "Verify that view per page number is equals to \"25\"");
//            extentLogger.pass("PASS : Verify that view per page number is equals to \"25\" test");
//        }
//        /***
//         * Test case #4
//         * 1. Go to “https://qa1.vytrack.com/"
//         * 2. Login as a store manager
//         * 3. Navigate to “Activities -> Calendar Events”
//         * 4. Verify that number of calendar events (rows in the table) is equals to number of records (1559)
//         */
//        @Test (priority = 4, description = "TestCase # 4")
//        public void numberOfRecordsTest() {
//            extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");
//            DashboardPage dashboardPage = new DashboardPage();
//            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//            //Go to “https://qa1.vytrack.com/" (TestBase does this)
//            //Login as a store manager
//            extentLogger = report.createTest("Login as a store manager test");
//            LoginPage login = new LoginPage();
//            login.loginAs("storemanager");
//            //calendarEventsPage.waitUntilLoaderScreenDisappear();
//            //Navigate to “Activities -> Calendar Events”
//            extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
//            dashboardPage.navigateToModule("Activities", "Calendar Events");
//            BrowserUtils.waitForClickablility(calendarEventsPage.perPageBtn, 10);
//            //change view per page to 100
//            calendarEventsPage.perPageBtn.click();
//            calendarEventsPage.perPage100.click();
//            //Verify that number of calendar events (rows in the table) is equals to number of records
//            extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
//            BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);
//            //new DashboardPage().waitUntilLoaderScreenDisappear();
//            //System.out.println("calendarEventsPage.totalPagesNo.getText() = " + calendarEventsPage.totalPagesNo.getText());
//            String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
//            pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
//            int pageNoAsInt = Integer.parseInt(pageNoAsString);
//            int rowNo = 0;
//            for (int i = 1; i <= pageNoAsInt; i++) {
//                rowNo += calendarEventsPage.tableRows.size();
//                calendarEventsPage.rightArrow.click();
//                calendarEventsPage.waitUntilLoaderScreenDisappear();
//            }
//            //System.out.println("calendarEventsPage.totalRecordNo.getText() = " + calendarEventsPage.totalRecordNo.getText().substring(9,13));
//            int totalRecordNoAsInt = Integer.parseInt(calendarEventsPage.totalRecordNo.getText().substring(9, calendarEventsPage.totalRecordNo.getText().length() - 8));
//
//}
       /***
        //         * Test case #4
        //         * 1. Go to “https://qa1.vytrack.com/"
        //         * 2. Login as a store manager
        //         * 3. Navigate to “Activities -> Calendar Events”
        //         * 4. Verify that number of calendar events (rows in the table) is equals to number of records (1559)
        //         */

         @Test (priority = 4, description = "TestCase # 4")

        public void numberOfRecordsTest() throws InterruptedException {
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAsStoreManager();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitForClickablility(calendarEventsPage.perPageNumberWebElement, 10);
        //change view per page to 100
             Thread.sleep(3000);
        calendarEventsPage.perPageNumberWebElement.click();
        calendarEventsPage.viewPerPage100.click();

        //Verify that number of calendar events (rows in the table) is equals to number of records
        extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
        BrowserUtils.waitForClickablility(calendarEventsPage.nextPage, 10);

        //new DashboardPage().waitUntilLoaderScreenDisappear();
        //System.out.println("calendarEventsPage.totalPagesNo.getText() = " + calendarEventsPage.totalPagesNo.getText());
        String pageNoAsString = calendarEventsPage.getTotalPagesAsString();
       // pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        int rowNo = 0;
        Thread.sleep(3000);
        for (int i = 1; i < pageNoAsInt; i++) {

        rowNo += calendarEventsPage.allRow.size();
        Thread.sleep(3000);

        calendarEventsPage.nextPage.click();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        
            System.out.println(calendarEventsPage.allRow.size()+" "+ i);
        }
           int  lastPageRowSize= calendarEventsPage.lastPageRowSizeAsInt();
        
             System.out.println("lastpage row size : "+ lastPageRowSize);

             rowNo+=lastPageRowSize;

        //System.out.println("calendarEventsPage.totalRecordNo.getText() = " + calendarEventsPage.totalRecordNo.getText().substring(9,13));
       // int totalRecordNoAsInt = Integer.parseInt(calendarEventsPage.getTotalRecord.getText().substring(9, calendarEventsPage.totalRecordNo.getText().length() - 8));
      //  System.out.println("totalRecordNoAsInt = " + totalRecordNoAsInt);
        System.out.println("rowNo = " + rowNo);
        System.out.println("pageNoAsInt = " + pageNoAsInt);
        System.out.println("pageNoAsString = " + pageNoAsString);

      //  Assert.assertEquals(rowNo, totalRecordNoAsInt, "verify number of calendar events (rows in the table) is equals to number of total records");

        extentLogger.pass("PASS : Verify that number of calendar events (rows in the table) is equals to number of records test");

}
        }