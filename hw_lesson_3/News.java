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

public class News {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.nexusmods.com");

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlContains( "nexusmods"));


        WebElement communityButton = driver.findElement(By.cssSelector(".rj-nav-news"));
        communityButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlContains( "nexusmods"));

        WebElement siteNewsButton = driver.findElement(By.cssSelector(".rj-header-tray-content:nth-child(5) .rj-news-categories:nth-child(3) .rj-mobile-menu-subsection:nth-child(2) span:nth-child(1)"));
        siteNewsButton.click();

        WebElement news = driver.findElement(By.xpath("div[contains(concat(' ', @class, ' '), ' mod-tile-left ')]/div[1]/div[1]/a[2]"));
        news.click();

        driver.quit();

    }

}
