package pom.download;

import core.helpers.ClickHelpers;
import core.helpers.SendKeyHelpers;
import org.openqa.selenium.By;

public class DownloadPage {

    public By downloadButton(){
        return By.xpath("//a/h2[contains(text(), 'Symbol')]");
    }
    public By downloadFormat(String format){
        return By.xpath("//ul[@id='orange-gradient-list']//a[contains(text(), '"+format+"')]");
    }
    public By closeModal(){
        return By.xpath("//div[@class='modal-left']/i[contains(@class, 'modal-close')]");
    }


}
