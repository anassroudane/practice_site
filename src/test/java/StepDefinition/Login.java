package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class Login {

    WebDriver driver=null;

    @Before
    public void setUp()  {
        System.setProperty("webdriver.edge.driver","C:\\Users\\a911612\\Downloads\\edgedriver_win64");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }


    @Given("l'utilisateur se positionne dans page login")
    public void l_utilisateur_se_positionne_dans_page_login() throws InterruptedException {
        driver.get("https://practice.automationtesting.in/my-account/");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
    }
    @When("l'utilisateur saisi {string} et le {string}")
    public void l_utilisateur_saisi_et_le(String email, String password) throws InterruptedException {
        WebElement emails = driver.findElement(By.xpath("//input[@id='username']"));
        emails.sendKeys(email);
        WebElement passwords= driver.findElement(By.xpath("//input[@id='password']"));
        passwords.sendKeys(password);
        Thread.sleep(5000);
    }
    @And("clique sur le button login")
    public void clique_sur_le_button_login() {
        WebElement login=driver.findElement(By.xpath("//input[@name='login']"));
        login.click();
    }
    @Then("je devrais {string}")
    public void je_devrais(String resultat) {
        if (resultat.equals("etre connecté ")){
            driver.getPageSource().contains("Hello anassroudane");
        } else if (resultat.equals("ne pas etre connecté")) {
            System.out.println("impossible de se connecter");

        }
    }
}
