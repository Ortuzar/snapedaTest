package core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelpers {

    WaitHelpers wait = new WaitHelpers();

    public void select(WebDriver driver, By element, String value){
        try{

            if(value != "") {
                Select list = new Select(driver.findElement(element));
                list.selectByVisibleText(value);
            }
        }catch(Exception e){
            System.out.println("DropDownHelpers " + e);

        }
    }
}
