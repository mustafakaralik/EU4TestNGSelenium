package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.awt.*;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement pageSubtitle;
    //-----------------------------------------------------test1
    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

        // public WebElement pageNumber(int pageNumber){
        // String xpath ="//input[@value='"+pageNumber+"']";
        // return Driver.get().findElement(By.xpath(xpath));
        //}
    //-----------------------------------------------------test2
    @FindBy (xpath = "//button[contains(text(),'25')]")
    public WebElement perPageNumber;
    //-----------------------------------------------------test3


    @FindBy(xpath = "//*[contains(text(),'Testers meeting')]/..//*[contains(text(),'9:30')]")
    public WebElement meetingTime;

    @FindBy(xpath = "//*[@*='dib'][3]")
    public WebElement totalRecordWebElement;

    @FindBy(xpath = "//*[@*='dib'][2]")
    public WebElement totalPageWebElement;


    public int getTotalRecord(){  //Toftal O 4050 Record stringini alıp array ile " " her boşluğu split edip
        String numbers = totalRecordWebElement.getText();
        String[] arrayNumbers = numbers.split(" "); //Arrayin 2.elementi olan 4050 stringini Integer'a parse edip
        String totalRecordAsString = arrayNumbers[2].toString(); //integer olarak alıyoruz--> totalRecord
        int totalRecord = Integer.parseInt(totalRecordAsString);
        return totalRecord;
    }


    public String getTotalPagesAsString(){ //Of 162  stringini alıp array ile " " her boşluğu split edip
        String numbers = totalPageWebElement.getText();
        String[] arrayPages = numbers.split(" ");  //Arrayin 1.elementi olan 162 stringini String olarak alıyoruz--> totalPagesAsString
        String totalPagesAsString = arrayPages[1].toString();
        return totalPagesAsString;
    }


    public int getTotalPage(){    //Of 162  stringini alıp array ile " " her boşluğu split edip
        String numbers = totalPageWebElement.getText();
        String[] arrayPages = numbers.split(" ");  //Arrayin 1.elementi olan 162 stringini Integer'a parse edip
        String totalPagesAsString = arrayPages[1].toString();  //integer olarak alıyoruz--> totalPagesAsString
        int totalPages = Integer.parseInt(totalPagesAsString);
        return totalPages;
    }

    public int perPageNumberAsInt2 (){  //view per page de bulunan 25 sayısını integer olarak alıyoruz
        String numbers = perPageNumber.getText();
        int  perpageNumberInt = Integer.parseInt(numbers);
        return perpageNumberInt;
    }

    public int lastPageRowSizeAsInt() {
        pageNumber.sendKeys(getTotalPagesAsString()+ Keys.ENTER);
        int lastPageRowSize = Driver.get().findElements(By.cssSelector("tbody >tr")).size();
        return lastPageRowSize;
    }



    //-----------------------------------------------------test4

    @FindBy (xpath = "//button/input[@type='checkbox']")
    public WebElement selectAll;

    @FindBy(xpath ="//*[@*='grid-row row-click-action']/td[1]")
    ////tr[@class='grid-row']/td/input
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath ="//table[@class = 'grid table-hover table table-bordered table-condensed']/tbody/tr")
    public List<WebElement> allRow;


    //-----------------------------------------------------test5
    @FindBy (xpath = "//thead/tr/th[2]")
    public WebElement titleClick;

    @FindBy (xpath = " //i[@class='fa-chevron-right hide-text']")
    public WebElement BeforeAfterPage;

    @FindBy (xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title'])[9]")
    public WebElement testersMeet;

    @FindBy (xpath = " (//div[@class='controls']/div[@class='control-label'])[2]")
    public WebElement verifyText;

    @FindBy  ( xpath = " //(//div[@class='btn-group'])[2]")
    public WebElement perPageNumberWebElement2;

    @FindBy  ( css = ".dropdown-item")
    public List<WebElement> dropdownOptions;

    public WebElement getMeetingTime(String title, int hour, int minute){
        String xpath ="//*[contains(text(),'"+title+"')]/..//*[contains(text(),'"+hour+":"+minute+"')]";
        return Driver.get().findElement(By.xpath(xpath));

    }

    public int perPageNumberAsInt (){
        String numbers = perPageNumberWebElement.getText();
        int  perpageNumberInt = Integer.parseInt(numbers);
        return perpageNumberInt;
    }

    @FindBy (xpath = "//a[contains(text(),'100')]")
    public WebElement viewPerPage100;

    @FindBy (xpath = "//button[contains(text(),'25')]")
    public WebElement perPageNumberWebElement;

    @FindBy  ( xpath = " //i[@class='fa-chevron-right hide-text']")
    public WebElement nextPage;
    //-----------------------------------------------------test6

}
//******************************HALİM ABİ CALENDEREVENTPAGE*****************************************/*
//  @FindBy(css = "[title='Create Calendar event']")
//    @CacheLookup
//    public WebElement createCalendarEvent;
//
//    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
//    @CacheLookup
//    public WebElement optionsButton;
//
//    @FindBy(xpath = "//input[@class='input-widget']")
//    public WebElement pageNumber;
//
//    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
//    public WebElement  perPageBtn;
//
//    @FindBy(xpath = "//a[contains(text(),'100')]")
//    public  WebElement perPage100;
//
//    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
//    public WebElement viewPerPageNo;
//                                            ////tbody/tr[18]/td[4] row bölümleri
//    @FindBy(xpath = "//tbody/tr")
//    public List<WebElement> tableRows;
//
//    @FindBy(xpath = "//thead/tr/th")
//    public List<WebElement> tableColumns;
//
//    @FindBy(xpath = "//label[contains(text(),'of')][1]")
//    public WebElement totalPagesNo;
//
//    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
//    public  WebElement rightArrow;
//
//    @FindBy(xpath = "//label[contains(text(),'Total of ')]")
//    public WebElement totalRecordNo;
//
//    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']//input")
//    public WebElement checkBoxAll;
//
//    @FindBy(xpath = "//thead/tr/th[2]")
//    public WebElement headTitle;
//
//    @FindBy(xpath = "//thead/tr/th[4]")
//    public WebElement headStart;
//
//    /*@FindBy(xpath = "//i[@class='fa-filter hide-text']")
//    public WebElement filterBtn;*/
//
//    /*@FindBy(xpath = "//div[contains(text(),'Title')]")
//    public WebElement filterByTitleBtn;*/
//
//    /*@FindBy(xpath = "//input[@name='value']")
//    public WebElement filterInputBox;*/
//
//
//
// */


