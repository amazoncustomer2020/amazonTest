package com.fraido.amazon.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement loginButton = $(By.xpath("//a[@id='nav-link-accountList']"));
    private SelenideElement searchField = $(By.xpath("//input[@id='twotabsearchtextbox']"));
    private SelenideElement searchButton = $(By.xpath("//div[@class='nav-right']//input"));
    private SelenideElement exitButton = $(By.xpath("//a[@id='nav-item-signout']"));

    public void clickLoginButton() {
        loginButton.click();
    }
    public void hoverLoginButton() {
        loginButton.hover();
    }
    public void setSearchArticleName(String articleName)
    {
        searchField.clear();
        searchField.val(articleName);
    }
    public void clickSearchButton() {
        searchButton.click();
    }
    public void clickSingOutButton() {
        exitButton.click();
    }
}
