package org.example.hw_lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Authorization {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.nexusmods.com");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains( "nexusmods"));

        WebElement goToAuthorization = driver.findElement(By.id("login"));
        goToAuthorization.click();

        WebElement emailInputField = driver.findElement(By.id("user_login"));
        emailInputField.click();
        emailInputField.sendKeys("testlogintestlogin123@yandex.ru");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.click();
        passwordInputField.sendKeys("qwerty123456qwerty123456qwertY");

        WebElement authorization = driver.findElement(By.name("commit"));

        driver.quit();
    }
}
