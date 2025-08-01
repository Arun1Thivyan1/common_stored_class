package anfas_main_classes_for_all_modules;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import anfas.delete_old_screenshotimage_and_extend_report;
import anfas.extendreport;
import anfas.reusablekeyboardactions;
import anfas.send_email_to_the_team_for_extend_report;
import anfas.subclassforxpath;
import anfas.wait_helper;


import uianduxtesting.clean_the_images_in_the_folder;





public class Web_base_class 
{

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    private static ExtentReports extent;
    private static final Logger logger = LogManager.getLogger(Web_base_class.class);

    protected clean_the_images_in_the_folder cleaner = new clean_the_images_in_the_folder();
    
    
    
    
    
    

    public JavascriptExecutor getJs() 
    {
        return (JavascriptExecutor) driver.get();
    }

    protected void startTest(String testName) 
    {
        extentTest.set(extent.createTest(testName));
    }

    public static ExtentTest getExtentTest() 
    {
        return extentTest.get();
    }

    // ---------------- SUITE LEVEL ------------------

    
    
    
    
    
    
    
    @BeforeSuite
    public void setupExtentReport()
    {
        extent = extendreport.getExtentReports();
        extent.setSystemInfo("Tester", "ARUN THIVYAN");
        logger.info("ExtentReport initialized once for the suite.");
    }
    
    
    
    

    @AfterSuite
    public void tearDownExtentReport() {
        try {
            if (extent != null) {
                extent.flush();
                logger.info("Extent report flushed.");
                send_email_to_the_team_for_extend_report.sendEmailWithReport();
                logger.info("Report sent to the team.");
                
                

                
                
                
                
                
            }
        } catch (Exception e) {
            logger.error("Failed to send the email report: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    

    // ---------------- CLASS LEVEL ------------------

    @BeforeClass
    
    
    //new
    @Parameters({"browser", "viewport"})
    
    
    
    
    
    
    
    
    
    //old
  //  public void launchbrowser() throws InterruptedException 
    
    
    //new
    public void launchbrowser(String browser,String viewport) throws InterruptedException 
    
    {
    	
    	
        // Clean screenshots and diff images
        cleaner.cleanDirectory("/Users/apple/eclipse-workspace/all_pro_maj_flow_automation/difference_images");
        
        cleaner.cleanDirectory("/Users/apple/eclipse-workspace/all_pro_maj_flow_automation/screenshot_images");
        
        delete_old_screenshotimage_and_extend_report.deleteFilesInFolder("/Users/apple/eclipse-workspace/all_pro_maj_flow_automation/screenshot_images");
        
        delete_old_screenshotimage_and_extend_report.deleteFilesInFolder("test-output");

        System.setProperty("file.encoding", "UTF-8");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       //new 
        
        
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver-mac-x64/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver.set(new ChromeDriver(options));
            logger.info("Chrome browser launched.");
        } 
        else if (browser.equalsIgnoreCase("safari")) 
        {
            // Enable Safari's Allow Remote Automation in Safari > Develop menu
            driver.set(new SafariDriver());
            logger.info("Safari browser launched.");
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid browser value: " + browser);
        }
        
        
        
        
        
        
        
        
     // ✅ Set viewport size if mobile
        if (viewport.equalsIgnoreCase("mobile")) {
            driver.get().manage().window().setSize(new Dimension(400, 800));
            logger.info("Viewport set to mobile size: 400x800.");
        } else {
            driver.get().manage().window().maximize();
            logger.info("Viewport set to full desktop size.");
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
 
        
        /////make it dynamic//////
        
     
        
        driver.get().get("https://pms.annztech.com/");
        
    
    

        wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(75)));

        logger.info("Browser launched and navigated successfully.");
    }

    
    
    
    
    
    
    
    
    
    
    @AfterClass
    public void teardown() 
    {
//        if (driver.get() != null) {
//            driver.get().quit();
//            logger.info("Browser closed.");
//        }
    }
}
