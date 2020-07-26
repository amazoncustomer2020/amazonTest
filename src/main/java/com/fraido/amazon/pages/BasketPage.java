package com.fraido.amazon.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private SelenideElement articleTitle = $(By.xpath("//div[@class='sc-list-item-content']//ul[contains(@class, 'a-unordered-list')]//a[contains(@class, 'sc-product-link')]"));
    private SelenideElement deleteButton = $(By.xpath("//span[@data-action='delete']//input"));
    private SelenideElement emptyBasketMessage = $(By.xpath("//h1[@class='sc-empty-cart-header']"));

    public String getCheckArticleTitle() {
        return articleTitle.text();
    }

    public void clickDeleteArticle() {
        deleteButton.click();
    }

    public String getEmptyBasketMessage() {
        return emptyBasketMessage.text();
    }
}
