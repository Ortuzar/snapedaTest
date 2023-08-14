package core.helpers;

import core.utils.GetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelpers {

    GetProperty property = new GetProperty();


    public void waitClickeable(WebDriver driver, By element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(property.getConfProperties("EXPLICIT_WAIT"))));
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch(Exception e){
            System.out.println("WaitHelpers " + e);

        }
    }

    public void waitVisible(WebDriver driver, WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(property.getConfProperties("EXPLICIT_WAIT"))));
            wait.until(ExpectedConditions.visibilityOf(element));

        }catch(Exception e){
            System.out.println("WaitHelpers " + e);

        }
    }
}
