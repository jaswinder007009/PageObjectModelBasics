package com.Ex2.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowManager {

    private WebDriver driver;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
    }

    // Switch to the newest tab that opened
    public void switchToNewTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    // Switch back to the first/original tab
    public void switchToOriginalTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    // Switch to a tab by its index
    public void switchToTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (index < tabs.size()) {
            driver.switchTo().window(tabs.get(index));
        } else {
            throw new IllegalArgumentException("Invalid tab index: " + index);
        }
    }

    // Switch to a tab by its title
    public void switchToTabByTitle(String title) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                return;
            }
        }
        throw new RuntimeException("No tab with title: " + title);
    }

    // Close current tab and return to original
    public void closeCurrentTabAndSwitchBack() {
        String original = driver.getWindowHandles().iterator().next();
        driver.close();
        driver.switchTo().window(original);
    }

    // Get total open tabs
    public int getTabCount() {
        return driver.getWindowHandles().size();
    }
}
