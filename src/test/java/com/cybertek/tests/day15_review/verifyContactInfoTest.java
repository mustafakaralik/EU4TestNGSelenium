package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
    @Test
    public void contactDetailsTest() throws InterruptedException {
            extentLogger = report.createTest("Contact Info Verification");
            //*extentLogger gives info non tecnical person who is customer bilgi raporlamak için 
        //*****open the chrome
        LoginPage loginPage = new LoginPage();

        //*****go to qa1.vytrack
            //--> it comes from testPage via using-->driver.get(ConfigurationReader.get("url"));

        //****** login as a sales manager
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to --> Customers > Contacts");
        //just like writing
        //WebElement button = driver.findElement(By.id("button"));
        //button.click();  ---->dont need to write two line  instead of this two line
        //we can write just one line ---> driver.findElement(By.id("button")).click();
        // instead of writing -->DashboardPage dashboardPage = new DashboardPage ();
        // -->than dashboardPage.navigateToModule

         //***** navigate to customers ->contacts
        new DashboardPage().navigateToModule("Customers","Contacts");

         // ***** click on email mbrackstone9@example.com
        ContactPage contactPage = new ContactPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        Thread.sleep(5000);
        contactPage.waitUntilLoaderScreenDisappear();
        contactPage.getContactEmail("mbrackstone9@example.com").click();

        //****** verify that full name is Mariam Brackstone
        //-->doğrulamak istediğimiz veriler başka bir sayfada olduğu için yeni bir page açıyoruz PagesContactInfoPages
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();
        extentLogger.info("Verify full name is "+ expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        //-->üstteki 3 satır yerine
        //-->Assert.assertEquals(contactInfoPage.fullName.getText(),"mbrackstone9@example.com","Verify email");

         //****** verify that email is mbrackstone9@example.com
        extentLogger.info("verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");

        //****** verify that phone number is +18982323434
        extentLogger.info("verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");

        extentLogger.pass("PASSED");

    }


}

