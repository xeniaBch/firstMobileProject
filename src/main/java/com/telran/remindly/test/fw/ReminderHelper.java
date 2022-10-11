package com.telran.remindly.test.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends HelperBase{
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnAddButton() {
        tap(By.id("add_reminder"));
    }

    public void fillReminderName(String text, int time) {
        waitForElementAndType(By.id("reminder_title"), time,  text);
        hideKeyboard();
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnData() {
        tap(By.id("date_text"));
    }


    public void selectDay(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void switchOffRepeat() {
        if(!getText(By.id("set_repeat")).equals("Off")) {
            tap(By.id("repeat_switch"));
        }
    }

    public void enterRepeatNumber(String count) {
        tap(By.id("RepeatNo"));
        waitForElementAndType(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText"), 30, count);
        hideKeyboard();
        pressOk();
        hideKeyboard();
    }

    public void selectRepeatTime() {
        tap(By.id("RepeatType"));
        waitForElementAndTap(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"), 10);

    }


    public void pressOk() {
        List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
        buttons.get(1).click();
    }

}
