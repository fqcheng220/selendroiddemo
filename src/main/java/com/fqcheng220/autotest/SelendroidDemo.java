package com.fqcheng220.autotest;

import com.fqcheng220.autotest.testcase.*;

public class SelendroidDemo {
    public static void main(String[] args) {
//        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
//        driver.get("http://google.com");
//        AutoTest autoTest = new AutoTestOfficialDemoApk();
        AutoTest autoTest = new AutoTestOfficialWebApk();
//        AutoTest autoTest = new AutoTestWebViewBaidu();
//        AutoTest autoTest = new AutoTestWebViewBaidu2();
        autoTest.run();
    }
}
