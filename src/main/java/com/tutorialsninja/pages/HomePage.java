package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By mouseHoverDesktop = By.linkText("Desktops");
    By mouseHoverLaptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By mouseHoverComponents = By.linkText("Components");

    public void mouseHoverAndClickDesktops() {
        mouseHoverAndClickOnElement(mouseHoverDesktop);
    }
    public void mouseHoverAndClickLaptopsAndNotebooks(){
        mouseHoverAndClickOnElement(mouseHoverLaptopsAndNotebooks);
    }
    public void mouseHoverAndClickComponents(){
        mouseHoverAndClickOnElement(mouseHoverComponents);
    }
    public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }
    public void getDeskTopText() {
        String expectedText = "Components";
        WebElement actualElement = driver.findElement(By.xpath("//h2[contains(text(),'Components')]"));
        String actualText = actualElement.getText();

    }
}

