package core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendKeyHelpers {

    WaitHelpers wait = new WaitHelpers();

    public void write(WebDriver driver, By element, String value){
        try{
            wait.waitClickeable(driver, element);
            driver.findElement(element).sendKeys(value);

        }catch(Exception e){
            System.out.println("SendKeyHelpers " + e);

        }
    }
}
