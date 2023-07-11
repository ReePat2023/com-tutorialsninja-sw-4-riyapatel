package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends Utility {
    By MyAccountTab = By.xpath("//span[contains(text(),'My Account')]");
    By MyAccountOptions = By.xpath("//div[@id ='top-links']//li[@class='hidden-xs hidden-sm hidden-md']/ul/li");

    By RegisterAccountText = By.xpath("//h1[normalize-space()='Register Account']");

    By ReturningCustomerText = By.xpath("//h2[normalize-space()='Returning Customer']");
    public void clickOnMyAccountTab(){
        clickOnElement(MyAccountTab);
    }
    public void selectMyAccountOptions(String option) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(option)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
        }
    }
    public String getRegisterAccountText(){
        return getTextFromElement(RegisterAccountText);
    }

    public String getReturningCustomerText(){
        return getTextFromElement(ReturningCustomerText);
    }

}
