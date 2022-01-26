package ru.bazt.autotests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchButtonTests extends TestBase {
    @Test
    @DisplayName("Поиск работает на пустом значении")
    void searchCanWorkOnEmptyRequest() {
        step("Открыть страницу с поиском", () -> open("/search"));
        step("Форма поиска отображается на странице", () -> $(".sisea-search-form").shouldBe(visible).click());
        step("Отправить поисковой запрос без аргументов", () -> $("#search").setValue("").pressEnter());
        step("Отображается корректный аллерт", () -> $x("//*[contains(text(),'По вашему запросу ничего не найдено.')]").shouldBe(visible));

    }

    @Test
    @DisplayName("Поиск работает на валидном значении")
    void searchCanWorkOnNonEmptyRequest() {
        step("Открыть страницу с поиском", () -> open("/search"));
        step("Форма поиска отображается на странице", () -> $(".sisea-search-form").shouldBe(visible).click());
        step("Отправить поисковой запрос без аргументов", () -> $("#search").setValue("тест").pressEnter());
        step("Отображается корректный результат поиска", () -> $x("//*[contains(text(),'9 результатов найдено')]").shouldBe(visible));

    }

    @Test
    @DisplayName("Поиск работает при вводе XSS")
    void searchCanWorkOnXSSInjection() {
        step("Открыть страницу с поиском", () -> open("/search"));
        step("Форма поиска отображается на странице", () -> $(".sisea-search-form").shouldBe(visible).click());
        step("Отправить поисковой запрос без аргументов", () -> $("#search").setValue("<script >alert(\"Hello\");</script > \n").pressEnter());
        step("Отображается корректный результат поиска", () -> $("[value = 'alert(\"Hello\"); ' ]").shouldBe(visible));
    }
}
