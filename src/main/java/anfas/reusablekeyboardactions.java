package anfas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class reusablekeyboardactions 
{

    

    
    public static void clickElement(WebDriver driver, By locator) {
        WebElement element = wait_helper.getVisibleElement(locator);
        element.click();
    }
    

    
 
    
   
        public static void enterText(WebDriver driver, By locator, String value) 
        {
        	
          
            
            
            WebElement element = wait_helper.getVisibleElement(locator);
            element.click();
            element.clear();
            element.sendKeys(value);
        }
    
    
    
 
    
    
    public static void uploadFile(WebDriver driver, By locator, String filePath) {
        WebElement element = wait_helper.getVisibleElement(locator);
        element.sendKeys(filePath);
    }
    
 
    
    public static void selectDropdownValue(WebDriver driver, By dropdownLocator, By valueLocator) throws InterruptedException {
        clickElement(driver, dropdownLocator);
        Thread.sleep(4000);
        clickElement(driver, valueLocator);
    }
    
    
    
    
    
    //to get text
    
    
    public static String getElementText(WebDriver driver, By locator) {
        WebElement element = wait_helper.getVisibleElement(locator);
        return element.getText().trim();  // trim to remove unwanted whitespace
    }
    
    
//    String actualHeading = reusablekeyboardactions.getElementText(driver.get(), By.xpath(Xpath_for_suber_captain_management.heading_locator));
//
//    // Print the heading (optional)
//    System.out.println("Captured heading: " + actualHeading);
//
//    // Validate against expected
//    String expectedHeading = "Captain Management";
//    Assert.assertEquals(actualHeading, expectedHeading, "❌ Heading text mismatch!"); 
    
    
    
    
    
    
    
    
    
    
    
    
    
    //to get text reusable
    
    public static void verifyElementText(WebDriver driver, By locator, String expectedText) {
        String actualText = reusablekeyboardactions.getElementText(driver, locator);
        Assert.assertEquals(actualText.trim(), expectedText, "Text does not match for element: " + locator);
        System.out.println("✅ Text verified successfully for element: " + locator + " → " + actualText);
    }
    
    
    
    
    
    
    
    
    
    
    

}
