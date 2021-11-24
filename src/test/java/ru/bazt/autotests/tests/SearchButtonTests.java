package ru.bazt.autotests.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchButtonTests extends TestBase {
    @Test
    @Description("Поиск работает")
    @DisplayName("Поиск работает на пустом значении")
    void searchCanWorkOnEmptyRequest() {
        step("Open main page", () ->
                open(mainUrl));
        step("Click on Search - button", () ->
                $(".search_button").shouldBe(visible).click());
        step("Check available search - form", () ->
                $(".sisea-search-form").shouldBe(visible).click());
        step("Put in empty string in search form", () ->
                $("#search").setValue("").pressEnter());
        step("Check empty result", () ->
                $x("//*[contains(text(),'По вашему запросу ничего не найдено.')]").shouldBe(visible));

    }

    @Test
    @Description("Поиск работает")
    @DisplayName("Поиск работает на валидном значении")
    void searchCanWorkOnNonEmptyRequest() {
        step("Open main page", () ->
                open(mainUrl));
        step("Click on Search - button", () ->
                $(".search_button").shouldBe(visible).click());
        step("Check available search - form", () ->
                $(".sisea-search-form").shouldBe(visible).click());
        step("Put in empty string in search form", () ->
                $("#search").setValue("тест").pressEnter());
        step("Check valid result", () ->
                $x("//*[contains(text(),'9 результатов найдено')]").shouldBe(visible));

    }

    @Test
    @Description("Поиск работает")
    @DisplayName("Поиск работает при вводе XSS")
    void searchCanWorkOnXSSInjection() {
        step("Open main page", () ->
                open(mainUrl));
        step("Click on Search - button", () ->
                $(".search_button").shouldBe(visible).click());
        step("Check available search - form", () ->
                $(".sisea-search-form").shouldBe(visible).click());
        step("Put in empty string in search form", () ->
                $("#search").setValue("<script >alert(\"Hello\");</script > \n").pressEnter());
        step("Check xss result", () ->
                $("[value = 'alert(\"Hello\"); ' ]").shouldBe(visible));

    }

}
