package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deneme {
     /*
    Verify confirmation message
    open browser
    go to https://www.facebook.com/campaign/landing.php?&campaign_id=1603087355&extra_1=s%7Cc%7C305038450781%7Ce%7Cfacebook%27%7C&placement=&creative=305038450781&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1603087355%26adgroupid%3D61834755758%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1012763%26loc_interest_ms%3D%26feeditemid%3D919461022%26param1%3D%26param2%3D&gclid=Cj0KCQiAzsz-BRCCARIsANotFgPwPi6X0RkUUwr7nfhgAZcvagm58d-scngDvybrBi3WVxANZ8vZuNUaApi5EALw_wcB Links to external site
    enter any email
    verify that email is displayed in the input box
    click on Retrieve password
    verify that confirmation message says "your e-mail's been sent!"
    */

    public static void main(String[] args) throws InterruptedException {
        //-open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

      //go to https://www.facebook.com/campaign/landing.php?&campaign_id=1603087355&extra_1=
       // s%7Cc%7C305038450781%7Ce%7Cfacebook%27%7C&placement=&creative=305038450781&keyword=
        // facebook%27&partner_id=googlesem&extra_2=campaignid%3D1603087355%26adgroupid%3D61834755758%26
        // matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26
        // devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_
        // ms%3D1012763%26loc_interest_ms%3D%26feeditemid%3D919461022%26param1%3D%26param2%3D&gclid=
        // Cj0KCQiAzsz-BRCCARIsANotFgPwPi6X0RkUUwr7nfhgAZcvagm58d-scngDvybrBi3WVxANZ8vZuNUaApi5EALw_wcB
        // Links to external site

        driver.get("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110");

       // enter any email

        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "mustafakaralik@gmail.com";
        // enter PASSWORD

        WebElement passInputBox = driver.findElement(By.name("pass"));
        String expectedPass = "76511027Mk";


      // WebElement hesapInputBox = driver.findElement(By.name("Hesap"));
      //WebElement cıkısInputBox = driver.findElement(By.className("d2edcug0 hpfvmrgz qv66sw1b c1et5uql rrkovp55 a8c37x1j keod5gw0 nxhoafnm aigsh9s9 d3f4x2em fe6kdd0r mau55g9w c8b282yb iv3no6db jq4qci2q a3bd9o3v ekzkrbhg oo9gr5id hzawbc8m"));


        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys(expectedEmail);
        passInputBox.sendKeys(expectedPass);

        // verify that email is displayed in the input box

        //somehow we should get text from web elements
        //two main ways to get txt from webelements
        //1.getText-->will work %99 and it will return string
        //2.getAttribute("value")-->second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail ="+ actualEmail);

        String actualPass = passInputBox.getAttribute("value");
        System.out.println("actualPass ="+ actualPass);

        //verify that email is displayed in the input box

        if(expectedEmail.equals(actualEmail) && expectedPass.equals(actualPass)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        //CLİCK ON girişyap PASSWORD

        WebElement girisYapButton = driver.findElement(By.id("loginbutton"));
        girisYapButton.click();

        Thread.sleep(3000);

    }



}
