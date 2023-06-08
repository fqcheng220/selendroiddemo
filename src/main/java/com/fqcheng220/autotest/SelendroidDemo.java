package com.fqcheng220.autotest;

import com.fqcheng220.autotest.testcase.AutoTest;
import com.fqcheng220.autotest.testcase.AutoTestOfficialDemoApk;
import com.fqcheng220.autotest.testcase.AutoTestOfficialWebApk;
import com.fqcheng220.autotest.testcase.AutoTestWebViewBaidu;

public class SelendroidDemo {
    public static void main(String[] args) {
//        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
//        driver.get("http://google.com");
//        AutoTest autoTest = new AutoTestOfficialDemoApk();
//        AutoTest autoTest = new AutoTestOfficialWebApk();
        AutoTest autoTest = new AutoTestWebViewBaidu();
        autoTest.run();
    }
}
