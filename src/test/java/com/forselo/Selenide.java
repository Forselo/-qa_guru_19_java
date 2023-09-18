package com.forselo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Selenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void checkingForJUnit5CodeInSelenide() {

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".Header-old").$(byText("Solutions")).hover();
        $(".border-bottom").$(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));

    }

    @Test
    void selenideSearchPagesSoftAssertions() {

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $$(".wiki-more-pages-link").first().$("[type='button']").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(".Truncate", 16).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));
     }

    }


/* 1. Есть разница между $("h1 div"); и $("h1").$("div"); Поиск может привести к разным результатам в случае,
 если есть два h1. Первый из них пустой, а во втором есть div.
$("h1 div") - найдет div внутри второго h1.
$("h1").$("div") - сначала найдет первый h1 и уже в нем будет искать div. Т.к. в первом h1 ничего нет,
то элемент не будет найден - возникнет ошибка.*/