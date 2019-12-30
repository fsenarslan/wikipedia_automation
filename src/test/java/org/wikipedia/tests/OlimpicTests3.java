package org.wikipedia.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wikipedia.utilities.Driver;
import java.util.*;

public class OlimpicTests3 extends TestBase {

    @Test(description = "Verify that countries' silver medal")
    public void test3() {

        System.out.println(getCountrySilverMedals());

        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("United States", "37");
        expected.put("Great Britain", "23");
        expected.put("China", "18");
        expected.put("Russia", "17");
        expected.put("Germany", "10");
        expected.put("Japan", "8");
        expected.put("France", "18");
        expected.put("South Korea", "3");
        expected.put("Italy", "12");
        expected.put("Australia", "11");

        Assert.assertEquals(expected.toString(), getCountrySilverMedals().toString());

    }
        public Map<String,Integer> getCountrySilverMedals () {

            List<WebElement> countryNames = Driver.get().findElements(By.cssSelector("[class*='plainrowheaders'] th > a"));
            List<WebElement> rows = Driver.get().findElements(By.cssSelector("[class*='plainrowheaders']>tbody>tr>td:nth-of-type(3)"));
            List<WebElement> silverMedals = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                silverMedals.add(rows.get(i));
            }

            Map<String, Integer> map = new LinkedHashMap<>();

            for (int i = 0; i < 10; i++) {
                map.put(countryNames.get(i).getText(), Integer.valueOf(silverMedals.get(i).getText()));
            }
            return map;
        }
    }
