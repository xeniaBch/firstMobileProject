package com.telran.remindly.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class MainPageTest extends TestBase {

    @Test
    public void findMainPageTextTest(){
        String mainPageText = driver.findElement(By.id("com.blanyal.remindly:id/no_reminder_text")).getText();
        Assert.assertTrue(mainPageText.contains("Click"));
    }

    @Test
    public void openLicensesTest() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
        sleep(300);
        driver.findElement(By.id("com.blanyal.remindly:id/title")).click();
        String license = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")).getText();
        Assert.assertEquals(license, "Licenses");
    }
}
