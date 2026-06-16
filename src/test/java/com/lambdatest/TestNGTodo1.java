package com.lambdatest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY");

        String hub = "@hub.lambdatest.com/wd/hub";
        String nam4e=ctx.getSuite().getName();

//        Map<String, String> headers = new HashMap<>();
//        headers.put("X-LT-AR-Test", "true");
//
//        List<String> urlFilters = Arrays.asList(
//                "https://www.xhaus.com/headers"
//        );
//


        // ✅ Use LambdaTest W3C-compliant structure (LT:Options)
        MutableCapabilities ltOptions = new MutableCapabilities();
        ltOptions.setCapability("build", "TestNG With Java-selenium");
        ltOptions.setCapability("platformName", "win11");
        // Windows platform
        ltOptions.setCapability("username", username);
        ltOptions.setCapability("accessKey", authkey);
        //  ltOptions.setCapability("timezone", "Los_Angeles");
        ltOptions.setCapability("project", "Untitled");
  //      ltOptions.setCapability("geoLocation", "US");
        ltOptions.setCapability("name", nam4e);
   //     ltOptions.setCapability("autoAcceptAlerts", true);
        ltOptions.setCapability("browserName", "chrome");
//        ltOptions.setCapability("customHeaders", headers);
//        ltOptions.setCapability("customUrlFilters", urlFilters);
  //      ltOptions.setCapability("fixedIP", "10.255.32.118");
      //  ltOptions.setCapability("selenium_version", "4.0.0");
    //    ltOptions.setCapability("dedicatedProxy", true);
   //    ltOptions.setCapability("network", true);
     //  ltOptions.setCapability("network.http2", true);
     //   ltOptions.setCapability("mitm", true);

  //    ltOptions.setCapability("region", "ap");
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

    @Test
    public void basicTest() throws InterruptedException {

//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
//
//// Implicit wait = 0 sec
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//
//// Page load timeout = 300 sec
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
//
//// Navigate to URL

        driver.get("https://www.google.com/");


//
//// Resize window
//        driver.manage().window().setSize(new Dimension(600, 900));
//
//// Set implicit wait = 20 sec
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//// Add cookie
//        driver.manage().addCookie(
//                new Cookie("automation_override", "True")
//        );
//
//// Refresh page
//        driver.navigate().refresh();
//
//// Execute JavaScript
//        ((JavascriptExecutor) driver).executeScript(
//                "document.cookie = 'ab_uid=off;expires=' + " +
//                        "new Date('Jan 1 2030').toUTCString() + " +
//                        "'; path=/;domain=.' + " +
//                        "window.location.hostname.split('.').slice(-2).join('.');" +
//                        "window.localStorage.removeItem('gbFeaturesCache');"
//        );
//
//// Refresh again
//        driver.navigate().refresh();
//
//// Take screenshot
//        File screenshot = ((TakesScreenshot) driver)
//                .getScreenshotAs(OutputType.FILE);
//
//// Mark test as failed on LambdaTest
//        ((JavascriptExecutor) driver)
//                .executeScript("lambda-status=failed");
//
//// Set test name
//        ((JavascriptExecutor) driver)
//                .executeScript(
//                        "lambda-name=Express Checkout > Returning Customer Purchase Basic Product Using New Collection Address"
//                );

   //     Thread.sleep(120000);



//        System.out.println("Loading Url");
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Opening WebApp\", \"level\": \"info\"}}");
//
//        driver.get("https://lambdatest.github.io/sample-todo-app/");
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Checking List Items\", \"level\": \"info\"}}");
//
//        System.out.println("Checking Boxes...");
//        driver.findElement(By.name("li1")).click();
//        driver.findElement(By.name("li2")).click();
//        driver.findElement(By.name("li3")).click();
//        driver.findElement(By.name("li4")).click();
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding Items\", \"level\": \"info\"}}");
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Checking More Items\", \"level\": \"info\"}}");
//
//        driver.findElement(By.name("li1")).click();
//        driver.findElement(By.name("li3")).click();
//        driver.findElement(By.name("li7")).click();
//        driver.findElement(By.name("li8")).click();
//        Thread.sleep(300);
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding and Verify List Items\", \"level\": \"info\"}}");
//        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.name("li9")).click();
//
//        String spanText = driver.findElement(By.xpath("//li[9]/span")).getText();
//        Assert.assertEquals(spanText.trim(), "Get Taste of Lambda and Stick to It");
//
//        Status = "passed";
//        Thread.sleep(150);
//
//        System.out.println("Test Finished");
    }

    @AfterMethod
    public void tearDown() {
        try {
            if (driver != null) {
                driver.executeScript("lambda-status=" );
            }
        }finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
