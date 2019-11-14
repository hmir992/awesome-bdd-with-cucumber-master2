package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {

    WebDriver driver;

    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/v4");
    }

    @Then("^Reset the credential$")
    public void	Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
    }

    @When("^Enter the Username \"([^\"]*)\"and Password \"([^\"]*)\"$")
    public void enter_the_Username_and_Password(String username,String password) throws Throwable
    {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }
}
