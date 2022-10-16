package com.telran.remindly.test;

import com.telran.remindly.model.Reminder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateReminderTest extends TestBase{

    @Test
    public void addReminderWithDefaultDataTest() throws InterruptedException {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMs().getTotalReminders();
        app.getReminder().tapOnAddButton();
        app.getReminder().fillReminderName("Test", 10);
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        quantityAfterAdd = app.getMs().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithRandomSwipeTest() throws InterruptedException {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMs().getTotalReminders();
        app.getReminder().tapOnAddButton();
        app.getReminder().fillReminderName("Happy Birthday", 10);
        app.getReminder().tapOnData();
        app.getReminder().pause(3000);
        app.getReminder().selectMonth("DEC", 2, "future");
        app.getReminder().selectDay(8);
        app.getReminder().tapOnYear();
        app.getReminder().selectYear("2024", "future");
        app.getReminder().tapOnOk();
        app.getReminder().tapOnTime();
        app.getReminder().pause(100);
        app.getReminder().chooseTimeOfDay("pm");
        app.getReminder().pressOnTimer(535, 1194);
        app.getReminder().pressOnTimer(771, 786);
        app.getReminder().tapOnOk();
        app.getReminder().switchOffRepeat();
        app.getReminder().enterRepeatNumber("5");
        app.getReminder().swipeDown();
        app.getReminder().selectRepeatTime();
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        quantityAfterAdd = app.getMs().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
        app.getReminder().pause(500);
        Assert.assertTrue(app.getMs().isTitlePresent().contains("Happy birthday"));
    }
    @Test
    public void addReminderRegressionTest() throws InterruptedException {
        app.getReminder().enterAllData(new Reminder().setText("Happy Birthday").setTime(10).setMillis(3000)
                        .setMonth("DEC").setNumber(2).setMonthType("future").setYear("2024").setYearType("future")
                        .setTimeOfDay("pm").setxHour(535).setyHour(1194).setxMinute(771).setyMinute(786)
                        .setRepeats("5"));
        Assert.assertTrue(app.getMs().isTitlePresent().contains("Happy birthday"));
    }
}
