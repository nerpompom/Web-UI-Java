package org.example.hw_lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Video {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.nexusmods.com");

        WebElement mediaButton = driver.findElement(By.cssSelector(".rj-nav-media > .nmicon-chevron-down"));
        mediaButton.click();

        WebElement latestVideoButton = driver.findElement(By.cssSelector(".rj-header-tray-content:nth-child(4) .rj-media-videos:nth-child(3) .rj-mobile-menu-subsection:nth-child(2) span:nth-child(1)"));
        latestVideoButton.click();

        WebElement video = driver.findElement(By.xpath("//ul[1]/li[1]/div[1]/a"));
        video.click();

        driver.quit();
    }
}
