package browserfactory;
/*Create a New Java Project with the Name 'amazontest' create BaseTest and TestSuite
and add all jars.
Automate the Following Test.
1. Open the URL https://www.amazon.co.uk/
2. Type "Dell Laptop" in the search box and press enter or click on search
   Button.
3. Click on the checkbox brand dell on the left side.
4. Verify that the  30(May be different) products are displayed on the page.
5. Print all product names in the console.
5. Close the Browser. */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Utility;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setup() {
        // 1. Open the URL https://www.amazon.co.uk/
        openBrowser(baseUrl);
    }
    @Test
    public void amazon() throws InterruptedException {

        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        clickOnElement(By.name("accept"));

        //3. Click on the checkbox brand dell on the left side.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));

        //4. Verify that the  30(May be different) products are displayed on the page.
        int expectedQty = 22;
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQty = elementList.size();
        Assert.assertEquals("Qty not matched", expectedQty, actualQty);

        //5. Print all product names in the console.
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement e : names) {
       System.out.println(e.getText());

       //6.close browser
         //   driver.close();

        }
    }
}

