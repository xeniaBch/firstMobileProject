package com.telran.remindly.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class MainScreenTest extends TestBase {

    @Test
    public void findMainPageTextTest(){
        String mainPageText = app.getMs().getMainPageText();
        Assert.assertTrue(mainPageText.contains("Click"));
    }

    @Test
    public void openLicensesTest() throws InterruptedException {
        app.getMs().tap(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"));
        app.getMs().pause(300);
        app.getMs().tap(By.id("com.blanyal.remindly:id/title"));
        String license = app.getMs().getLicenseHeader();
        Assert.assertEquals(license, "Licenses");
    }

}
