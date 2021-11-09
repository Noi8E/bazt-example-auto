package ru.bazt.autotests.tests;

import io.qameta.allure.Muted;
import jdk.nashorn.internal.ir.annotations.Ignore;
import ru.bazt.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {

    @Test
    @Description("MainPageTests")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://bazt.ru/'", () ->
                open(mainUrl));

        step("Page title should have text 'Главная'", () -> {
            String expectedTitle = "Главная";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
    @Ignore
    //Локально - ок. На виртуальной машине тест падает из-за Yandex-метрики
    @Test
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
