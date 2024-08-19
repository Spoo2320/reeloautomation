package org.example;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    WebDriver driver;

   public TestCases(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }  

   public void endTests(){
    System.out.println("End Test: TestCases");
    driver.close();
    driver.quit();
  }

   public void logStatus(String message) {
    System.out.println(message);
  }

     
  public void testCase01(String fullName, String email, String MobileNumber, String password) throws InterruptedException{

        logStatus("Start Test Case: testCase01");

        driver.get("https://dev.reelo.io/signup");

        WebElement fullNameTextBox = driver.findElement(By.id("name"));
        fullNameTextBox.sendKeys(fullName);

        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys(email);

        WebElement mobileNoTextBox = driver.findElement(By.id("number"));
        mobileNoTextBox.sendKeys(MobileNumber);

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys(password);

        WebElement signup = driver.findElement(By.xpath("//span[text()='Sign up today for free']"));
        signup.click();
        
        //user can enter the otp manually.
        
        System.out.println("Please enter the OTP sent to your phone/email and click on create account button");
        //wait for user to enter the otp for one minute
        Thread.sleep(3000);

        


        // after the correct otp is entered we can use the below code to verify if the user is redirected to login page or not

        // String currentURL = driver.getCurrentUrl();
        // if(currentURL.equals("https://dev.reelo.io/login")){
        //     logStatus("testCase01: PASSED");
        // }else{
        //     logStatus("testCase01: FAILED");
        // }     
        
           logStatus("End Test Case: testCase01");

    }

        public void testCase02(String email, String password) throws InterruptedException{
 
            logStatus("Start Test Case: testCase02");

            driver.get("https://dev.reelo.io/login");

            WebElement emailTextBox = driver.findElement(By.id("email"));
            emailTextBox.sendKeys(email);

            WebElement passwordTextBox = driver.findElement(By.id("password"));
            passwordTextBox.sendKeys(password);

            WebElement createAccBtn = driver.findElement(By.xpath("//span[text()='Login to your Reelo account']"));
            createAccBtn.click();

            String url = driver.getCurrentUrl();
            if(url.contains("https://dev.reelo.io/")){            
            logStatus("testCase02: PASSED");
            }else{
                logStatus("testCase02: FAILED");
            }
           
            logStatus("End Test Case: testCase02");


        }

        public void testCase03() throws InterruptedException{

            logStatus("Start Test Case: testCase03: Verifying the functionality of Customer life cycle button");

            WebElement custBtn = driver.findElement(By.xpath("//span[text()='Customer life cycle']"));
            custBtn.click();

            Thread.sleep(3000);

            WebElement custmerlife = driver.findElement(By.xpath("//h1[contains(text(), 'Customer lifecycle of')]"));

            if(custmerlife.getText().contains("Customer lifecycle of")) {

                 System.out.println("testCase03: PASSED");

            } else{
                System.out.println("testCase03: FAILED");
            }  
            
            logStatus("End Test Case: testCase03");
        
          }


          public void testCase04() throws InterruptedException{
            logStatus("Start Test Case: testCase04: Verifying the functionality of Book a demo button");

            driver.get("https://dev.reelo.io/");

            WebElement bookdemobtn = driver.findElement(By.xpath("//span[text()='Book a Demo']"));
            if(bookdemobtn.isEnabled()){
                System.out.println("Book a demo button is enabled");
                bookdemobtn.click();
                Thread.sleep(3000);

                WebElement header1 = driver.findElement(By.xpath("//h1[contains(text(), 'Connect on a Free Call with our')]"));
                if(header1.getText().contains("Connect on a Free Call with our")){
                    System.out.println("testCase04: PASSED");
                }else{
                    System.out.println("testCase04: FAILED");
                }

                WebElement close = driver.findElement(By.xpath("//img[@title='close']"));
                close.click();

            }else{
                System.out.println("testCase04: FAILED since button is disabled");
            }

            logStatus("End Test Case: testCase04");


          }

          public void testCase05(){
            logStatus("Start Test Case: testCase05: Verifying the functionality of Notifications button");

            driver.get("https://dev.reelo.io/");

            WebElement notificationbtn = driver.findElement(By.id("hw-notification"));
            if(notificationbtn.isEnabled()){
                notificationbtn.click();
                String url = driver.getCurrentUrl();
                if(url.equals("https://dev.reelo.io/notifications")){
                    System.out.println("testCase05: PASSED");
                
                }   else{
                    System.out.println("testCase05: FAILED");
                }             
            }else{
                System.out.println("testCase05: FAILED: notification button disbled");
            
            }

          }

        
    }