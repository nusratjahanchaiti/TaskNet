package net.javaguides.todoapp.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class TaskNetFullTest {

    public static void main(String[] args) {

        // 1️⃣ Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\USER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // Signup

            driver.get("http://localhost:9595/Todo_App/register/register.jsp");
            System.out.println("Opened Signup page");

            driver.findElement(By.name("firstName")).sendKeys("TestFirst");
            driver.findElement(By.name("lastName")).sendKeys("TestLast");
            driver.findElement(By.name("username")).sendKeys("testuser");
            driver.findElement(By.name("password")).sendKeys("123456");

            driver.findElement(By.cssSelector("button[type='submit']")).click();
            System.out.println("Signup submitted");

            // Wait for signup success message (because URL may not change)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
            System.out.println("Signup successful");

            // Navigate to login page
            driver.get("http://localhost:9595/Todo_App/login/login.jsp");


            // Login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            driver.findElement(By.name("username")).sendKeys("testuser");
            driver.findElement(By.name("password")).sendKeys("123456");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            System.out.println("Login submitted");

            // Wait until redirected to Todos list
            driver.get("http://localhost:9595/Todo_App/todo/todo.jsp");
            System.out.println("Logged in and Todos list opened");


            // Add Task

            driver.findElement(By.linkText("Add Task")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));

            driver.findElement(By.name("title")).sendKeys("Selenium Test Todo");
            driver.findElement(By.name("description")).sendKeys("Test automation using Selenium");
            new Select(driver.findElement(By.name("isDone"))).selectByVisibleText("Complete");
            driver.findElement(By.name("targetDate")).sendKeys("2025-12-20");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            System.out.println("Todo added");

            wait.until(ExpectedConditions.urlContains("list"));


            // Edit Task
            driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));

            WebElement titleField = driver.findElement(By.name("title"));
            titleField.clear();
            titleField.sendKeys("Updated Selenium Todo");

            driver.findElement(By.cssSelector("button[type='submit']")).click();
            System.out.println("Todo updated");

            wait.until(ExpectedConditions.urlContains("list"));


            // Delete Task

            driver.findElement(By.xpath("(//a[text()='Delete'])[1]")).click();
            System.out.println("Todo deleted");


            // Logout
            
            driver.findElement(By.linkText("Logout")).click();
            System.out.println("Logged out successfully");

        } catch (Exception e) {
            System.out.println("Error during automation: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
