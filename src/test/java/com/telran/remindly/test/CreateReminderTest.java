package com.telran.remindly.test;

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
        app.getReminder().fillReminderName("Test", 10);
        app.getReminder().tapOnData();
        app.getReminder().pause(3000);
        app.getReminder().swipeUp();
        app.getReminder().selectDay(17);
        app.getReminder().tapOnOk();
        app.getReminder().switchOffRepeat();
        app.getReminder().enterRepeatNumber("5");
        app.getReminder().swipeDown();
        app.getReminder().selectRepeatTime();
        app.getReminder().saveReminder();
        app.getReminder().pause(500);
        app.getReminder().pause(500);
        quantityAfterAdd = app.getMs().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }
}
