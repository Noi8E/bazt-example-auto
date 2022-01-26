package ru.bazt.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Contacts {
    @Step("Открыть главную страницу")
    public Contacts openMainPage() {
        open("");
        return this;
    }
    @Step("На странице отображается шапка")
    public Contacts headerIsVisible() {
        $(".header_auto").shouldBe(visible);
        return this;
    }
    @Step("Кликнуть на кнопку с контактами")
    public Contacts clickToContactsButton() {
        $(".navigation").shouldBe(visible);
        $("a[href='contacts']").click();
        return this;
    }
    @Step("На странице с контактами отображается корректный номер телефона")
    public void isPhoneNumberVisible() {
        $x("//div[@class='content']/div[@class='telephone']").shouldHave(text("+7 (495) 646 11 75"));
    }
}
