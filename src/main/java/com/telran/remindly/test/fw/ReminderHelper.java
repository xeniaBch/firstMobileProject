package com.telran.remindly.test.fw;

import com.telran.remindly.model.Reminder;
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

    public void selectMonth(String month, int number, String type) {
        if(!selectedMonth().equals(month)){
            for (int i = 0; i < number; i++) {
                if(type.equals("future")){
                    swipeUp();
                }else if(type.equals("past")){
                    swipeDown();
                }
            }
        }
    }

    private String selectedMonth() {
        return getText(By.id("date_picker_month"));
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }


    public void selectYear(String year, String type) throws InterruptedException {
        if(!selectedYear().equals(year)){
            if(type.equals("future")){
                swipeUpUntilNeededYear(year);
            }else if(type.equals("past")){
                swipeDownUntilNeededYear(year);
            }
        }
        pause(1000);
        tap(By.id("month_text_view"));
    }

    private void swipeDownUntilNeededYear(String year) {
        while(!selectedYear().equals(year)){
            moveFrom(By.className("android.widget.ListView"), 0.5, 0.6);
            selectedYear();
        }
    }

    private void swipeUpUntilNeededYear(String year) {
        while(!selectedYear().equals(year)){
            moveFrom(By.className("android.widget.ListView"), 0.6, 0.5);
            selectedYear();
        }
    }

    private String selectedYear() {
        return getText(By.id("month_text_view"));
    }

    public void tapOnTime() {
        tap(By.id("time"));
    }

    public void chooseTimeOfDay(String td) {
        if(td.equals("am")){
            pressOnTimer(272,1324);
        } else if (td.equals("pm")){
            pressOnTimer(795, 1324);
        }
    }


    public void enterAllData(Reminder reminder) throws InterruptedException {
        tapOnAddButton();
        fillReminderName(reminder.getText(), reminder.getTime());
        tapOnData();
        pause(reminder.getMillis());
        selectMonth(reminder.getMonth(), reminder.getNumber(), reminder.getMonthType());
        selectDay(reminder.getDay());
        tapOnYear();
        selectYear(reminder.getYear(), reminder.getYearType());
        tapOnOk();
        tapOnTime();
        pause(reminder.getMillis());
        chooseTimeOfDay(reminder.getTimeOfDay());
        pressOnTimer(reminder.getxHour(), reminder.getyHour());
        pressOnTimer(reminder.getxMinute(), reminder.getyMinute());
        tapOnOk();
        switchOffRepeat();
        enterRepeatNumber(reminder.getRepeats());
        swipeDown();
        selectRepeatTime();
        saveReminder();
        pause(reminder.getMillis());
    }
}
