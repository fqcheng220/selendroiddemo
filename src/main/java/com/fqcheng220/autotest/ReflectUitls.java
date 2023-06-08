package com.fqcheng220.autotest;

import io.selendroid.common.device.DeviceTargetPlatform;
import io.selendroid.standalone.android.impl.DefaultAndroidEmulator;
import io.selendroid.standalone.android.impl.DefaultHardwareDevice;
import io.selendroid.standalone.server.model.DeviceStore;
import io.selendroid.standalone.server.model.SelendroidStandaloneDriver;

import java.lang.reflect.Field;

public class ReflectUitls {

    public static DeviceStore getDeviceStore(SelendroidStandaloneDriver driver) {
        if (driver == null)
            return null;
        try {
            Field field = SelendroidStandaloneDriver.class.getDeclaredField("deviceStore");
            field.setAccessible(true);
            DeviceStore deviceStore = (DeviceStore) field.get(driver);
            return deviceStore;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setTargetPlatform(DefaultHardwareDevice o, DeviceTargetPlatform deviceTargetPlatform) {
        if (o == null)
            return;
        try {
            Field field = DefaultHardwareDevice.class.getDeclaredField("targetPlatform");
            field.setAccessible(true);
            field.set(o, deviceTargetPlatform);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setTargetPlatform(DefaultAndroidEmulator o, DeviceTargetPlatform deviceTargetPlatform) {
        if (o == null)
            return;
        try {
            Field field = DefaultAndroidEmulator.class.getDeclaredField("targetPlatform");
            field.setAccessible(true);
            field.set(o, deviceTargetPlatform);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
