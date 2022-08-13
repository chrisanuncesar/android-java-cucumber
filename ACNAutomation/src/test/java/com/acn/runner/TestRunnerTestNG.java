package com.acn.runner;

import com.acn.base.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.acn.steps"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@TC.004"
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

    @Parameters({ "deviceID" })
    @BeforeSuite
    public void setUp() throws Exception {
        System.out.println("Launch app");
        DriverManager.initializeDriver("1");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("quit driver");
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
