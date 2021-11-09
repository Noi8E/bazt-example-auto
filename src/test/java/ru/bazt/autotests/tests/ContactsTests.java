package ru.bazt.autotests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Feature("ContactsTests")
public class ContactsTests extends TestBase {

    @Test
    @Description("Пользователь может перейти на страницу с контактами с главной страницы")
    @DisplayName("Страница с контактами работает")
    void contactsTests() {
        step("Open main page", () ->
                open(mainUrl));
        step("На странице отображается шапка", () -> {
            $(".header_auto").should(visible);
        });
        step("Кликнуть на кнопку с контактами", () -> {
            $(".navigation").should(visible);
            $("a[href='contacts']").click();
        });
        step("На странце контактов отображается корректный номер телефона", () -> {
            $x("//div[@class='content']/div[@class='telephone']").shouldHave(text("+7 (495) 646 11 75"));
        });
    }
}
