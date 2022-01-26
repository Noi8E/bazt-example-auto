package ru.bazt.autotests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Feature("SlickListTests")
public class SlickListTests extends TestBase {

    @Test
    @Description("Проверка работоспособности карусели на главной")
    @DisplayName("Карусель на главной странице работает")
    void slickTests() {
        step("Открыть главную страницу", () ->
                open(""));
        step("На странице не виден блок с каруселью", () -> {
            $(".service_auto").shouldNot(visible);
        });
        step("Навести курсор на элемент", () -> {
            $(".service_title").hover();
        });
        step("Проверить что появился элемент с каруселью", () -> {
            $(".service_auto").should(visible);
        });
        step("Сделать двойной клик по стрелке в scrollView", () -> {
            $x("//button[@type='button' and contains(@aria-label, 'Next')]").should(visible).click();
        });
        step("Клик по появившемуся элементу", () -> {
            $("[aria-describedby='slick-slide04'").click();
        });
    }
}