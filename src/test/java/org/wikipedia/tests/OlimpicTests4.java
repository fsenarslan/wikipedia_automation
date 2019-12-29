package org.wikipedia.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.wikipedia.utilities.Driver;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OlimpicTests4 extends TestBase{
    @Test(description = "Verify countries' row and column")
    public void Test4(){

        System.out.println(countryRowAndColumn());

    }

    public Map<String,String> countryRowAndColumn(){

        List<WebElement> countryNames = Driver.get().findElements(By.cssSelector("[class*='plainrowheaders'] th > a"));

        int[][] rowAndColumn = new int[10][2];
        int rowindex = 1;
        for (int i = 0; i < 10; i++) {
            for(int j=0; j<1; j++) {
                rowAndColumn[i][j]=rowindex;
            }
            rowindex++;
        }
        int columnndex=2;
        for (int i = 0; i < 10; i++) {
            for(int j=1; j<2; j++) {
                rowAndColumn[i][j]=columnndex;
            }
        }


        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
                map.put(countryNames.get(i).getText(), Arrays.toString(rowAndColumn[i]));
        }

        return map;
    }

}
