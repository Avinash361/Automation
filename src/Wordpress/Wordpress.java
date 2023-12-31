package Wordpress;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Wordpress {
   public void loginToWordPress(ChromeDriver driver, String username, String password) {
        // Find the username and password fields and fill them with your login
        // credentials
        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Find and click the "Log In" button
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();
    }

   public void testResponsiveness(ChromeDriver driver) {
        driver.get("https://avinash.wisdmlabs.net/");

        try {
            // Test responsiveness at desktop size
            driver.manage().window().setSize(new Dimension(1366, 768));
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            driver.manage().window().setSize(new Dimension(768, 1024));
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            Thread.sleep(3000);
            driver.manage().window().setSize(new Dimension(375, 812));
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            driver.quit();
        }

    }

   public void testMediaUpload(ChromeDriver driver) {
        try {
            driver.get("https://avinash.wisdmlabs.net/wp-admin/media-new.php");
            WebElement plupload_browse_button = driver.findElement(By.id("async-upload"));

            plupload_browse_button.sendKeys("C:\\Users\\avina\\OneDrive\\Pictures\\Screenshots\\Test.png");

            WebElement upload_button = driver.findElement(By.id("html-upload"));
            upload_button.click();

            Thread.sleep(1000);

            WebElement element = driver.findElement(By.cssSelector("[aria-label='Test']"));
            element.click();
            Thread.sleep(1000);

            WebElement deleteButton = driver.findElement(By.className("delete-attachment"));
            deleteButton.click();

            Thread.sleep(1000);

            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(2000);

            Thread.sleep(5000);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

   public void testPost(ChromeDriver driver) {
        try {
            // Go to the "Posts" page in the WordPress admin
            driver.get("https://avinash.wisdmlabs.net/wp-admin/post-new.php");

            // Find the title field and edit its content
            WebElement titleField = driver.findElement(
                    By.cssSelector(".edit-post-visual-editor__post-title-wrapper [contenteditable='true']"));
            titleField.clear(); // Clear any existing text (optional)
            titleField.sendKeys("New Testing Post");

            // Find the "Publish" button using its class name and click it to publish the
            // post
            WebElement publishButton1 = driver.findElement(By.cssSelector(".editor-post-publish-panel__toggle"));
            publishButton1.click();
            // published post
            WebElement publishButton2 = driver.findElement(By.cssSelector(".editor-post-publish-button"));
            publishButton2.click();

            // Wait for the "View Post" link to be visible and click it to view the
            Thread.sleep(7000);

            WebElement viewPostLink = driver.findElement(By.partialLinkText("View Post"));
            viewPostLink.click();

            // successfully created a new testing post on the WordPress site

            // Find the Comment field and edit its content
            WebElement comment = driver.findElement(By.id("comment"));
            comment.sendKeys("Test a Comment");
            WebElement postComment = driver.findElement(By.id("submit"));
            postComment.submit();
            ;

            Thread.sleep(5000);
            // Go to the "Posts" page in the WordPress admin
            driver.get("https://avinash.wisdmlabs.net/wp-admin/edit.php");

            // Find the post created (based on the title used)
            WebElement postToDelete = driver.findElement(By.partialLinkText("New Testing Post"));

            // Use Actions class to simulate the hover action on the post
            Actions actions = new Actions(driver);
            actions.moveToElement(postToDelete).build().perform();

            // Find and click the "Trash" link to delete the post
            WebElement trashLink = driver.findElement(By.xpath("//span[@class='trash']/a"));
            trashLink.click();

            Thread.sleep(3000);
            System.out.println("Test of Post Successfully Done");
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }

   public void testPage(ChromeDriver driver) {
        try {
            // Go to the "Pages" page in the WordPress admin
            driver.get("https://avinash.wisdmlabs.net/wp-admin/post-new.php?post_type=page");

            // Find the title field and edit its content
            WebElement titleField = driver.findElement(
                    By.cssSelector(".edit-post-visual-editor__post-title-wrapper [contenteditable='true']"));
            titleField.clear(); // Clear any existing text (optional)
            titleField.sendKeys("New Testing Page");

            // Find the "Publish" button using its class name and click it to publish the
            // post
            WebElement publishButton1 = driver.findElement(By.cssSelector(".editor-post-publish-panel__toggle"));
            publishButton1.click();
            // published post
            WebElement publishButton2 = driver.findElement(By.cssSelector(".editor-post-publish-button"));
            publishButton2.click();

            // Wait for the "View Post" link to be visible and click it to view the
            Thread.sleep(7000);

            WebElement viewPostLink = driver.findElement(By.partialLinkText("View Page"));
            viewPostLink.click();

            // successfully created a new testing post on the WordPress site

            // Go to the "Posts" page in the WordPress admin
            driver.get("https://avinash.wisdmlabs.net/wp-admin/edit.php?post_type=page");

            // Find the post created (based on the title used)
            WebElement postToDelete = driver.findElement(By.partialLinkText("New Testing Page"));

            // Use Actions class to simulate the hover action on the post
            Actions actions = new Actions(driver);
            actions.moveToElement(postToDelete).build().perform();
            // Find and click the "Trash" link to delete the page
            WebElement trashLink = driver.findElement(By.xpath("//span[@class='trash']/a"));
            trashLink.click();

            Thread.sleep(3000);
            System.out.println("Test of Page Successfully Done");

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }

   public void testUser(ChromeDriver driver) {
        try {
            // Go to the "Users" page in the WordPress admin
            driver.get("https://avinash.wisdmlabs.net/wp-admin/user-new.php");

            // Find and click the "Add New" button to create a new user
            WebElement addNewButton = driver.findElement(By.linkText("Add New"));
            addNewButton.click();

            // Find the username field and edit its content
            WebElement usernameField = driver.findElement(By.id("user_login"));
            usernameField.sendKeys("testuser");

            // Find the email field and edit its content
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("testuser@example.com");

            // Find the First Name field and edit its content
            WebElement firstNameField = driver.findElement(By.id("first_name"));
            firstNameField.sendKeys("Test");

            // Find the Last field and edit its content
            WebElement lastNameField = driver.findElement(By.id("last_name"));
            lastNameField.sendKeys("User");

            // Click the "Add New User" button to create the user
            WebElement addUserButton = driver.findElement(By.id("createusersub"));
            addUserButton.click();

            Thread.sleep(3000);

            // Find the post created (based on the title used)
            WebElement postToDelete = driver.findElement(By.partialLinkText("testuser"));

            // Use Actions class to simulate the hover action on the post
            Actions actions = new Actions(driver);
            actions.moveToElement(postToDelete).build().perform();

            // Find and click the "Trash" link to delete the post
            WebElement trashLink = driver.findElement(By.xpath("//span[@class='delete']/a"));
            trashLink.click();

            // Click the "Add New User" button to create the user
            WebElement confirmDeletion = driver.findElement(By.id("submit"));
            confirmDeletion.click();
            System.out.println("Test of User Successfully Done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
