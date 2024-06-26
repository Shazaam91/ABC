package com.example.registrationlogindemo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
    public static void main(String[] args) {
        // Specify the path to the Edge WebDriver executable
        System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");

        // Initialize the Edge WebDriver instance
        WebDriver driver = new EdgeDriver();

        // Navigate to your website
        driver.get("http://localhost:8080/index"); // Update with your website URL

        // Perform actions on your website

        // Example: Click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        // Example: Fill in the login form and submit
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("ravindu.kasun96.com"); // Replace with actual email
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123456"); // Replace with actual password
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        // Example: Wait for the login process and assert if the user is redirected to the dashboard
        // You can use WebDriverWait to wait for specific conditions before proceeding
        // For simplicity, let's assume a specific element is present on the dashboard
        WebElement dashboardTitle = driver.findElement(By.xpath("//h1[contains(text(),'appointment')]"));
        if (dashboardTitle.isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the WebDriver instance
        driver.quit();
    }
}
