package com.fqcheng220.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoTestWebViewBaidu extends AutoTest{

    public void run() {
        launchSelendroid("D:\\PrivateWork\\Flutter\\Projects\\metachatapp\\chat_sdk\\SelenuimTargetTestDemo\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
        WebDriver driver = prepare("com.fqcheng220.selenuimtargettestdemo:1.0");
//        WebElement webElement = driver.findElement(By.id("index-btn"));
//        webElement.click();
        while (true);
    }
}
