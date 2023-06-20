package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateWordPressUser{

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://wordpress.com/start/user";
        driver.get(baseUrl);
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("anithamaridi99@gmail.com");
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Anitha9M");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("2003@9S4147");
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create your account')]"));
        createAccountButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.quit();
    }
}

