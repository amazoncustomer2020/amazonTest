package com.fraido.amazon.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $(By.xpath("//input[@id='ap_email']"));
    private SelenideElement passwordField = $(By.xpath("//input[@id='ap_password']"));
    private SelenideElement continueButton = $(By.xpath("//input[@id='continue']"));
    private SelenideElement signInButton = $(By.xpath("//input[@id='signInSubmit']"));


    public void setLogin(String login)
    {
        loginField.clear();
        loginField.val(login);
    }
    public void setPassword(String password)
    {
        passwordField.clear();
        passwordField.val(password);
    }
    public void clickContinue()
    {
        continueButton.click();
    }
    public void clickSignIn()
    {
        signInButton.click();
    }
}
