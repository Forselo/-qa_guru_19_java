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
    }

    @Test
    void checkingForJUnit5CodeInSelenide() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").$(byText("SoftAssertions")).click();
        $(".Layout-main").shouldHave(text("3. Using JUnit5 extend test class:"));

    }

    @Test
    void selenideSearchPagesSoftAssertions() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$(".wiki-more-pages-link").first().$("[type='button']").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(".Truncate", 16).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));

        }

    }


