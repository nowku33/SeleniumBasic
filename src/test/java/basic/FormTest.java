package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    /**
     * Fill First name
     * Fill Last name
     * Fill Email
     * Choose a random 'Sex' radiobutton
     * Fill age
     * Choose a random 'Year of experience' radiobutton
     * Choose 'Automation Tester' profession
     * Select random option from 'Continents'
     * Select "Switch Commands" and "Wait Commands" from 'Selenium Commands'
     * Upload some File
     * Click 'Sign in' button
     * Check that "Form send with success" text has been shown
     */
    @Test
    public void simpleAlertsPopUp() {

        Random rand = new Random();

        String firstName = "Test";
        String lastName = "User";
        String email = "test@gmail.com";
        String age = "18";

        driver.get(mainPageAddress + "form.php");

        //filling first name input
        WebElement firstNameInput = driver.findElement(By.id("inputFirstName3"));
        firstNameInput.sendKeys(firstName);

        //filling last name input
        WebElement lastNameInput = driver.findElement(By.id("inputLastName3"));
        lastNameInput.sendKeys(lastName);

        //filling email input
        WebElement emailInput = driver.findElement(By.id("inputEmail3"));
        emailInput.sendKeys(email);

        //sexRadioButtons
        WebElement radioMaleButton = driver.findElement(By.id("gridRadiosMale"));
        WebElement radioFemaleButton = driver.findElement(By.id("gridRadiosFemale"));
        WebElement radioOtherButton = driver.findElement(By.id("gridRadiosOther"));

        //click random sexRadioButton
        List<WebElement> sexRadioButtons = Arrays.asList(radioOtherButton, radioFemaleButton, radioMaleButton);
        WebElement sexRandomRadioButton = sexRadioButtons.get(rand.nextInt(sexRadioButtons.size()));
        sexRandomRadioButton.click();

        //experienceRadioButtons
        List <WebElement> experienceRadioButtons = new ArrayList<>();
        for (int i=1; i<=7; i++ ) {

            experienceRadioButtons.add(driver.findElement(By.id("gridRadios"+ i)));

        }

        //click random experience button
        WebElement experienceRandomRadioButton = experienceRadioButtons.get(rand.nextInt(experienceRadioButtons.size()));
        experienceRandomRadioButton.click();


        //fill age input
        WebElement ageInput = driver.findElement(By.id("inputAge3"));
        ageInput.sendKeys(age);

        //Choose 'Automation Tester' profession
        WebElement profession = driver.findElement(By.xpath("//*[contains(@for, 'gridCheckAutomationTester')]"));
        profession.click();

        //Select random option from 'Continents'
        Select continentDropDownMenu = new Select(driver.findElement(By.id("selectContinents")));
        List<String> continentsToChoose = Arrays.asList("Asia", "Europe", "Africa","Antarctica", "North America", "South America", "Australia");
        String randomCountry = continentsToChoose.get(rand.nextInt(continentsToChoose.size()));
        continentDropDownMenu.selectByVisibleText(randomCountry);

        //Select "Switch Commands" and "Wait Commands" from 'Selenium Commands'
        Select seleniumCommandsMenu = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        seleniumCommandsMenu.selectByVisibleText("Switch Commands");
        seleniumCommandsMenu.selectByVisibleText("Wait Commands");

        //uploading file
        WebElement uploadFile = driver.findElement(By.id("chooseFile"));
        uploadFile.sendKeys("C:\\Users\\lnowek\\Desktop\\UploadTest.xlsx");

        //click submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
        System.out.println(submitButton.getText());
        submitButton.click();

        //Check that "Form send with success" text has been shown
        WebElement validatorMessage = driver.findElement(By.id("validator-message"));
        Assert.assertEquals(validatorMessage.getText(), "Form send with success");

    }
}
