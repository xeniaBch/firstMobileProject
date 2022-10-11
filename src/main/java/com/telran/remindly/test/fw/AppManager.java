package com.telran.remindly.test.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class AppManager {
    DesiredCapabilities capabilities;
    AppiumDriver driver;

    ReminderHelper reminder;

    MainScreenHelper ms;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "qa_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.blanyal.remindly");
        capabilities.setCapability("appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app", "C:/tools/com.blanyal.remindly_2_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        ms = new MainScreenHelper(driver);
        reminder = new ReminderHelper(driver);
    }

    public MainScreenHelper getMs() {
        return ms;
    }

    public ReminderHelper getReminder() {
        return reminder;
    }

    public void stop() {
        driver.quit();
    }


}
