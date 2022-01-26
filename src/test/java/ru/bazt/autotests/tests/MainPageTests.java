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
    @Description("Перехо на главную страницу происходи успешно")
    @DisplayName("На главной странице есть хэдэр")
    void titleTest() {
        step("Открыть главную страницу", () -> open(""));
        step("На странице есть искомый хэдэр", () -> {
            $x("//title[contains(text(),'Главная')]").should(exist);
        });
    }

    @Test
    @Description("Навигация по шапке в главной работает")
    @DisplayName("Навигация работает")
    void navigationButtonsTest() {
        step("Открыть главную страницу", () -> open(""));
        step("Клик по разделу 'о Нас'", () -> $("[title='О нас']").click());
        step("Клик отработал. Страница открылась", () ->
                $(".grey_block").$("[src=\"assets/img/gazprom.png\"]").shouldBe(visible));
        step("Клик по разделу 'Проекты'", () -> $("[title='Проекты']").click());
        step("Клик отработал. Сраница с проектами открылась", () ->
                $x("//h1[contains(text(),'Выполненные проекты')]").shouldBe(visible));
        step("Клик по разделу 'Услуги'", () ->
                $("[title='Услуги']").click());
        step("Клик отработал. Страница с услугами открылась", () ->
                $x("//div[contains(text(),'Государственным заказчикам')]").shouldBe(visible));
        step("Клик по разделу 'Новости'", () ->
                $("[title='Новости']").click());
        step("Клик отработал. Страница с новостями открылась", () ->
                $x("//h1[contains(text(),'Новости')]").shouldBe(visible));
        step("Клик по разделу с Контактами", () ->
                $("[title='Контакты']").click());
        step("Клик отработал. Страница с контактами открылась", () ->
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
