
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Wordpress.Wordpress;

public class App {
    public static void main(String[] args) {
        // Create a ChromeDriver instance
        ChromeDriver driver = new ChromeDriver();
        try {
            // Navigate to the WordPress site
            driver.get("https://avinash.wisdmlabs.net/wp-admin");

            // WordPress obj = new WordPress();
            Wordpress obj = new  Wordpress();

            // Log in to WordPress
            obj.loginToWordPress(driver, "wisdmlabs", "TWUvc9vQgIHPCMsQ");

            // Test post functionality
            // obj.testPost(driver);

            // Test page functionality
            // obj.testPage(driver);

            // Test user functionality
            // obj.testUser(driver);
            // Thread.sleep(3000);

            // Test Media Uploads
            // obj.testMediaUpload(driver);

            // Test Responsiveness
            // obj.testResponsiveness(driver);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

    }
}
