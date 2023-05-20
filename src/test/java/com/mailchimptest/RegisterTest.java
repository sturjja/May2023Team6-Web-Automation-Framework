package com.mailchimptest;

import
from selenium import webdriver
from selenium.webdriver.common.by import By
public class RegisterTest {


# Set up the WebDriver (ensure you have the appropriate WebDriver executable in your PATH)
    driver = webdriver.Chrome()

            # Open Mailchimp homepage
driver.get("https://mailchimp.com")

        # Find and click the "Sign Up Free" button
            sign_up_button = driver.find_element(By.LINK_TEXT, "Sign Up Free")
sign_up_button.click()

        # Verify that the registration page is accessible by checking the page title or URL
    expected_title = "Create Your Free Account | Mailchimp"
    expected_url = "https://login.mailchimp.com/signup/"
    actual_title = driver.title
            actual_url = driver.current_url

if expected_title in actual_title and expected_url in actual_url:
    print("Registration page is accessible")
else:
    print("Registration page is not accessible")

# Close the browser
driver.quit()
}
