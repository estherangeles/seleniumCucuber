package pruebas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import static junit.framework.Assert.*;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	@Given("^navego a la pagina de sinatra$")
	public void navego_a_la_pagina_de_sinatra() {
	    driver.get("https://songs-by-sinatra.herokuapp.com");
	}

	@When("^Me logueo con el usuario: ([^\"]*) y el password: ([^\"]*)$")
	public void Me_logueo_con_el_usuario_frank_y_el_password_sinatra(String user, String pass) {
	    driver.findElement(By.xpath("//a[contains(text(), 'log')]")).click();
	    driver.findElement(By.id("username")).sendKeys(user);
	    driver.findElement(By.id("password")).sendKeys(pass);
	    driver.findElement(By.xpath("//*[@value = 'Log In']")).click();
	}

	@Then("^Debo ver la pagina de inicio$")
	public void Debo_ver_la_pagina_de_inicio() {
	    assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'log')]")).isDisplayed());
	}

	@Then("^Debo ver un mensaje de bienvenida$")
	public void Debo_ver_un_mensaje_de_bienvenida() {
	    assertTrue(driver.findElement(By.id("flash")).getText().contains("logged in"));
	}

	@Then("^Debo ver un mensaje de error$")
	public void Debo_ver_un_mensaje_de_error() {
		assertTrue(driver.findElement(By.id("flash")).getText().contains("The username or password you entered are incorrect"));

	}

}
