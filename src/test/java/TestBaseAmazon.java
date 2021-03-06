import com.codeborne.selenide.Selenide;
import com.fraido.amazon.BaseConfig;
import com.fraido.amazon.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBaseAmazon {
    static BaseConfig config = new BaseConfig();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ArticlePage articlePage = new ArticlePage();
    BasketPage basketPage = new BasketPage();

    private String login = "amazoncustomer2020@gmail.com";
    private String password = "qwerty1234";
    private String article = "iphone 11 256Gb";

    @BeforeAll
    public static void startBrowser() {
        config.beforeTest();
        open("/");
    }

    @Test
    public void openSiteAndAutorization() {
        mainPage.clickLoginButton();
        loginPage.setLogin(login);
        loginPage.clickContinue();
        loginPage.setPassword(password);
        loginPage.clickSignIn();
        mainPage.gamburgerButton();
        mainPage.clickCategory("Electronics & Computers");
        mainPage.clickCategory("Phones & Accessories");
        searchResultPage.clickLink("SIM-Free");
        mainPage.setSearchArticleName(article);
        mainPage.clickSearchButton();
        searchResultPage.selectCheapestArticle();
        String devaceName = articlePage.getTitle();
        articlePage.clickAddToBasket();
        articlePage.goToBasket();
        assertTrue(basketPage.getCheckArticleTitle().equals(devaceName));
        basketPage.clickDeleteArticle();
        assertTrue(basketPage.getEmptyBasketMessage().equals("Your Shopping Basket is empty."));
        mainPage.hoverLoginButton();
        mainPage.clickSingOutButton();
    }

    @AfterAll
    public static void afterTest() {
        Selenide.closeWebDriver();
    }

}
