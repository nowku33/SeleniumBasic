package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    /**
     * Switch to the first iframe and fill form
     * Switch to the second iframe and fill form
     * Switch to the main frame and click on 'Basic' button in the main menu
     */
    @Test
    public void iframeTest() {

        driver.get(mainPageAddress + "iframes.php");

        //Switch to the first iframe and fill form
        WebElement iframe1 = driver.findElement(By.name("iframe1"));
        driver.switchTo().frame(iframe1);
        //TODO fill form1

        //Switch to the second iframe and fill form
        driver.switchTo().parentFrame();
        WebElement iframe2 = driver.findElement(By.name("iframe2"));
        driver.switchTo().frame(iframe2);
        //TODO fill form2

        //Switch to the main frame and click on 'Basic' button in the main menu
        driver.switchTo().parentFrame();
        WebElement basicButton = driver.findElement(By.xpath("//a"));
        basicButton.click();

    }
}
