package tests.download;

import core.helpers.WaitHelpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import pom.download.DownloadPage;
import core.helpers.ClickHelpers;
import org.testng.annotations.Test;
import tests.Hooks;

import java.io.File;
import java.util.ArrayList;


public class Download extends Hooks {

    ClickHelpers click = new ClickHelpers();
    DownloadPage downloadPage = new DownloadPage();
    WaitHelpers waitHelpers = new WaitHelpers();

    @Test
    public void test0001_Download() throws InterruptedException {

        //Download Types
        ArrayList<String> downloadFormats = new ArrayList<String>();
        downloadFormats.add("Altium");
        downloadFormats.add("Circuit Studio");
        downloadFormats.add("CR-8000/5000 (Beta)");
        downloadFormats.add("DesignSpark PCB");
        downloadFormats.add("DipTrace");
        downloadFormats.add("EAGLE");
        downloadFormats.add("Easy-PC (Beta)");
        downloadFormats.add("eCADSTAR (Beta)");
        downloadFormats.add("ExpressPCB Plus");
        downloadFormats.add("Autodesk Fusion 360");
        downloadFormats.add("KiCad");
        downloadFormats.add("OrCAD / Allegro");
        downloadFormats.add("PADS / DxDesigner");
        downloadFormats.add("P-CAD");
        downloadFormats.add("PCB123");
        downloadFormats.add("Proteus 8.9 and later");
        downloadFormats.add("Pulsonix");
        downloadFormats.add("TARGET 3001!");

        //iterate list of formats
        for (int counter = 0; counter < downloadFormats.size(); counter++) {

            //Open pop up / formats
            waitHelpers.waitClickeable(driver, downloadPage.downloadButton());
            click.click(driver, downloadPage.downloadButton());

            //Download all formats
            By elementFormatName = downloadPage.downloadFormat(downloadFormats.get(counter));

            //Click download - format by format
            waitHelpers.waitClickeable(driver, elementFormatName);
            click.click(driver, elementFormatName);

            //Wait 15 seconds
            Thread.sleep(15000);

            //Check file
            File folder = new File(System.getProperty("user.dir"));
            //List the files on that folder
            File[] listOfFiles = folder.listFiles();
            boolean found = false;
            File f = null;
            //Look for the file in the files
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    System.out.println("File " + listOfFile.getName());
                    if (fileName.matches(listOfFile.getName())) {
                        f = new File(fileName);
                        found = true;
                    }
                }
            }
            Assert.assertTrue(found, "Downloaded document is not found");
            f.deleteOnExit();

            //close pop up
            click.click(driver, downloadPage.closeModal());

        }
    }
}