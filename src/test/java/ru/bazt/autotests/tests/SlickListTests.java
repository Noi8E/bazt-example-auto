package ru.bazt.autotests.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("SlickListTests")
public class SlickListTests extends TestBase {

    @Test
    @Description("Проверка работоспособности карусели на главной")
    @DisplayName("Карусель на главной странице работает")
    void slickTests() {
        step("Open main page", () ->
                open(""));
        step("На странице не виден блок с каруселью", () -> {
            $(".service_auto").shouldNot(visible);
        });
        step("навести курсор на элемент", () -> {
            $(".service_title").hover();
        });
        step("проверяем что появилась карусель", () -> {
            $(".service_auto").should(visible);
        });
        step("делаем двойной клик по стрелке в scrollView", () -> {
            $x("//button[@type='button' and contains(@aria-label, 'Next')]").should(visible).click();
        });
        step("Клик по появившемуся элементу", () -> {
            $("[aria-describedby='slick-slide04'").click();
        });
    }
}