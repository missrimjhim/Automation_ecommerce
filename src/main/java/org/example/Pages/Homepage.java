package org.example.Pages;

import jdk.javadoc.doclet.Reporter;
import org.example.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.manager.SeleniumManagerOutput;


public class Homepage extends BaseClass {
    WebDriver driver;
    //elements of the homepage
    By All= By.xpath("//*[@id='nav-hamburger-menu']");
    By close=By.className("nav-sprite hmenu-close-icon");
    By Fresh=By.id("nav-link-groceries");
    By Sell=By.className("nav-a  ");
    By Best_Seller=By.xpath("//a[text()='Best Sellers']");

    //constructor called when page is initialized
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //methods operating on the elements
    public void Navigate(){
        setUp();
    }
    public void clickOnAllmenu(){
        driver.findElement(All).click();
    }
    public void clickonCloseAllnavMenu(){
        driver.findElement(close).click();
    }
    public void clickOnFresh(){
        driver.findElement(Fresh).click();
    }
    public void clickOnSell(){
        driver.findElement(Sell).click();
    }
    public void clickOnBestSellers(){
        driver.findElement(Sell).click();
    }
    public String getTitle(){
        return driver.getTitle();
    }

}
