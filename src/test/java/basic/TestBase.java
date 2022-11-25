package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected WebDriver driver;
    protected String mainPageAddress = "http://51.75.61.161:9102/";

    @BeforeTest
    public void setUp() {

        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {

        driver.quit();

    }
}
