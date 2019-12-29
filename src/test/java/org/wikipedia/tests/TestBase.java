package org.wikipedia.tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.wikipedia.utilities.ConfigurationReader;
import org.wikipedia.utilities.Driver;


public class TestBase {

    @BeforeMethod
    public void setup(){
        Driver.get().get(ConfigurationReader.getProperty("url"));
        Driver.get().manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        Driver.close();
    }

}
