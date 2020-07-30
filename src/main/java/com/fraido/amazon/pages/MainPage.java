package com.fraido.amazon.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement loginButton = $(By.xpath("//a[@id='nav-link-accountList']"));
    private SelenideElement searchField = $(By.xpath("//input[@id='twotabsearchtextbox']"));
    private SelenideElement searchButton = $(By.xpath("//div[@class='nav-right']//input"));
    private SelenideElement exitButton = $(By.xpath("//a[@id='nav-item-signout']"));
    private SelenideElement gamburgerButton = $(By.xpath("//a[@id='nav-hamburger-menu']"));
    private SelenideElement selectButton = $(By.xpath("//div[@class='nav-search-scope nav-sprite']"));
    private ElementsCollection links = $$(By.xpath("//a[@class='hmenu-item']"));

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
    public void gamburgerButton() {
        gamburgerButton.shouldBe(Condition.visible).click();
    }
    public void clickCategory(String categoryName) {
        $(By.xpath("//div[@id='hmenu-content']")).shouldBe(Condition.visible).hover();
        Optional<SelenideElement> element = links.stream()
                .filter(l -> l.text().equals(categoryName))
                .findFirst();
        element.get().click();
    }
    public void clickSelectButton() {

        selectButton.click();
    }
}
