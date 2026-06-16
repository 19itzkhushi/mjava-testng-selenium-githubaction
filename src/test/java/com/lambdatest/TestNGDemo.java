package com.lambdatest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class TestNGDemo {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "khushictestmuai";
        String authkey = "LT_vuJsWOQrB8O9JFHmWG0WxyuoP9fX5etQ0mUzUS5YICynpfO";

        String hub = "@hub.lambdatest.com/wd/hub";
        String nam4e = ctx.getSuite().getName();
        // ✅ Use LambdaTest W3C-compliant structure (LT:Options)
        MutableCapabilities ltOptions = new MutableCapabilities();
        ltOptions.setCapability("build", "AutoHeal Build-6");
        ltOptions.setCapability("platformName", "win11");
        // Windows platform
        ltOptions.setCapability("username", username);

        ltOptions.setCapability("accessKey", authkey);
        //  ltOptions.setCapability("timezone", "Los_Angeles");
        ltOptions.setCapability("project", "Untitled");
        //      ltOptions.setCapability("geoLocation", "US");
        ltOptions.setCapability("name", nam4e);
        //   ltOptions.setCapability("region", "us");
        ltOptions.setCapability("smartWait", 0);
        //   ltOptions.setCapability("smartWaitRetryDelay", 1000);
        //  ltOptions.setCapability("autoAcceptAlerts", true);
        ltOptions.setCapability("browserName", "chrome");
        //      ltOptions.setCapability("fixedIP", "10.255.32.118");
        //  ltOptions.setCapability("selenium_version", "4.0.0");
        //   ltOptions.setCapability("dedicatedProxy", true);
        //  ltOptions.setCapability("network", true);

        //  ltOptions.setCapability("region", "us-east-1");
//        ltOptions.setCapability("tags", new String[] { "Feature", "Falcon", "Severe" });

/*
Enable Smart UI Project (optional)
ltOptions.setCapability("smartUI.project", "<Project Name>");
*/

// ✅ Chrome browser setup for Windows
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("browserVersion", "latest");
        browserOptions.setCapability("LT:Options", ltOptions);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), browserOptions);
    }


    @Test(enabled = true, groups = {"debug"})

    public void autoHealSimpleDemoWithHooks() {
        driver.get("https://www.selenium.dev/ ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "var input = document.createElement('input');" +
                        "input.id = 'autoheal-demo-input';" +
                        "input.name = 'organizationName';" +
                        "input.placeholder = 'Organization Name';" +
                        "input.style = 'position:fixed;top:100px;left:100px;z-index:9999;padding:10px;';" +
                        "document.body.appendChild(input);"
        );
        try {
            js.executeScript("lambdatest_executor:{\"action\":\"lambda-heal-start\"}");
            System.out.println("AutoHeal started");

            WebElement input1 = driver.findElement(By.id("autoheal-demo-input"));
            input1.sendKeys("Univers");
            System.out.println("Original locator worked");

            js.executeScript(
                    "document.getElementById('autoheal-demo-input').id='autoheal-demo-input-new';"
            );
            System.out.println("Locator changed intentionally");

            WebElement input2 = driver.findElement(By.id("autoheal-demo-input"));
            input2.clear();
            input2.sendKeys("Universi");
            System.out.println("AutoHeal recovered old locator");

        } finally {
            js.executeScript("lambdatest_executor:{\"action\":\"lambda-heal-stop\"}");
            System.out.println("AutoHeal stopped");
            driver.quit();
        }

    }
}






