package com.fqcheng220.autotest.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * 因为自带的io.selendroid.androiddriver这个apk包，不适配超过6.0的系统
 * 所以如果这个apk包安装在6.0以上系统
 * 可能会出现两个问题
 * 1.启动app提示apk版本过老
 * 2.webview无法成功加载url，因为需要在shouldOverrideUrl函数中再次执行WebView#loadUrl才行
 *
 * 所以暂且限定运行的机器版本
 * 后续可以想办法替换掉io.selendroid.androiddriver这个apk包
 */
public class AutoTestOfficialWebApk extends AutoTest {
    public void run() {
        launchSelendroid(null);

        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
//        driver.get("http://www.baidu.com");
        driver.get("http://baidu.com");


        if (driver == null)
            return;
        WebElement inputField = driver.findElement(By.id("index-kw"));
//        Assert.assertEquals("true", inputField.getAttribute("enabled"));
        inputField.sendKeys("Selendroid");
//        Assert.assertEquals("Selendroid", inputField.getText());
        WebElement btnConfirm = driver.findElement(By.id("index-bn"));
        btnConfirm.click();
        while (true) ;
//        driver.quit();
    }
}
