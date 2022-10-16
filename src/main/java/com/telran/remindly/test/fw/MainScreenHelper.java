package com.telran.remindly.test.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

public class MainScreenHelper extends HelperBase{

    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public String getLicenseHeader() {
        return getText(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView"));
    }

    public String getMainPageText() {
        return getText(By.id("com.blanyal.remindly:id/no_reminder_text"));
    }


    public int getTotalReminders() {
        List<WebElement> imageId = driver.findElements(By.id("thumbnail_image"));
        return imageId.size();
    }

    public String isTitlePresent() {
       return getText(By.id("recycle_title"));
    }
}
