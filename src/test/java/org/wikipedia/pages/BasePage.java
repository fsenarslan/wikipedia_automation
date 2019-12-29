package org.wikipedia.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.wikipedia.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    @FindBy(className = "wikitable sortable plainrowheaders jquery-tablesorter")
    public WebElement table;

    @FindBy(xpath = "//table[contains(@class,'plainrowheaders')]//tbody//tr//td[1]")
    public WebElement ranks;

    @FindBy(xpath = "//th[@class='headerSort'] [text()='NOC']")
    public WebElement NOC;

    @FindBy(css = "[class*='plainrowheaders'] th>a")
    public WebElement countryNames;


}
