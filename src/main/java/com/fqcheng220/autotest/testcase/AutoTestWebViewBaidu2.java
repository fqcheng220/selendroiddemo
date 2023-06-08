package com.fqcheng220.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoTestWebViewBaidu2 extends AutoTest{

    public void run() {
        launchSelendroid("D:\\MyWork\\Java\\Projects\\selendroiddemo\\src\\main\\resources\\com.fqcheng220.android.selendroiddemoapk.app-debug.apk");
        WebDriver driver = prepare("com.fqcheng220.android.selendroiddemoapk:1.0");
//        WebElement webElement = driver.findElement(By.id("index-btn"));
//        webElement.click();
        WebElement webElement = driver.findElement(By.className("android.webkit.WebView"));
        while (true);
    }
}
