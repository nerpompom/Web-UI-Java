package org.example.hw_lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Forum {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.nexusmods.com");

        WebElement communityButton = driver.findElement(By.cssSelector(".rj-nav-news"));
        communityButton.click();

        WebElement forumsButton = driver.findElement(By.cssSelector("css=.rj-header-tray-content:nth-child(5) .rj-news-community:nth-child(1) .rj-mobile-menu-subsection:nth-child(2) span:nth-child(1)"));
        forumsButton.click();


        WebElement chapter = driver.findElement(By.linkText("Network news and announcements"));
        chapter.click();

        WebElement recentlyTopic = driver.findElement(By.xpath("id=forum_table/tbody/tr[2]/td[2]/a"));
        recentlyTopic.click();

        driver.quit();
    }
}
