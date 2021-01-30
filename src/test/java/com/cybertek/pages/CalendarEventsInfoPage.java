package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

    public class CalendarEventsInfoPage extends BasePage {

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[1]/div/div")
        public WebElement titleInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[2]/div/div")
        public WebElement descriptionInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[3]/div/div")
        public WebElement startInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[4]/div/div")
        public WebElement endInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[5]/div/div")
        public WebElement allDayEventInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[6]/div/div")
        public WebElement organizerInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[7]/div/div")
        public WebElement guestsInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[8]/div/div")
        public WebElement recurrenceInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row'])[9]/div/div")
        public WebElement callViaHangoutInfo;

        @FindBy(xpath = "(//div[@class='control-group attribute-row']/div/div)")
        public List<WebElement> eventInfoDetails;


        public String infoCalendarEvents(String info){
            String path = "//*[@*='control-group attribute-row']//*[contains(text(),'"+info+"')]/../div/div";
            return Driver.get().findElement(By.xpath(path)).getText();
        }

        @FindBy (xpath = "(//div[@*='control-label'])[1]")
        public WebElement title;


    }





