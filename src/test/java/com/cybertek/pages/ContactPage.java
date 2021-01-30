package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage  extends BasePage{
    //since we are extending BasePage we do not need explicit constructor for this class
    //PageFactory is a class which  has a static initElements method that initialize all WebElements
    //we want a dynamic email to reach locator all the time so create method which accepts email as String
   /* public ContactPage() {
        PageFactory.initElements(Driver.get(), this); //---->Base  page extend ettiğimiz için onun içinde var
    }*/                                                //bu constructor'u tekrar oluşturmana gerek yok

    /*@FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement emailclick;*/
    //bu iki satır yerine her email için geçerli olacak dynamic bir method yazalım

    //altta bir method yapalım ki her email için geçerli olsun sadece mbrackstone9@example.com için değil
    public WebElement getContactEmail(String email){ //Aşağıda Singlton yapmasa idik WebDriver driver yazacaktık her yere String emailin önüne
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath)); //singleton desing pattern -->Driver.get().
    }

}
