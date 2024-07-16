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
import org.openqa.selenium.JavascriptExecutor;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;


    public void execJS(String script, Object... args){
        ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public void moveElementIntoView(WebElement element){
        execJS("arguments[0].scrollIntoView();", element);
        
    }
    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("Starting RemoteWebDriver");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("remote-allow-or","test-type", "ignore-certificate-errors",
        "incognito", "disable-infobars", "disable-gpu", "disable-default-apps", "disable-popup-blocking","start-maximized", "disable-dev-shm-usage", "--disable-dev-shm-usage", "disable-web-security", "disable-translate");
        driver = new RemoteWebDriver(new URL("http://selenium-grid-selenium-hub.selenium-grid/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    @Given("I open the browser and go to the website")
    public void i_open_the_browser_and_go_to_the_website() {
        driver.get("https://testautomationpractice.blogspot.com/");
    }

   @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        System.out.println("I click on the submit butto");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[2]/td[2]")));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        submitButton.click();
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedMessage) {
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
        }
        System.out.println("I should see " + expectedMessage);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[2]/td[1]")));
        assertEquals(expectedMessage, errorMessage.getText());
        List<WebElement> elementy = driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[2]/td"));
        assertEquals(elementy.size(), 4);
    }

    @When("I fill out the form with:")
    public void i_fill_out_the_form_with(List<List<String>> formData) {
        try {
            Thread.sleep(22000);
        } catch (Exception e) {
        }
        System.out.println("Starting filling inputs");
        WebElement nameInput = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[1]/input[@id=\"name\" and not (@hidden)]"));
        System.out.println("Printing tagname " + nameInput.getTagName() + nameInput.isDisplayed());
        
        nameInput.clear();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        nameInput.sendKeys(formData.get(0).get(1)); 
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
       
        nameInput.click();
        moveElementIntoView(nameInput);

        WebElement emailInput = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[1]/input[@id=\"email\" and not (@hidden)]"));
        System.out.println("Printing tagname " + emailInput.getTagName() + emailInput.isDisplayed());
        emailInput.clear();
        emailInput.sendKeys(formData.get(1).get(1));
        for (int i = 0; i < 20; i++) {
                try {
                    emailInput.click();
                } catch (Exception e) {
                    System.out.println("test");
                }
            
        }
        for (int i = 0; i < 12; i++) {
            
            moveElementIntoView(emailInput);
        }
        

        

        WebElement phoneInput = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div[2]/div[1]/input[3]"));
        System.out.println("Printing tagname " + phoneInput.getTagName() + phoneInput.isDisplayed());
        phoneInput.clear();
        phoneInput.sendKeys(formData.get(2).get(1));
        
        try {
            phoneInput.click();
        } catch (Exception e) {
            System.out.println("test");
        }
        moveElementIntoView(phoneInput);

        WebElement messageInput = driver.findElement(By.id("textarea"));
        System.out.println("Printing tagname " + messageInput.getTagName() + messageInput.isDisplayed());
        messageInput.clear();
        messageInput.sendKeys(formData.get(3).get(1));
        wait.until(ExpectedConditions.elementToBeClickable(messageInput)).click();
    }

    @When("I click on the refresh button")
    public void i_click_on_the_refresh_button() {
        WebElement refreshButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blog-pager\"]/a")));
        refreshButton.click();
    }

    @Then("the form fields should be empty")
    public void the_form_fields_should_be_empty() {
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
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
