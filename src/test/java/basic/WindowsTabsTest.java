package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WindowsTabsTest extends TestBase {

    /**
     * Click on 'New Browser Window' button
     * Switch to a new window
     * Execute test from 4th exercise on the newly opened window
     * Close window
     * Click 'New Message Window' button
     * Switch to a new window
     * Print out the text that is written in a new window
     * Close window
     * Click on 'New Browser Tab' button
     * Switch to a new tab
     * Execute test from 4th exercise on the new opened tab
     * Close tab
     */

    @Test
    public void windowsTabsTest() {

        TableTest tableTest = new TableTest(); //object with tableTest

        driver.get(mainPageAddress + "windows-tabs.php");

        //Click on 'New Browser Window' button
        WebElement newBrowserWindow = driver.findElement(By.id("newBrowserWindow"));
        String mainWindowHandle = driver.getWindowHandle();
        newBrowserWindow.click();

        //Switch to a new window
        switchWindowHandle();

        //Execute test from 4th exercise on the newly opened window
        tableTest.tableTest();

        //Close window
        driver.close();

        //Click 'New Message Window' button
        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getCurrentUrl());

        //Click 'New Message Window' button
        WebElement newMessageWindow = driver.findElement(By.id("newMessageWindow"));
        newMessageWindow.click();

        //Switch to a new window
        switchWindowHandle();

        //printing text that is written in a new window
        System.out.println(driver.findElement(By.xpath("//body")).getText());

        driver.close();

        //switch to main window
        driver.switchTo().window(mainWindowHandle);

        //Click on 'New Browser Tab' button
        WebElement newTabWindow = driver.findElement(By.id("newBrowserTab"));
        newTabWindow.click();

        //Switch to a new window
        switchWindowHandle();

        //Execute test from 4th exercise on the newly opened tab
        tableTest.tableTest();

        driver.close();

    }

    private void switchWindowHandle() {
        for(String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

}
