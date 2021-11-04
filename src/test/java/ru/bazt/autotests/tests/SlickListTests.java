package ru.bazt.autotests.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class SlickListTests extends TestBase {

    @Test
    @Description("SlickListTests")
    @DisplayName("Карусель на главной странице работает")
    void slickTests() {
        step("Open main page", () ->
                open(mainUrl));
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
            $x("//button[@type='button' and contains(@aria-label, 'Next')]").should(visible).doubleClick();
        });
        step("Клик по появившемуся элементу", () -> {
            $(".service_grey").scrollTo().$("[href*='services/gov/audit-doc-gos'").click();
        });
    }
}
