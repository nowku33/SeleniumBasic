package basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends TestBase{

    private final String alertsPageAddress = mainPageAddress+"alerts.php";

    /**
     * Click on 'Simple Alert' button
     * Click 'OK' button on alert
     * Check that "OK button pressed" text has been shown
     */

    @Test
    public void simpleAlertsPopUp() {

        driver.get(alertsPageAddress);
        WebElement simpleAlertBtn = driver.findElement(By.id("simple-alert"));
        simpleAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(alertText, "OK button pressed");

    }

    /**
     * Click on 'Prompt Pop up' button
     * Type "Lord Vader" in the alert text box
     * Click 'OK' button on alert
     * Check that "Hello Lord Vader! How are you today?" text has been shown
     */

    @Test
    public void promptAlertPopUp() {

        driver.get(alertsPageAddress);
        WebElement promptAlertBtn = driver.findElement(By.id("prompt-alert"));
        promptAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        String keysToSend = "Lord Vader";
        alert.sendKeys(keysToSend);
        alert.accept();
        String alertText = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(alertText, "Hello " + keysToSend + "! How are you today?");

    }

    /**
     * Click on 'Confirm Pop up' button
     * Click 'OK' button on alert
     * Check that "You pressed OK!" has been shown
     * Click again on 'Confirm Pop up' button
     * Click 'Anuluj'/'Cancel' button on alert
     * Check that "You pressed Cancel!" text has been shown
     */

    @Test
    public void confirmAlertBox() {

        driver.get(alertsPageAddress);
        WebElement confirmAlertBtn = driver.findElement(By.id("confirm-alert"));
        confirmAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String confirmText = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(confirmText, "You pressed OK!");
        confirmAlertBtn.click();
        alert.dismiss();
        confirmText = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(confirmText, "You pressed Cancel!");

    }

    /**
     * Click on 'Delayed alert' button
     * Wait for an alert to appear
     * Click 'OK' button on alert
     * Check that "OK button pressed" text has been shown
     */

    @Test
    public void delayedAlert() {

        driver.get(alertsPageAddress);
        WebElement delayedAlertBtn = driver.findElement(By.id("delayed-alert"));
        delayedAlertBtn.click();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String delayedAlertText = driver.findElement(By.id("delayed-alert-label")).getText();
        Assert.assertEquals(delayedAlertText, "OK button pressed");

    }
}
