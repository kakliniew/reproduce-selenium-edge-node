package starter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws MalformedURLException {
        EdgeOptions options = new EdgeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium-grid-selenium-hub.selenium-grid/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ustawienie oczekiwania na maksymalnie 10 sekund
    }

    @Given("I open the browser and go to the website")
    public void i_open_the_browser_and_go_to_the_website() {
        driver.get("https://testautomationpractice.blogspot.com/");
    }

   @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("FSsubmit")));
        submitButton.click();
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedMessage) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div:nth-child(1) > div > h1")));
        assertEquals(expectedMessage, errorMessage.getText());
    }

    @When("I fill out the form with:")
    public void i_fill_out_the_form_with(List<List<String>> formData) {
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.clear();
        nameInput.sendKeys(formData.get(0).get(1)); // Sprawdź, czy poprawnie odwołujesz się do danych w liście formData

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys(formData.get(1).get(1));

        WebElement phoneInput = driver.findElement(By.id("phone"));
        phoneInput.clear();
        phoneInput.sendKeys(formData.get(2).get(1));

        WebElement messageInput = driver.findElement(By.id("textarea"));
        messageInput.clear();
        messageInput.sendKeys(formData.get(3).get(1));
    }

    @When("I click on the refresh button")
    public void i_click_on_the_refresh_button() {
        WebElement refreshButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#blog-pager > a")));
        refreshButton.click();
    }

    @Then("the form fields should be empty")
    public void the_form_fields_should_be_empty() {
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement messageInput = driver.findElement(By.id("textarea"));

        assertTrue(nameInput.getText().isEmpty());
        assertTrue(emailInput.getText().isEmpty());
        assertTrue(phoneInput.getText().isEmpty());
        assertTrue(messageInput.getText().isEmpty());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
