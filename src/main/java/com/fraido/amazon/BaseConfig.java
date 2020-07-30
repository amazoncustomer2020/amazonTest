package com.fraido.amazon;

import com.codeborne.selenide.Configuration;


public class BaseConfig {
     public void beforeTest() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.amazon.co.uk";
        Configuration.timeout = 6000;
    }

    private void setConfiguration(String browserName) throws RuntimeException {
        if (browserName.equals("firefox")) {
            Configuration.browser = browserName;
            Configuration.startMaximized = true;
        }
        else if (browserName.equals("chrome")) {
            Configuration.browser = browserName;
            Configuration.startMaximized = true;
        }
        else
            throw new RuntimeException("Выбранный вид браузера отсутствует: "+ browserName);
    }
}
