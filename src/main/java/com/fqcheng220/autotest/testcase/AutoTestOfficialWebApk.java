package com.fqcheng220.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutoTestOfficialWebApk extends AutoTest {
    public void run() {
        launchSelendroid(null);

        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
//        driver.get("http://www.baidu.com");
        driver.get("http://baidu.com");


        if (driver == null)
            return;
        while (true);
//        WebElement inputField = driver.findElement(By.id("index-btn"));
////        Assert.assertEquals("true", inputField.getAttribute("enabled"));
//        inputField.sendKeys("Selendroid");
////        Assert.assertEquals("Selendroid", inputField.getText());
//        driver.quit();
    }
}
