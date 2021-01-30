package com.cybertek.tests.day11_webTables;

import com.cybertek.utilities.WebDriverFactory;
import net.bytebuddy.implementation.InvokeDynamic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class WebTableExamples {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables"); //tüm testlerde aynı sayfa açılacak ise
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getAllHeaders() throws InterruptedException {
        //How many columns we have
        //number of <th>represent for number of column
        //we can jump directly go to child  with using // but one by one decrese to child ewe need to use /
        //table[@id='table1']//th --->only //th iz enough otherwise /thead/tr/th sould be written
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

    }

    @Test
    public void printTable() throws InterruptedException {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());

        //tüm tablo içindeki veriden bir bölümünün orada olduğunu doğrulamak için .contains
        //Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
        Assert.assertTrue(table.getText().contains("yotmail.com"));

    }

    @Test
    public void printTableSize() throws InterruptedException {
        //how many columns we have ?

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header (we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
        //when we select first tbody is exclude tr which is inside header --> table[@id='table1']/tbody/tr
    }

    @Test
    public void getRow () {

        //print the only second row information
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']//tr[2]"));
        System.out.println(row2.getText());

        //get all rows dynamically
        //1.Find number of Rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2.iterate one by one
        for (int i = 1; i <=numRows.size() ; i++) {

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+row.getText());

        }

    }
    @Test
    public void allCellInOneRow () {
        List<WebElement> allcellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement webElement : allcellsInOneRow) {
            System.out.println(webElement.getText());

        }
    }
    @Test
    public void singleCellByIndex () {               //table[1]//*[.='http://www.jdoe.com'] without index no
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());
    }

    @Test
    public void printAllCellByIndex () {

        int rowNumber =getNumberOfRows();
        int colNumber =getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);
        //ITERATE THROUGH EACH ROW row THE TABLE
        for (int i = 1; i <= rowNumber; i++) {
            //ITERATE THROUGH EACH cell in THE TABLE
            for (int j = 1; j <= colNumber; j++) {
                String cellxPath= "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellxPath);

                WebElement cell =driver.findElement(By.xpath(cellxPath));
                System.out.println(cell.getText());

            }

        }

    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow () {

        String firsName= "Jason";

        String xpath ="//table[@id='table1']//td[.='"+firsName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }
    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();
    }
}
