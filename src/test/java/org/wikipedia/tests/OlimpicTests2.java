package org.wikipedia.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wikipedia.utilities.Driver;

public class OlimpicTests2 extends TestBase {

    @Test(description = "Verify that least gold in Italy")
    public void Test2(){

        Assert.assertEquals(getCountryWithLeastGold(),"Italy");
        Assert.assertEquals(getCountryWithLeastSilver(),"South Korea");
        Assert.assertEquals(getCountryWithLeastBronze(),"Italy");

    }

    private String getCountryWithLeastGold(){
        WebElement sortForGold = Driver.get().findElement(By.xpath("//th[@class='headerSort'] [text()='Gold']"));
        sortForGold.click();
        WebElement leastGoldCountry = Driver.get().findElement(By.cssSelector("[class*='plainrowheaders']  tr:nth-child(1) th > a"));
        return leastGoldCountry.getText();
    }
    private String getCountryWithLeastSilver(){
        WebElement sortForSilver = Driver.get().findElement(By.xpath("//th[@class='headerSort'] [text()='Silver']"));
        sortForSilver.click();
        WebElement leastSilverCountry = Driver.get().findElement(By.cssSelector("[class*='plainrowheaders']  tr:nth-child(1) th > a"));
        return leastSilverCountry.getText();
    }
    private String getCountryWithLeastBronze(){
        WebElement sortForBronze = Driver.get().findElement(By.xpath("//th[@class='headerSort'] [text()='Bronze']"));
        sortForBronze.click();
        WebElement leastBronzeCountry = Driver.get().findElement(By.cssSelector("[class*='plainrowheaders']  tr:nth-child(1) th > a"));
        return leastBronzeCountry.getText();
    }
}
