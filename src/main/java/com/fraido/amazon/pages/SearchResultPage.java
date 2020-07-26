package com.fraido.amazon.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    List<Double> price = new ArrayList<>();
    ElementsCollection phonesPrice =  $$(By.xpath("//div[@class='a-section a-spacing-medium']//span[@class='a-price']"));

    public SelenideElement getCheaperestArticle() {
        price = phonesPrice.stream()
                .map(s -> Double.parseDouble(s.$(By.xpath(".//span[@class='a-price-whole']")).text()+"."+s.$(By.xpath(".//span[@class='a-price-fraction']")).text()))
                .collect(Collectors.toList());
        Optional<Double> min = price.stream().min(Double::compare);
        return  phonesPrice.find(Condition.matchesText(min.get().toString()));
    }
}
