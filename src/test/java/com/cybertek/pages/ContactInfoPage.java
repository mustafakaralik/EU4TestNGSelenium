package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{
    //we need three different locator for three  information

    @FindBy(css="div.pull-left>h1.user-name")
    public WebElement fullName;
    @FindBy (css="a.phone")
    public WebElement phone;
    @FindBy (css="a.email")
    public WebElement email;

}
