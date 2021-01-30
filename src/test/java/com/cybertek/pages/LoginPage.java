package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){ //constructor --PageFactory classından-->initElements metodu
        PageFactory.initElements(Driver.get(),this); //this means pointing element in this page
        //we will initialize two element 1-Driver.get browser 2-this key word
    }

    /*   ===============================================================
     @FindAll({
            @FindBy(id ="prependedInput") ,//OR GİBİ BİRİ ÇALIŞIRSA
            @FindBy(name = "_username")
    })
        @FindBys({
            @FindBy(id ="prependedInput") ,//AND GİBİ İKİSİDE ÇALIŞIRSA
            @FindBy(name = "_username")
    })
        =========================================================
    //BİRDEN FAZLA WEB ELEMENT BULMAK İÇİN
    @FindBy(css = ".btn.btn-primary")
    public  List<WebElement> buttons;
    */


    //driver.findElement(By.id("prependedInput"));
    @FindAll({  //or gibi ikisinden biri doğru ise webelementi bulur
            @FindBy(id = "prependedInput"),  //POM locator anotation
            @FindBy(name = "_username")
    })
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2" )
    public WebElement passwordInput;


    //driver.findElement(By.id("_submit")); alttaki iki satıra eşit
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login (String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsDriver (){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsSalesManager(){

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsStoreManager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

}
