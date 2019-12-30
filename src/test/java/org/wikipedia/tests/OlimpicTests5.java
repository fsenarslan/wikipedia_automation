package org.wikipedia.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wikipedia.utilities.Driver;

import java.util.*;

public class OlimpicTests5 extends TestBase{

    @Test(description = "Verify sum of bronze medals are equal to 18")
    public void Test5(){

        System.out.println(countryRowAndColumn());
        Assert.assertEquals("[Italy, Australia]",countryRowAndColumn().toString());
    }


    public List<String> countryRowAndColumn(){
        List<String> sum18Countries = new ArrayList<>();
        List<WebElement> countryNames = Driver.get().findElements(By.cssSelector("[class*='plainrowheaders'] th > a"));
        List<WebElement> bronzeMedals = Driver.get().findElements(By.cssSelector("[class*='plainrowheaders'] tr > td:nth-child(5)"));
            for(int i=0; i<bronzeMedals.size(); i++){
                for(int j=i+1; j<bronzeMedals.size(); j++){
               if ((Integer.parseInt(bronzeMedals.get(i).getText()))+(Integer.parseInt(bronzeMedals.get(j).getText())) == 18) {
                    sum18Countries.add(countryNames.get(i).getText());
                    sum18Countries.add(countryNames.get(j).getText());
               }
               }
            }

        return sum18Countries;
    }
}
