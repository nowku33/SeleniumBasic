package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase {

    /**
     * Get all rows from table to List
     * Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 m
     */

    @Test
    public void tableTest() {

        if (driver == null) {
            setUp();
        }
        driver.get(mainPageAddress + "table.php");

        //Get all rows from the table to List
        List<WebElement> allTableRows = driver.findElements(By.xpath("//tbody/tr"));

        int i = 0;
        System.out.println("Mountains that are in Switzerland and are higher than 4000m:");

        //iterating the list
        for (WebElement row : allTableRows) {

            //state & heigh variable
            i++;
            String state = row.findElement(By.xpath("//tbody/tr["+ i +"]/td[3]")).getText();
            int height = Integer.parseInt(row.findElement(By.xpath("//tbody/tr["+ i +"]/td[4]")).getText());

            //checking if the peak is located in Switzerland and is higher than 4000m
            if (state.contains("Switzerland") && height >= 4000) {

                String rank = row.findElement(By.xpath("//tbody/tr["+ i +"]/th")).getText();
                String peak = row.findElement(By.xpath("//tbody/tr["+ i +"]/td[1]")).getText();
                String range = row.findElement(By.xpath("//tbody/tr["+ i +"]/td[2]")).getText();
                System.out.println("-----------------");
                System.out.println("Rank: " + rank);
                System.out.println("Peak: " + peak);
                System.out.println("Mountain range: " + range);

            }

        }

    }
}
