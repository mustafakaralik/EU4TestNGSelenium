package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage { //it is a part os POM we can not copy past it is unique for this project
    // it should be own each project

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;


    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }



    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();

    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);

        }
    }

}
//*********************HALİM ABİ BASE BAGE****************************************************************************/*
//
// public abstract class BasePage {
//    /***
//     * abstract bc not a stand alone page so no need to create an object we don't want this page to create object
//     *     our POM structure, other pages besides LoginPage share common values. All other pages have same navigation menu
//     *     So all pages extend our BasePage and use same methods from BasePage...
//     *     We locate all the common elements and functionality for all the pages/modules here related to application.
//     *     All other pages that have those functionality will extend the BasePage. it is application specific.
//     */
//
//    @FindBy(css = "div[class='loader-mask shown']")
//    @CacheLookup
//    protected WebElement loaderMask;
//
//    @FindBy(css = "h1[class='oro-subtitle']")
//    public WebElement pageSubTitle;
//
//    @FindBy(css = "#user-menu > a")
//    public WebElement userName;
//
//    @FindBy(linkText = "Logout")
//    public WebElement logOutLink;
//
//    @FindBy(linkText = "My User")
//    public WebElement myUser;
//
//    public BasePage() {
//        PageFactory.initElements(Driver.get(), this);
//    }
//    /***
//     * PageFactory is a class which  has a static initElements method that initialize all WebElements
//     * PageFactory is used to initialize the elements of the Page Object or instantiate the Page Objects itself
//     * use @Findby here and driver connection...Not ‘FindElement’ or ‘FindElements’
//     */
//
//    /**
//     * The initElements() method takes the driver object created in the test and
//     * initializes the elements declared in the LoginPage class...
//     */
//    /**
//     * @return page name, for example: Dashboard
//     */
//    public String getPageSubTitle() {
//        //any time we are verifying page name, or page subtitle, loader mask appears
//        waitUntilLoaderScreenDisappear();
////        BrowserUtils.waitForStaleElement(pageSubTitle);
//        return pageSubTitle.getText();
//    }
//
//    /**
//     * Waits until loader screen present. If loader screen will not pop up at all,
//     * NoSuchElementException will be handled  bu try/catch block
//     * Thus, we can continue in any case.
//     */
//    public void waitUntilLoaderScreenDisappear() {
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
//            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public String getUserName(){
//        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForVisibility(userName, 5);
//        return userName.getText();
//    }
//
//
//    public void logOut(){
//        BrowserUtils.waitFor(2);
//        BrowserUtils.clickWithJS(userName);
//        BrowserUtils.clickWithJS(logOutLink);
//    }
//    public void goToMyUser(){
//        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForClickablility(userName, 5).click();
//        BrowserUtils.waitForClickablility(myUser, 5).click();
//
//    }
//
//    /**
//     * This method will navigate user to the specific module in vytrack application.
//     * For example: if tab is equals to Activities, and module equals to Calls,
//     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
//     *
//     * @param tab
//     * @param module
//     */
//    public void navigateToModule(String tab, String module) {
//        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
//        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
//        try {
//            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
//            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
//            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
//        } catch (Exception e) {
//            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
//        }
//        try {
//            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
//            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
//            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
//            Driver.get().findElement(By.xpath(moduleLocator)).click();
//        } catch (Exception e) {
////            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
//            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
//        }
//    }
//
//}
//
//
//
// */
