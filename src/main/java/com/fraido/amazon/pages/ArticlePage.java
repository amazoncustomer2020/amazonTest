package com.fraido.amazon.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {
    private SelenideElement articleTitle = $(By.xpath("//span[@id='productTitle']"));
    private SelenideElement addToBasketButton = $(By.xpath("//input[@id='add-to-cart-button']"));
    private SelenideElement goToBasketButton = $(By.xpath("//a[@id='nav-cart']"));

    public String getTitle() {
        return articleTitle.text();
    }
    public void clickAddToBasket() {
        addToBasketButton.click();
    }
    public void goToBasket() {
        goToBasketButton.click();
    }
}
