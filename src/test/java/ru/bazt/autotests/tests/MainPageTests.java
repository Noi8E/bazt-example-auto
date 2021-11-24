package ru.bazt.autotests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Feature;
import io.qameta.allure.Muted;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import ru.bazt.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("MainPageTest")
public class MainPageTests extends TestBase {

    @Test
    @Description("Браузер может открыть сайт")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://bazt.ru/'", () ->
                open(mainUrl));
        step("Page title should have text 'Главная'", () -> {
            $x("//head/meta[6]").shouldBe(exist);
        });
    }

    @Test
    @Description("Навигация по шапке в главной работает")
    @DisplayName("Навигация работает")
    void navigationButtonsTest() {
        step("Open url 'https://bazt.ru/'", () ->
                open(mainUrl));
        step("Check about-us button", () ->
                $("[title='О нас']").click());
        step("About Us - page is working", () ->
                $(".grey_block").$("[src=\"assets/img/gazprom.png\"]").shouldBe(visible));
        step("Check projects -  button", () ->
                $("[title='Проекты']").click());
        step("Projects - page is working", () ->
                $x("//h1[contains(text(),'Выполненные проекты')]").shouldBe(visible));
        step("Check Services -  button", () ->
                $("[title='Услуги']").click());
        step("Services - page is working", () ->
                $x("//div[contains(text(),'Государственным заказчикам')]").shouldBe(visible));
        step("Check News -  button", () ->
                $("[title='Новости']").click());
        step("News - page is working", () ->
                $x("//h1[contains(text(),'Новости')]").shouldBe(visible));
        step("Check Contacts -  button", () ->
                $("[title='Контакты']").click());
        step("Contacts - page is working", () ->
                $x("//div[@class='content']/div[@class='telephone']").shouldHave(text("+7 (495) 646 11 75")));


    }


    @Disabled("Локально - ок. На виртуальной машине тест падает из-за Yandex-метрики")
    @Description("MainPageTests")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://bazt.ru/'", () ->
                open("https://bazt.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
