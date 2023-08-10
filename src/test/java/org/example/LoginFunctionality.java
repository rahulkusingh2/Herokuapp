package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginFunctionality {

    @Test
    public void loginTest() {
        System.out.println("Test started");
//		Create driver
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser opened");
        sleep(1);

//		open  Test page
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        sleep(1);
        driver.manage().window().maximize();
        sleep(1);

        System.out.println("Page is opened");

//		enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        sleep(1);
//		enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        sleep(2);

//		click login button
        WebElement LogInButton = driver.findElement(By.tagName("button"));
        LogInButton.click();

        sleep(1);
//		verification;
//			new url
//			logout button is visible

        WebElement LogOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
//			Successful login message
        WebElement SuccessMessage = driver.findElement(By.cssSelector("div#flash"));
        driver.close();
        System.out.println("Test Finished");

    }

    /**
     * Stop execution for given amount of time
     *
     * @param seconds
     */
    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

