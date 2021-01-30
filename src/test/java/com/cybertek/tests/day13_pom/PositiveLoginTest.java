package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

@Test
    public void loginAsDriver (){

    LoginPage loginpage = new LoginPage();

    String username = ConfigurationReader.get("driver_username");
    String password = ConfigurationReader.get("driver_password");

    loginpage.usernameInput.sendKeys(username);
    loginpage.passwordInput.sendKeys(password);
    loginpage.loginBtn.click();

    Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
}
    @Test
    public void loginAsStoreManager(){
        LoginPage loginpage = new LoginPage(); // loginpage object

        String username = ConfigurationReader.get("storemanager_username"); //tüm bu iki satır yerine
        String password = ConfigurationReader.get("storemanager_password"); //sadece  loginpage.loginAsStoreManager(); yazdık

     /*   loginpage.usernameInput.sendKeys(username);
        loginpage.passwordInput.sendKeys(password);     //tum bu satırları  login page
        loginpage.loginBtn.click();*/             //  yazıp loginpage metodu ile curaya aldık
                                //sadece  loginpage.login(username,password); kullandık

        loginpage.login(username,password); //LoginPage class içinde loginpage objesi ile login metodu içine yollama
        //OBJ    .METHOD-->LOGİNPAGE İÇİNDE iki parameter oraya yolluyoruz param üstte String username/password

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsStoreManager2(){

       LoginPage loginpage = new LoginPage();

       loginpage.loginAsDriver();//burada metod içine parametera gerek yok çünkü direk loginAsStoreManager metodu içinde var

       Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
}
