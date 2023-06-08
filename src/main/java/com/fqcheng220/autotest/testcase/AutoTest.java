package com.fqcheng220.autotest.testcase;

import com.fqcheng220.autotest.ReflectUitls;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.standalone.android.AndroidDevice;
import io.selendroid.standalone.android.impl.DefaultAndroidEmulator;
import io.selendroid.standalone.android.impl.DefaultHardwareDevice;
import io.selendroid.standalone.server.model.DeviceStore;
import io.selendroid.standalone.server.model.SelendroidStandaloneDriver;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AutoTest {
    public abstract void run();

    void launchSelendroid(String appPath) {
        //Start selendroid-standalone during test
        SelendroidConfiguration config = new SelendroidConfiguration();
        config.setSelendroidServerPort(10000);
        config.setServerStartRetries(0);

// Add the selendroid-test-app to the standalone server
        if(appPath != null && appPath.length() > 0){
            config.addSupportedApp(appPath);
        }

//start the standalone server
        SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();

        /**
         * 以下代码是修改devicestore中所有设备信息，增加targetPlatform成员变量为DeviceTargetPlatform.ANDROID23
         * 以跳过检查，不加的话，默认4444端口的server在接受客户端创建session请求时会报空指针
         *
         * 1.基于selendroid-standalone：0.17.0源码去修改实现
         * 2.使用selendroid-standalone：0.17.0，反射修改行为状态（此处使用）
         */
        SelendroidStandaloneDriver driver = selendroidServer.getServer().getDriver();
        DeviceStore deviceStore = ReflectUitls.getDeviceStore(driver);
        if (deviceStore != null) {
            List<AndroidDevice> list = deviceStore.getDevices();
            if (list != null) {
                for (AndroidDevice device : list) {
                    if (device != null) {
                        if (device instanceof DefaultHardwareDevice) {
                            ReflectUitls.setTargetPlatform((DefaultHardwareDevice) device, DeviceTargetPlatform.ANDROID23);
                        } else if (device instanceof DefaultAndroidEmulator) {
                            ReflectUitls.setTargetPlatform((DefaultAndroidEmulator) device, DeviceTargetPlatform.ANDROID23);
                        }
                    }

                }
            }
        }
    }

    WebDriver prepare(final String aut){
        SelendroidCapabilities capa = new SelendroidCapabilities(aut);
        try {
            WebDriver driver = new SelendroidDriver(capa);
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
