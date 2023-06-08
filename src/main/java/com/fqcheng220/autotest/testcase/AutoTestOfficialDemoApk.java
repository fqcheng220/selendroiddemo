package com.fqcheng220.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoTestOfficialDemoApk extends AutoTest {
    public void run() {
        launchSelendroid("C:\\Users\\Administrator\\Downloads\\selendroid-test-app-0.17.0.apk");
        WebDriver driver = prepare("io.selendroid.testapp:0.17.0");

        if (driver == null)
            return;
        WebElement inputField = driver.findElement(By.id("my_text_field"));
//        Assert.assertEquals("true", inputField.getAttribute("enabled"));
        inputField.sendKeys("Selendroid");
//        Assert.assertEquals("Selendroid", inputField.getText());
        driver.quit();
    }
}
