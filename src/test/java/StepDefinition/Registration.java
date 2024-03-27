package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Registration {
    WebDriver driver=null;

    @Before
    public void setUp()  {
        System.setProperty("webdriver.edge.driver","C:\\Users\\a911612\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

    @Given("l'utilisateur est dans la page d'inscription")
    public void l_utilisateur_est_dans_la_page_d_inscription() throws InterruptedException {
        driver.get("http://practice.automationtesting.in/");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();


    }
    @When("l'utilisateur saisi l'email et le mot de passe valide")
    public void l_utilisateur_saisi_l_email_et_le_mot_de_passe_valide() {
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("anassroudane@gmail.com");
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Livinglove12345");

    }
    @And("l'utilisateur clique sur le bouton inscription")
    public void l_utilisateur_clique_sur_le_bouton_inscription() {
        driver.findElement(By.xpath("//input[@name='register']")).click();

    }
    @Then("inscription réussi et affichage de la page login")
    public void inscription_réussi_et_affichage_de_la_page_login() {
        driver.getPageSource().contains("Hello anssroudane");

    }


    @When("l'utilisateur saisi email valide et mot de passe invalide")
    public void l_utilisateur_saisi_email_valide_et_mot_de_passe_invalide() {
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("anassroudane@gmail.com");
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("123");
    }


    @Then("inscription echoué")
    public void inscription_echoué() {
     driver.getPageSource().contains("Very weak - Please enter a stronger password.");
    }


    @When("l'utilisateur saisi un mail valide et mot de passe vide")
    public void l_utilisateur_saisi_un_mail_valide_et_mot_de_passe_vide() {
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("anassroudane@gmail.com");
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("");

    }
    @Then("affichage d'un message d'erreur")
    public void affichage_d_un_message_d_erreur() {
      driver.getPageSource().contains("Error: Please enter an account password.");
    }
}
