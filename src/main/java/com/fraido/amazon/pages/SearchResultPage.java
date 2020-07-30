package com.fraido.amazon.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {
    List<Double> price = new ArrayList<>();
    private ElementsCollection articles = $$(By.xpath(("//div[@data-component-type='s-search-result']")));
    private ElementsCollection leftMenuLinks = $$(By.xpath("//div[@class='left_nav browseBox']//a"));

    private List<SelenideElement> getPhones() {
        List<SelenideElement> phones = articles.stream()
                .filter(p -> p.$(By.xpath(".//h2")).text().contains("Apple iPhone 11")).collect(Collectors.toList());
        phones = phones.stream().filter(p -> p.$(By.xpath(".//h2")).text().contains("Black")).collect(Collectors.toList());
        phones = phones.stream().filter(p -> p.$(By.xpath(".//h2")).text().contains("256")).collect(Collectors.toList());
        return phones;
    }

    public void selectCheapestArticle() {
        price = getPhones().stream()
                .map(s -> Double.parseDouble(s.$(By.xpath(".//span[@class='a-price-whole']")).text().replace(",", "") + "." + s.$(By.xpath(".//span[@class='a-price-fraction']")).text()))
                .collect(Collectors.toList());

        Optional<Double> min = price.stream().min(Double::compare);
        String value = changePrice(min.get().toString());
        SelenideElement element = articles.find(Condition.matchesText(value));
        element.shouldBe(Condition.visible).$(By.xpath(".//h2")).click();
    }

    public void clickLink(String linkName) {
        Optional<SelenideElement> element = leftMenuLinks.stream()
                .filter(l -> l.text().contains(linkName))
                .findFirst();
        element.get().shouldBe(Condition.visible).click();
    }

    private String changePrice(String price) {
        if (price.length() >= 7) {
            price = price.substring(0, 1) + "," + price.substring(1);
        }
        return price;
    }
}
