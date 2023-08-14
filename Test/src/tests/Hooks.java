package tests;


import org.openqa.selenium.WebDriver;
import core.utils.GetProperty;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public WebDriver driver = null;
    GetProperty property = new GetProperty();

    @BeforeClass
    public void setUp() throws Exception {
        try {

            String browser = property.getConfProperties("BROWSER");
            String OS = property.getConfProperties("OS");
            ChromeOptions options = new ChromeOptions();

            if (browser.equals("CHROME")) {
                //MAC CONFIG
                if (OS.equals("MAC")) {

                    options.addArguments("--remote-allow-origins=*");
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
                }else if (OS.equals("WINDOWS"))
                    //WINDOWS CONFIG
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
            }

            driver = new ChromeDriver(options);
            //SAVE DRIVER AND WAIT FOR PAGE LOAD
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(property.getConfProperties("IMPLICIT_WAIT")), TimeUnit.SECONDS);
            driver.get(property.getConfProperties("URL"));
            driver.manage().window().maximize();

        }catch(Exception e){
            System.out.println("HOOKS - General Exception " + e);
        }
    }

    @AfterClass
    public void after() {
        try{
           driver.quit();

        }catch(Exception e){
            System.out.println("HOOKS - General Exception " + e);
        }
    }
}
