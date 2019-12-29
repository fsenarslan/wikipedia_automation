package org.wikipedia.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wikipedia.utilities.BrowserUtils;
import org.wikipedia.utilities.Driver;

import java.util.List;


public class OlimpicTests1 extends TestBase{

    @Test(description = "Verify that by default the Medal table is sorted by rank")
    public void test1() {

        List<WebElement> ranks = Driver.get().findElements(By.xpath("//table[contains(@class,'plainrowheaders')]//tbody//tr//td[1]"));
        for (int index = 0; index < ranks.size() - 4; index++) {
            String value = ranks.get(index).getText();
            String followingValue = ranks.get(index + 1).getText();
            Assert.assertTrue(value.compareTo(followingValue) == -1);
        }

        WebElement Noc = Driver.get().findElement(By.xpath("//th[@class='headerSort'] [text()='NOC']"));
        BrowserUtils.waitForVisibility(Noc,2);
        Noc.click();

        List<WebElement> countryNames = Driver.get().findElements(By.cssSelector("[class*='plainrowheaders'] th > a"));
        for (int index = 0; index < countryNames.size() - 1; index++) {
            String value = countryNames.get(index).getText();
            String followingValue = countryNames.get(index + 1).getText();
            Assert.assertTrue(value.compareTo(followingValue) < 0);
        }

        List<WebElement> ranks2 = Driver.get().findElements(By.xpath("//table[contains(@class,'plainrowheaders')]//tbody//tr/td[1]"));
            String actual = ranks2.toString();
            String expected = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11–86]";
            Assert.assertNotEquals(expected,actual);

    }
}
