package br.ce.kaio.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/",
		glue = {"br.ce.kaio.steps","br.ce.kaio.config"},
		tags = {"@funcionais"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false)
public class RunnerFuncionalTeste {

	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://srbarriga.herokuapp.com");
	    driver.findElement(By.id("email")).sendKeys("kaio.dolfini@gmail.com");
	    driver.findElement(By.id("senha")).sendKeys("[kaca0528]");
	    driver.findElement(By.tagName("button")).click();
	    driver.findElement(By.linkText("reset")).click();
	    driver.quit();
	}
}
